package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.dto.ProcedureDto;
import com.epam.hospital.service.ProcedureService;
import com.epam.hospital.service.impl.ProcedureServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateNewProcedureCommand implements Command {
    private final Logger logger = LogManager.getLogger(CreateNewProcedureCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ProcedureService procedureService = ProcedureServiceImpl.getInstance();

        int patientId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_ID));
        String procedureName = request.getParameter(RequestParameter.PROCEDURE_NAME);
        int userId = Integer.parseInt(request.getParameter(RequestParameter.USER_ID));
        int userRoleId = Integer.parseInt(request.getParameter(RequestParameter.PROCEDURE_ACCESS));
        String specification = request.getParameter(RequestParameter.PROCEDURE_SPECIFICATION);

        ProcedureDto procedureDto = new ProcedureDto(patientId, 0, procedureName, userId, userRoleId,0, specification);

        try {
            if (procedureService.insert(procedureDto) == null) {
                session.setAttribute(SessionAttribute.ERROR, "Invalid data");
                return new CommandResult((String) session.getAttribute(SessionAttribute.URL), RoutingType.REDIRECT);
            }

            session.setAttribute(SessionAttribute.URL, "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_NEW_PROCEDURE_PAGE_COMMAND);

            logger.info("Patient is registered." + procedureName);
            return new CommandResult(Page.NEW_PROCEDURE_PAGE, RoutingType.FORWARD);
        } catch (Exception e) {
            logger.error("Unable to register new user.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}
