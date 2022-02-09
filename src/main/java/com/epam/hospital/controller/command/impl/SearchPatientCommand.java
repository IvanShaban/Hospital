package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class SearchPatientCommand implements Command {
    private final Logger logger = LogManager.getLogger(SearchPatientCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        PatientService patientService = PatientServiceImpl.getInstance();

        int patientId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_ID));

        try {
            Patient patient = patientService.findById(patientId);
            request.setAttribute(RequestAttribute.PATIENT, patient);
            return new CommandResult(Page.SEARCH_PATIENT_PAGE, RoutingType.FORWARD);
        } catch (NumberFormatException e) {
            logger.error("Unable to get books DTO by search request.", e);
        } catch (Exception e) {
            logger.error("Unable to convert request to UTF-8.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}