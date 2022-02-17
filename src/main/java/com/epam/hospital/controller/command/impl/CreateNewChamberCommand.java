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
import com.epam.hospital.service.ChamberService;
import com.epam.hospital.service.DepartmentService;
import com.epam.hospital.service.PatientService;
import com.epam.hospital.service.impl.ChamberServiceImpl;
import com.epam.hospital.service.impl.DepartmentServiceImpl;
import com.epam.hospital.service.impl.PatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CreateNewChamberCommand implements Command {
    private final Logger logger = LogManager.getLogger(CreateNewChamberCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ChamberService chamberService = ChamberServiceImpl.getInstance();
        DepartmentService departmentService = DepartmentServiceImpl.getInstance();
        PatientService patientService = PatientServiceImpl.getInstance();

        int chamberId = Integer.parseInt(request.getParameter(RequestParameter.CHAMBER_ID));
        int departmentId = (int) session.getAttribute(SessionAttribute.USER_DEPARTMENT_ID);
        int bedsNumber = Integer.parseInt(request.getParameter(RequestParameter.CHAMBER_BEDS_NUMBER));

        Chamber chamber = new Chamber(chamberId, departmentId, bedsNumber);
        chamberService.insert(chamber);

        Department department = departmentService.findById(departmentId);
        List<Chamber> chambers = chamberService.findByDepartmentId(departmentId);
        chambers = patientService.findFreeBeds(chambers);
        request.setAttribute(RequestAttribute.DEPARTMENT, department);
        request.setAttribute(RequestAttribute.CHAMBERS, chambers);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_NEW_PATIENT_PAGE_COMMAND);

        logger.info("Chamber is registered." + chamber);
        return new CommandResult(Page.DEPARTMENT_CHAMBERS_PAGE, RoutingType.FORWARD);
    }
}
