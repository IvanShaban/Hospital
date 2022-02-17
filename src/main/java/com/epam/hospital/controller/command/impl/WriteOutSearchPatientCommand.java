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
import com.epam.hospital.entity.User;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.PatientServiceImpl;
import com.epam.hospital.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteOutSearchPatientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        PatientService patientService = PatientServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        int patientId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_ID));
        patientService.writeOutPatient(patientId);

        Patient patient = patientService.findById(patientId);
        request.setAttribute(RequestAttribute.PATIENT, patient);

        int doctorId = patient.getDoctorsId();
        User user = userService.findById(doctorId);
        request.setAttribute(RequestAttribute.USER, user);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.WRITE_OUT_SEARCH_PATIENT_COMMAND);

        return new CommandResult(Page.SEARCH_PATIENT_PAGE, RoutingType.FORWARD);
    }
}
