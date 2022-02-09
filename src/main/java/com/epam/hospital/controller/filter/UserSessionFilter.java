package com.epam.hospital.controller.filter;

import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;
import com.epam.hospital.entity.User;
import com.epam.hospital.entity.UserRole;
import com.epam.hospital.service.UserService;
//import com.epam.hospital.service.exception.ServiceException;
//import com.epam.hospital.service.factory.ServiceFactory;
//import com.epam.hospital.service.impl.ChamberServiceImpl;
import com.epam.hospital.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter, checks if user in session is valid
 */
public class UserSessionFilter implements Filter {
    private final Logger logger = LogManager.getLogger();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        UserService userService = UserServiceImpl.getInstance();

        try {
            Object userId = session.getAttribute(SessionAttribute.USER_ID);

            if (userId == null) {
                session.setAttribute(SessionAttribute.USER_ROLE_ID, UserRole.NURSE.getValue());
            } else {
                int role = (int) session.getAttribute(SessionAttribute.USER_ROLE_ID);

                User user = userService.findById((Integer) userId);

                if (user == null || role != user.getRoleId()) {
                    session.removeAttribute(SessionAttribute.USER_ID);
                    session.removeAttribute(SessionAttribute.USER_NAME);
                    session.removeAttribute(SessionAttribute.USER_SURNAME);
                    session.removeAttribute(SessionAttribute.USER_EMAIL);
                    session.setAttribute(SessionAttribute.USER_ROLE_ID, UserRole.NURSE.getValue());
                    String url = "/controller?" +
                            RequestParameter.COMMAND + "=" + CommandName.GOTO_LOG_IN_PAGE_COMMAND;
                    session.setAttribute(SessionAttribute.URL, url);
                    response.sendRedirect(request.getContextPath() + url);
                    return;
                }
            }
        } catch (ClassCastException e) {
            logger.error("Unable to get user.", e);
            String url = "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_500_PAGE_COMMAND;
            session.setAttribute(SessionAttribute.URL, url);
            response.sendRedirect(request.getContextPath() + url);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}