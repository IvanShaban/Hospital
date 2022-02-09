package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.entity.Procedure;
import com.epam.hospital.service.ProcedureService;
import com.epam.hospital.service.impl.ProcedureServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchProcedureCommand implements Command {
    private final Logger logger = LogManager.getLogger(SearchPatientCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        ProcedureService procedureService = ProcedureServiceImpl.getInstance();

        int procedureId = Integer.parseInt(request.getParameter(RequestParameter.PROCEDURE_ID));

        try {
            Procedure procedure = procedureService.findById(procedureId);
            request.setAttribute(RequestAttribute.PROCEDURE, procedure);
            return new CommandResult(Page.SEARCH_PROCEDURE_PAGE, RoutingType.FORWARD);
        } catch (NumberFormatException e) {
            logger.error("Unable to get procedure by search request.", e);
        } catch (Exception e) {
            logger.error("Unable to convert request to UTF-8.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}
