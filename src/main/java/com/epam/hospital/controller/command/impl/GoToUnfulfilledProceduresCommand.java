package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.Procedure;
import com.epam.hospital.entity.User;
import com.epam.hospital.service.ProcedureService;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.ProcedureServiceImpl;
import com.epam.hospital.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToUnfulfilledProceduresCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ProcedureService procedureService = ProcedureServiceImpl.getInstance();
        UserService userService = UserServiceImpl.getInstance();

        List<User> users = userService.selectAllUsers();
        request.setAttribute(RequestAttribute.USERS, users);

        List<Procedure> procedures = procedureService.findUnfulfilledProcedures();
        request.setAttribute(RequestAttribute.PROCEDURES, procedures);

        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_UNFULFILLED_PROCEDURES_PAGE_COMMAND);

        return new CommandResult(Page.UNFULFILLED_PROCEDURES_PAGE, RoutingType.FORWARD);
    }
}
