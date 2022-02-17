package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.Chamber;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.PatientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class WriteOutPatientCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        PatientService patientService = PatientServiceImpl.getInstance();

        int patientId = Integer.parseInt(request.getParameter(RequestParameter.PATIENT_ID));
        patientService.writeOutPatient(patientId);

        Chamber chamber = (Chamber) session.getAttribute(SessionAttribute.CHAMBER);
        List<Patient> patients = patientService.findByChambersId(chamber.getId());
        int freeBeds = (int) session.getAttribute(SessionAttribute.CHAMBER_FREE_BEDS);
        session.setAttribute(SessionAttribute.CHAMBER_FREE_BEDS, ++freeBeds);
        request.setAttribute(RequestAttribute.PATIENTS, patients);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.WRITE_OUT_PATIENT_COMMAND);

        return new CommandResult(Page.CHAMBER_INFO_PAGE, RoutingType.FORWARD);
    }
}
