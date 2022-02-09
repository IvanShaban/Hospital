package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestAttribute;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.dto.UserDto;
import com.epam.hospital.service.UserService;
import com.epam.hospital.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileChangeCommand implements Command {
    private final Logger logger = LogManager.getLogger(SignUpCommand.class);

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserService userService = UserServiceImpl.getInstance();

        int userId = Integer.parseInt(request.getParameter(RequestParameter.USER_ID));
        String email = request.getParameter(RequestParameter.EMAIL);
        String password = request.getParameter(RequestParameter.PASSWORD);
        int departmentId = Integer.parseInt(request.getParameter(RequestParameter.DEPARTMENT_ID));
        String surname = request.getParameter(RequestParameter.USER_SURNAME);
        String name = request.getParameter(RequestParameter.USER_NAME);
        String patronymic = request.getParameter(RequestParameter.USER_PATRONYMIC);
        String specialisation = request.getParameter(RequestParameter.USER_SPECIALISATION);
        int phoneNumber = Integer.parseInt(request.getParameter(RequestParameter.PHONE_NUMBER));
        int roleId = Integer.parseInt(request.getParameter(RequestParameter.USER_ROLE_ID));
        UserDto userDto = new UserDto(email, password, departmentId, surname, name, patronymic, specialisation, phoneNumber, roleId);

        try {
            if (userService.updateById(userId, userDto) == null) {
                session.setAttribute(SessionAttribute.ERROR, "Invalid data");
                return new CommandResult((String) session.getAttribute(SessionAttribute.URL), RoutingType.REDIRECT);
            }

            request.setAttribute(RequestAttribute.EMAIL, email);

            session.setAttribute(SessionAttribute.URL, "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_LOG_IN_PAGE_COMMAND);

            logger.info("User {} is registered.", email);
            return new CommandResult(Page.LOG_IN_PAGE, RoutingType.FORWARD);
        } catch (Exception e) {
            logger.error("Unable to register new user.", e);
        }
        return new CommandResult(Page.ERROR_500_PAGE, RoutingType.FORWARD);
    }
}
