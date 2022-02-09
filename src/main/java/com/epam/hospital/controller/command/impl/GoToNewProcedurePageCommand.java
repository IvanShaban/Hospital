package com.epam.hospital.controller.command.impl;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.CommandResult;
import com.epam.hospital.controller.command.RoutingType;
import com.epam.hospital.controller.constant.Page;
import com.epam.hospital.controller.constant.RequestParameter;
import com.epam.hospital.controller.constant.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GoToNewProcedurePageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_NEW_PROCEDURE_PAGE_COMMAND);

        return new CommandResult(Page.NEW_PROCEDURE_PAGE, RoutingType.FORWARD);
    }
}
