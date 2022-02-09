package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.service.ProcedureService;
import com.epam.hospital.service.impl.ProcedureServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteProcedureCommand implements Command {
    private final Logger logger = LogManager.getLogger(DeleteProcedureCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ProcedureService procedureService = ProcedureServiceImpl.getInstance();

        int procedureId = Integer.parseInt(request.getParameter(RequestParameter.PROCEDURE_ID));

        try {
            procedureService.deleteProcedure(procedureId);
            String url = "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_PROCEDURES_PAGE_COMMAND +
                    "&" + RequestParameter.PROCEDURE_ID + "=" + procedureId;
            session.setAttribute(SessionAttribute.URL, url);

            return new CommandResult(url, RoutingType.REDIRECT);
        } catch (NumberFormatException e) {
            logger.error("Unable to delete book.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}