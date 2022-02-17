<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>
<%@ page import="com.epam.hospital.entity.UserRole" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/sidebar-style.css">
<head>
    <title></title>
</head>
<body>
    <header>
        <div class="flex-shrink-0 p-3 bg-white" style="width: 280px;">
            <ul class="list-unstyled ps-0">
                <c:if test="${sessionScope.user_role_id == UserRole.ADMIN.value}">
                    <li class="mb-1">
                        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#departments-collapse" aria-expanded="false">
                            <fmt:message key="sidebar.departments" />
                        </button>
                        <div class="collapse" id="departments-collapse">
                            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_ADMIN_CHAMBERS_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.chambers" /></a></li>
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_ADMIN_PERSONAL_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.personal" /></a></li>
                            </ul>
                        </div>
                    </li>
                </c:if>
                <c:if test="${sessionScope.user_role_id == UserRole.MANAGER.value}">
                    <li class="mb-1">
                        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#department-collapse" aria-expanded="false">
                            <fmt:message key="sidebar.department" />
                        </button>
                        <div class="collapse" id="department-collapse">
                            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DEPARTMENT_CHAMBERS_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.chambers" /></a></li>
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DEPARTMENT_PERSONAL_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.personal" /></a></li>
                            </ul>
                        </div>
                    </li>
                </c:if>
                <li class="mb-1">
                    <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#patients-collapse" aria-expanded="false">
                        <fmt:message key="sidebar.patients" />
                    </button>
                    <div class="collapse" id="patients-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <c:if test="${sessionScope.user_role_id <= UserRole.DOCTOR.value}">
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_NEW_PATIENT_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.new_patient" /></a></li>
                            </c:if>
                            <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_SEARCH_PATIENT_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.search" /></a></li>
                        </ul>
                    </div>
                </li>
                <li class="mb-1">
                    <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#procedures-collapse" aria-expanded="false">
                        <fmt:message key="sidebar.procedures" />
                    </button>
                    <div class="collapse" id="procedures-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <c:if test="${sessionScope.user_role_id <= UserRole.DOCTOR.value}">
                                <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_NEW_PROCEDURE_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.new_procedure" /></a></li>
                            </c:if>
                            <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_UNFULFILLED_PROCEDURES_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.unfulfilled" /></a></li>
                            <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_SEARCH_PROCEDURE_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.search" /></a></li>
                        </ul>
                    </div>
                </li>
                <li class="border-top my-3"></li>
                <li class="mb-1">
                    <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
                        <fmt:message key="sidebar.account" />
                    </button>
                    <div class="collapse" id="account-collapse">
                        <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                            <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_PROFILE_PAGE_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.profile" /></a></li>
                            <li><a href="?${RequestParameter.COMMAND}=${CommandName.LOG_OUT_COMMAND}" class="link-dark rounded"><fmt:message key="sidebar.log_out" /></a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
    </header>
    <script src="static/sidebars.js"></script>
</body>
</html>
