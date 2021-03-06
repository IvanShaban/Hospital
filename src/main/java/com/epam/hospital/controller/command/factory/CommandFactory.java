package com.epam.hospital.controller.command.factory;

import com.epam.hospital.controller.command.Command;
import com.epam.hospital.controller.command.CommandName;
import com.epam.hospital.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final CommandFactory instance = new CommandFactory();

    private static final Map<String, Command> commands = new HashMap<String, Command>() {{
        put(CommandName.GOTO_HOME_PAGE_COMMAND, new GoToHomePageCommand());
        put(CommandName.GOTO_PATIENTS_PAGE_COMMAND, new GoToHomePageCommand());
        put(CommandName.GOTO_PROCEDURES_PAGE_COMMAND, new GoToHomePageCommand());
        put(CommandName.GOTO_DEPARTMENTS_PAGE_COMMAND, new GoToDepartmentsPageCommand());
        put(CommandName.GOTO_DOCTORS_PAGE_COMMAND, new GoToDoctorsPageCommand());
        put(CommandName.GOTO_NEWS_PAGE_COMMAND, new GoToNewsPageCommand());
        put(CommandName.GOTO_CONTACTS_PAGE_COMMAND, new GoToContactsPageCommand());
        put(CommandName.GOTO_LOG_IN_PAGE_COMMAND, new GoToLogInPageCommand());
        put(CommandName.GOTO_SIGN_UP_PAGE_COMMAND, new GoToSignUpPageCommand());
        put(CommandName.LOG_IN_COMMAND, new LogInCommand());
        put(CommandName.GOTO_MANAGE_PAGE_COMMAND, new GoToManagePageCommand());
        put(CommandName.GOTO_ADMIN_CHAMBERS_COMMAND, new GoToAdminChambersCommand());
        put(CommandName.GOTO_ADMIN_PERSONAL_COMMAND, new GoToAdminPersonalCommand());
        put(CommandName.GOTO_DEPARTMENT_CHAMBERS_PAGE_COMMAND, new GoToDepartmentChambersCommand());
        put(CommandName.GOTO_DEPARTMENT_PERSONAL_PAGE_COMMAND, new GoToDepartmentPersonalCommand());
        put(CommandName.GOTO_NEW_PATIENT_PAGE_COMMAND, new GoToNewPatientPageCommand());
        put(CommandName.GOTO_SEARCH_PATIENT_PAGE_COMMAND, new GoToSearchPatientPageCommand());
        put(CommandName.GOTO_NEW_PROCEDURE_PAGE_COMMAND, new GoToNewProcedurePageCommand());
        put(CommandName.GOTO_SEARCH_PROCEDURE_PAGE_COMMAND, new GoToSearchProcedurePageCommand());
        put(CommandName.GOTO_ACCOUNT_PROFILE_PAGE_COMMAND, new GoToAccountProfilePageCommand());
        put(CommandName.LOG_OUT_COMMAND, new LogOutCommand());
        put(CommandName.SET_LOCALE_COMMAND, new SetLocaleCommand());
        put(CommandName.SIGN_UP_COMMAND, new SignUpCommand());
        put(CommandName.GOTO_PROFILE_PAGE_COMMAND, new GoToProfilePageCommand());
        put(CommandName.PROFILE_CHANGE_COMMAND, new ProfileChangeCommand());
        put(CommandName.CREATE_NEW_PATIENT_COMMAND, new CreateNewPatientCommand());
        put(CommandName.CREATE_NEW_PROCEDURE_COMMAND, new CreateNewProcedureCommand());
        put(CommandName.SEARCH_PATIENT_COMMAND, new SearchPatientCommand());
        put(CommandName.SEARCH_PROCEDURES_COMMAND, new SearchProceduresCommand());
        put(CommandName.GOTO_UNFULFILLED_PROCEDURES_PAGE_COMMAND, new GoToUnfulfilledProceduresCommand());
        put(CommandName.GOTO_CHAMBER_INFO_PAGE_COMMAND, new GoToChamberInfoPageCommand());
        put(CommandName.WRITE_OUT_PATIENT_COMMAND, new WriteOutPatientCommand());
        put(CommandName.GOTO_NEW_CHAMBER_PAGE_COMMAND, new GoToNewChamberPageCommand());
        put(CommandName.CREATE_NEW_CHAMBER_COMMAND, new CreateNewChamberCommand());
        put(CommandName.GIVE_DOCTOR_RIGHTS_COMMAND, new GiveDoctorRightsCommand());
        put(CommandName.EXECUTE_UNFULFILLED_PROCEDURE_COMMAND, new ExecuteUnfulfilledProcedureCommand());
        put(CommandName.EXECUTE_PATIENT_PROCEDURE_COMMAND, new ExecutePatientProcedureCommand());
        put(CommandName.WRITE_OUT_SEARCH_PATIENT_COMMAND, new WriteOutSearchPatientCommand());
        put(CommandName.GIVE_DOCTOR_RIGHTS_BY_HEAD_COMMAND, new GiveDoctorRightsByHeadCommand());
    }};

    private CommandFactory() {
    }

    public static CommandFactory getInstance() {
        return instance;
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}