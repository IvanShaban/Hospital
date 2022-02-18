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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoToAdminChambersCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ChamberService chamberService = ChamberServiceImpl.getInstance();
        DepartmentService departmentService = DepartmentServiceImpl.getInstance();
        PatientService patientService = PatientServiceImpl.getInstance();

        List<Chamber> allChambers = chamberService.selectAllChambers();
        allChambers = patientService.findFreeBeds(allChambers);


        List<Department> departments = departmentService.selectAllDepartments();
        request.setAttribute(RequestAttribute.DEPARTMENTS, departments);

        int page = Integer.parseInt(Optional.ofNullable(request.getParameter(RequestParameter.PAGE)).orElse("1"));
        int itemsOnPage = 8;
        int itemsCount = allChambers.size();
        int pagesCount = itemsCount / itemsOnPage;
        if (itemsCount % itemsOnPage != 0) {
            pagesCount++;
        }
        List<Chamber> chambersOnPage = new ArrayList<>();
        for (int i = itemsOnPage * (page - 1); i < itemsOnPage * page; i++) {
            if (i < allChambers.size()) {
                chambersOnPage.add(allChambers.get(i));
            }
        }

        request.setAttribute(RequestAttribute.CHAMBERS, chambersOnPage);
        request.setAttribute(RequestAttribute.CURRENT_PAGE, page);
        request.setAttribute(RequestAttribute.PAGES_COUNT, pagesCount);

        session.setAttribute(SessionAttribute.URL, ("/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_ADMIN_CHAMBERS_COMMAND +
                "&" + RequestParameter.PAGE + "=" + page));
        session.setAttribute(SessionAttribute.URL_WITHOUT_PAGE, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_ADMIN_CHAMBERS_COMMAND);

        return new CommandResult(Page.ADMIN_CHAMBERS_PAGE, RoutingType.FORWARD);
    }
}
