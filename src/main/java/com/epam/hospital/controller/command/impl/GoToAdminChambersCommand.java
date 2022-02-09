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
import com.epam.hospital.service.ChamberService;
import com.epam.hospital.service.impl.ChamberServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GoToAdminChambersCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ChamberService chamberService = ChamberServiceImpl.getInstance();

        List<Chamber> chambers = chamberService.selectAllChambers();
        request.setAttribute(RequestAttribute.CHAMBERS, chambers);
        session.setAttribute(SessionAttribute.URL, "/controller?" +
                RequestParameter.COMMAND + "=" + CommandName.GOTO_ADMIN_CHAMBERS_COMMAND);

        return new CommandResult(Page.ADMIN_CHAMBERS_PAGE, RoutingType.FORWARD);
    }
}
