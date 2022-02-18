<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<head>
    <jsp:include page="templates/links.jsp" />
    <link rel="stylesheet" href="static/body-style.css">
    <title><fmt:message key="admin_personal.admin_personal" /></title>
</head>
<body>
    <header>
        <jsp:include page="templates/header.jsp" />

    </header>
    <main>
    <div class="d-flex">
        <jsp:include page="templates/sidebar.jsp" />
        <div class="row g-5">
            <div class="col-md-7 col-lg-8">
                <form class="needs-validation" action="controller" method="get" novalidate>
                    <div class="row g-3">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col"><fmt:message key="admin_personal.surname" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.name" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.patronymic" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.department" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.position" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.specialisation" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.phone_number" /></th>
                                    <th scope="col"><fmt:message key="admin_personal.rights" /></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${requestScope.users}" var="user">
                                    <tr>
                                        <td>${user.surname}</td>
                                        <td>${user.name}</td>
                                        <td>${user.patronymic}</td>
                                        <c:forEach items="${requestScope.departments}" var="department">
                                            <c:if test="${department.id == user.departmentsId}">
                                                <td>${department.title}</td>
                                            </c:if>
                                        </c:forEach>
                                        <c:choose>
                                            <c:when test="${user.roleId == 2}">
                                                <td><fmt:message key="admin_personal.head_of_the_department" /></td>
                                            </c:when>
                                            <c:when test="${user.roleId == 3 || user.roleId == 1}">
                                                <td><fmt:message key="admin_personal.doctor" /></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td><fmt:message key="admin_personal.nurse" /></td>
                                            </c:otherwise>
                                        </c:choose>
                                        <td>${user.specialisation}</td>
                                        <td>${user.phoneNumber}</td>
                                        <c:choose>
                                            <c:when test="${user.roleId == 4}">
                                                <td><a href="?${RequestParameter.COMMAND}=${CommandName.GIVE_DOCTOR_RIGHTS_COMMAND}&${RequestParameter.USER_ID}=${user.id}"><fmt:message key="admin_personal.doctor" /></a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td></td>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="pages-navigation">
                            <c:if test="${requestScope.current_page != 1}">
                                <a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_ADMIN_PERSONAL_COMMAND}&${RequestParameter.PAGE}=${requestScope.current_page - 1}">${requestScope.current_page - 1}</a>
                            </c:if>
                            &nbsp;<span><fmt:message key="admin_personal.page" /> ${requestScope.current_page} <fmt:message key="admin_personal.of" /> ${requestScope.pages_count}</span>&nbsp;
                            <c:if test="${requestScope.current_page < requestScope.pages_count}">
                                <a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_ADMIN_PERSONAL_COMMAND}&${RequestParameter.PAGE}=${requestScope.current_page + 1}">${requestScope.current_page + 1}</a>
                            </c:if>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
    <footer>
        <jsp:include page="templates/footer.jsp" />
    </footer>
    <script src="static/form-validation.js"></script>
</body>
</html>