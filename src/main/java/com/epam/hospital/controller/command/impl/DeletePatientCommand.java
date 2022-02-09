package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeletePatientCommand implements Command {
    private final Logger logger = LogManager.getLogger(DeletePatientCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        PatientService patientService = PatientServiceImpl.getInstance();

        int patientId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_ID));

        try {
            patientService.deletePatient(patientId);
            String url = "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_PATIENTS_PAGE_COMMAND;
            session.setAttribute(SessionAttribute.URL, url);

            return new CommandResult(url, RoutingType.REDIRECT);
        } catch (NumberFormatException e) {
            logger.error("Unable to delete patient.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}