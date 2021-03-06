package com.epam.hospital.controller;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.factory.CommandFactory;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute(SessionAttribute.LOCALE) == null) {
            session.setAttribute(SessionAttribute.LOCALE, "en");
        }

        String commandName = request.getParameter(RequestParameter.COMMAND);
        Command command = CommandFactory.getInstance().getCommand(commandName);

        CommandResult result = command.execute(request, response);
        if (result.getResource().equals(Page.ERROR_500_PAGE)) {
            session.setAttribute(SessionAttribute.URL, "/controller?" +
                    RequestParameter.COMMAND + "=" + CommandName.GOTO_500_PAGE_COMMAND);
        }
        String resource = result.getResource();
        switch (result.getRoutingType()) {
            case FORWARD:
                request.getRequestDispatcher(resource).forward(request, response);
                break;
            case REDIRECT:
                response.sendRedirect(request.getContextPath() + resource);
                break;
            default:
                request.getRequestDispatcher(Page.ERROR_404_PAGE).forward(request, response);
        }
    }
}
