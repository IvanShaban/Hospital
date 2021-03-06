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
import com.epam.hospital.entity.User;
import com.epam.hospital.service.DepartmentService;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.DepartmentServiceImpl;
import com.epam.hospital.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GoToAdminPersonalCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();
        DepartmentService departmentService = DepartmentServiceImpl.getInstance();

        List<User> allUsers = userService.selectAllUsers();


        List<Department> departments = departmentService.selectAllDepartments();
        request.setAttribute(RequestAttribute.DEPARTMENTS, departments);

        int page = Integer.parseInt(Optional.ofNullable(request.getParameter(RequestParameter.PAGE)).orElse("1"));
        int itemsOnPage = 8;
        int itemsCount = allUsers.size();
        int pagesCount = itemsCount / itemsOnPage;
        if (itemsCount % itemsOnPage != 0) {
            pagesCount++;
        }
        List<User> usersOnPage = new ArrayList<>();
        for (int i = itemsOnPage * (page - 1); i < itemsOnPage * page; i++) {
            if (i < allUsers.size()) {
                usersOnPage.add(allUsers.get(i));
            }
        }
        request.setAttribute(RequestAttribute.CURRENT_PAGE, page);
        request.setAttribute(RequestAttribute.PAGES_COUNT, pagesCount);
        request.setAttribute(RequestAttribute.USERS, usersOnPage);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_ADMIN_PERSONAL_COMMAND);

        return new CommandResult(Page.ADMIN_PERSONAL_PAGE, RoutingType.FORWARD);
    }
}
