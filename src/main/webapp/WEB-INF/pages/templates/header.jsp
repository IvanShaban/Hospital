
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
<%--                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">--%>
<%--                    <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>--%>
<%--                </a>--%>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_HOME_PAGE_COMMAND}" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DEPARTMENTS_PAGE_COMMAND}" class="nav-link px-2 text-white">Departments</a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_DOCTORS_PAGE_COMMAND}" class="nav-link px-2 text-white">Doctors</a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_NEWS_PAGE_COMMAND}" class="nav-link px-2 text-white">News</a></li>
                    <li><a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_CONTACTS_PAGE_COMMAND}" class="nav-link px-2 text-white">Contacts</a></li>
                </ul>

<%--                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">--%>
<%--                    <input type="search" class="form-control form-control-dark" placeholder="Search..." aria-label="Search">--%>
<%--                </form>--%>

                <div class="text-end">
                    <c:if test="${sessionScope.user_id == null}">
                        <button type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_LOG_IN_PAGE_COMMAND}"'>Login</button>
                        <button type="button" class="btn btn-warning me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_SIGN_UP_PAGE_COMMAND}"'>Sign-up</button>
                    </c:if>
                    <c:if test="${sessionScope.user_id != null}">
                        <button type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.GOTO_MANAGE_PAGE_COMMAND}"'>Account</button>
                    </c:if>
                </div>
                <div class="locale">
                    <div class="locale-button">
                        <c:if test="${sessionScope.locale == 'ru'}">
<%--                            <button <c:set var="user" value="${param.name}" scope="session" /> type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=ru"'>Рус</button>--%>
                            <a <c:set var="user" value="${param.name}" scope="session" /> href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=ru">Рус</a>
                        </c:if>
                        <c:if test="${sessionScope.locale == 'en'}">
<%--                            <button type="button" class="btn btn-outline-light me-2" onClick='location.href="?${RequestParameter.COMMAND}=${CommandName.SET_LOCALE_COMMAND}&${RequestParameter.LOCALE}=en"'>Eng</button>--%>
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