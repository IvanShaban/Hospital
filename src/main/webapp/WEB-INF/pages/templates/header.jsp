<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/header-style.css">
    <header class="p-3 bg-dark text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_HOME_PAGE_COMMAND}" class="nav-link px-2 text-white"><fmt:message key="header.home" /></a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DEPARTMENTS_PAGE_COMMAND}" class="nav-link px-2 text-white"><fmt:message key="header.departments" /></a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DOCTORS_PAGE_COMMAND}" class="nav-link px-2 text-white"><fmt:message key="header.doctors" /></a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_NEWS_PAGE_COMMAND}" class="nav-link px-2 text-white"><fmt:message key="header.news" /></a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_CONTACTS_PAGE_COMMAND}" class="nav-link px-2 text-white"><fmt:message key="header.contacts" /></a></li>
                </ul>

                <div class="text-end">
                    <c:if test="${sessionScope.user_id == null}">
                        <button type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_LOG_IN_PAGE_COMMAND}"'><fmt:message key="header.login" /></button>
                        <button type="button" class="btn btn-warning me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_SIGN_UP_PAGE_COMMAND}"'><fmt:message key="header.sign-up" /></button>
                    </c:if>
                    <c:if test="${sessionScope.user_id != null}">
                        <button type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_MANAGE_PAGE_COMMAND}"'><fmt:message key="header.account" /></button>
                    </c:if>
                </div>
                <div class="locale">
                    <div class="locale-button">
                        <c:if test="${sessionScope.locale == 'ru'}">
                            <a <c:set var="user" value="${param.name}" scope="session" /> href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=ru">Рус</a>
                        </c:if>
                        <c:if test="${sessionScope.locale == 'en'}">
                            <a href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=en">Eng</a>
                        </c:if>
                    </div>
                    <div class="locale-dropdown">
                        <c:if test="${sessionScope.locale == 'ru'}">
                            <a href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=en">Eng</a>
                        </c:if>
                        <c:if test="${sessionScope.locale == 'en'}">
                            <a href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=ru">Рус</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </header>
</html>