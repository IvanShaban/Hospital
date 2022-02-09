package com.epam.hospital.controller.filter;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.factory.CommandFactory;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.UserRole;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Filter, that controls access of users with different roles to commands of the system
 */
public class AccessFilter implements Filter {
    private final Map<UserRole, List<String>> commandsAvailableToRoles = new EnumMap<>(UserRole.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

        commandsAvailableToRoles.put(UserRole.ADMIN, Arrays.asList(
                CommandName.GOTO_403_PAGE_COMMAND,
                CommandName.GOTO_404_PAGE_COMMAND,
                CommandName.GOTO_500_PAGE_COMMAND
        ));
        commandsAvailableToRoles.put(UserRole.MANAGER, Arrays.asList(
                CommandName.GOTO_403_PAGE_COMMAND,
                CommandName.GOTO_404_PAGE_COMMAND,
                CommandName.GOTO_500_PAGE_COMMAND
        ));
        commandsAvailableToRoles.put(UserRole.DOCTOR, Arrays.asList(
                CommandName.GOTO_403_PAGE_COMMAND,
                CommandName.GOTO_404_PAGE_COMMAND,
                CommandName.GOTO_500_PAGE_COMMAND
        ));
        commandsAvailableToRoles.put(UserRole.NURSE, Arrays.asList(
                CommandName.GOTO_403_PAGE_COMMAND,
                CommandName.GOTO_404_PAGE_COMMAND,
                CommandName.GOTO_500_PAGE_COMMAND
        ));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        int role = (int) session.getAttribute(SessionAttribute.USER_ROLE_ID);

        if (role > 0) {
            role = UserRole.NURSE.getValue();
        }

        String commandName = request.getParameter("command");

        if (commandName != null) {
            Command command = CommandFactory.getInstance().getCommand(commandName);

            if (command == null) {
                String url = "/controller?" +
                        RequestParameter.COMMAND + "=" + CommandName.GOTO_404_PAGE_COMMAND;
                session.setAttribute(SessionAttribute.URL, url);
                response.sendRedirect(request.getContextPath() + url);
                return;
            }

            if (!commandsAvailableToRoles.get(role).contains(commandName)) {
                String url = "/controller?" +
                        RequestParameter.COMMAND + "=" + CommandName.GOTO_403_PAGE_COMMAND;
                session.setAttribute(SessionAttribute.URL, url);
                response.sendRedirect(request.getContextPath() + url);
                return;
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}