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
import com.epam.hospital.entity.Department;
import com.epam.hospital.entity.Patient;
import com.epam.hospital.service.ChamberService;
import com.epam.hospital.service.DepartmentService;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.ChamberServiceImpl;
import com.epam.hospital.service.impl.DepartmentServiceImpl;
import com.epam.hospital.service.impl.PatientServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToChamberInfoPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        DepartmentService departmentService = DepartmentServiceImpl.getInstance();
        ChamberService chamberService = ChamberServiceImpl.getInstance();
        PatientService patientService = PatientServiceImpl.getInstance();

        int chamberId = Integer.parseInt(request.getParameter(RequestParameter.CHAMBER_ID));
        Chamber chamber = chamberService.findById(chamberId);
        Department department = departmentService.findById(chamber.getDepartmentId());
        List<Patient> patients = patientService.findByChambersId(chamberId);

        int freeBeds = chamber.getBedsNumber() - patients.size();

        session.setAttribute(SessionAttribute.DEPARTMENT_TITLE, department.getTitle());
        session.setAttribute(SessionAttribute.CHAMBER, chamber);
        session.setAttribute(SessionAttribute.CHAMBER_FREE_BEDS, freeBeds);
        request.setAttribute(RequestAttribute.PATIENTS, patients);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_ADMIN_PERSONAL_COMMAND +
                "&" + RequestParameter.CHAMBER_ID + "=" + chamberId);

        return new CommandResult(Page.CHAMBER_INFO_PAGE, RoutingType.FORWARD);
    }
}
