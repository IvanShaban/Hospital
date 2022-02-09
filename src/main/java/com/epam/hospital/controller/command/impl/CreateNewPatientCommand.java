package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.dto.PatientDto;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateNewPatientCommand implements Command {
    private final Logger logger = LogManager.getLogger(CreateNewPatientCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        PatientService patientService = PatientServiceImpl.getInstance();

        String name = request.getParameter(RequestParameter.PATIENT_NAME);
        String surname = request.getParameter(RequestParameter.PATIENT_SURNAME);
        String patronymic = request.getParameter(RequestParameter.PATIENT_PATRONYMIC);
        String address = request.getParameter(RequestParameter.PATIENT_ADDRESS);
        String provisionalDiagnosis = request.getParameter(RequestParameter.PATIENT_PROVISIONAL_DIAGNOSIS);
        String allergy = request.getParameter(RequestParameter.PATIENT_ALLERGY);
        String bloodType = request.getParameter(RequestParameter.PATIENT_BLOOD_TYPE);
        String status = request.getParameter(RequestParameter.PATIENT_STATUS);
        int chamberId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_CHAMBER_ID));
        int doctorId = Integer.parseInt(request.getParameter(RequestParameter.USER_ID));
        PatientDto patientDto = new PatientDto(chamberId, doctorId, surname, name, patronymic, provisionalDiagnosis,
                address, 0, status, bloodType, allergy, 0, 0);

        try {
            if (patientService.insert(patientDto) == null) {
                session.setAttribute(SessionAttribute.ERROR, "Invalid data");
                return new CommandResult((String) session.getAttribute(SessionAttribute.URL), RoutingType.REDIRECT);
            }

            session.setAttribute(SessionAttribute.URL, "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_NEW_PATIENT_PAGE_COMMAND);

            logger.info("Patient is registered." + patientDto);
            return new CommandResult(Page.NEW_PATIENT_PAGE, RoutingType.FORWARD);
        } catch (Exception e) {
            logger.error("Unable to register new user.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}
