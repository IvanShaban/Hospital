package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.User;
import com.epam.hospital.entity.UserRole;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogInCommand implements Command {
    private final Logger logger = LogManager.getLogger(LogInCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();

        String login = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);

        try {
            User user = userService.login(login, password);
            if (user != null) {
                if (user.getRoleId() == UserRole.ADMIN.getValue()) {
                    logger.info("User {} logged in as admin.", user.getLogin());
                }
                session.setAttribute(SessionAttribute.USER_ID, user.getId());
                session.setAttribute(SessionAttribute.USER_NAME, user.getName());
                session.setAttribute(SessionAttribute.USER_SURNAME, user.getSurname());
                session.setAttribute(SessionAttribute.USER_DEPARTMENT_ID, user.getDepartmentsId());
                session.setAttribute(SessionAttribute.USER_PHONE_NUMBER, user.getPhoneNumber());
                session.setAttribute(SessionAttribute.USER_EMAIL, user.getLogin());
                session.setAttribute(SessionAttribute.USER_ROLE_ID, user.getRoleId());
            } else {
                session.setAttribute(SessionAttribute.ERROR, "Invalid login or password");
                return new CommandResult(Page.LOG_IN_PAGE, RoutingType.FORWARD);
            }

            session.setAttribute(SessionAttribute.URL, "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_MANAGE_PAGE_COMMAND);

            return new CommandResult(Page.MANAGE_PAGE, RoutingType.FORWARD);
        } catch (Exception e) {
            logger.error("Unable to check user log-in data.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}