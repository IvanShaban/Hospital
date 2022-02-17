package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.Department;
import com.epam.hospital.entity.User;
import com.epam.hospital.service.DepartmentService;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.DepartmentServiceImpl;
import com.epam.hospital.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToDepartmentPersonalCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();
        DepartmentService departmentService = DepartmentServiceImpl.getInstance();

        List<Department> departments = departmentService.selectAllDepartments();
        request.setAttribute(RequestAttribute.DEPARTMENTS, departments);

        int departmentId = (int) session.getAttribute(SessionAttribute.USER_DEPARTMENT_ID);
        List<User> users = userService.findByDepartmentsId(departmentId);
        request.setAttribute(RequestAttribute.USERS, users);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_DEPARTMENT_PERSONAL_PAGE_COMMAND);

        return new CommandResult(Page.DEPARTMENT_PERSONAL_PAGE, RoutingType.FORWARD);
    }
}
