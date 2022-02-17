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
<head>
    <jsp:include page="templates/links.jsp" />
    <link rel="stylesheet" href="static/body-style.css">
    <title><fmt:message key="unfulfilled_procedure.unfulfilled_procedure" /></title>
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
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SEARCH_PROCEDURES_COMMAND}">
                        <c:if test="${requestScope.procedures != null}">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.patient_card_number" /></th>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.procedure_name" /></th>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.specification" /></th>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.appointed_doctor" /></th>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.access" /></th>
                                        <th scope="col"><fmt:message key="unfulfilled_procedure.execution" /></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.procedures}" var="procedure">
                                        <tr>
                                            <td>${procedure.patientsId}</td>
                                            <td>${procedure.proceduresName}</td>
                                            <td>${procedure.specification}</td>
                                            <c:forEach items="${requestScope.users}" var="user">
                                                <c:if test="${user.id == procedure.appointedDoctorsId}">
                                                    <td>${user.surname} ${user.name}</td>
                                                </c:if>
                                            </c:forEach>
                                            <c:choose>
                                                <c:when test="${procedure.access == UserRole.DOCTOR.value}">
                                                    <td><fmt:message key="unfulfilled_procedure.doctor" /></td>
                                                </c:when>
                                                <c:when test="${procedure.access == UserRole.NURSE.value}">
                                                    <td><fmt:message key="unfulfilled_procedure.nurse" /></td>
                                                </c:when>
                                            </c:choose>
                                            <c:choose>
                                                <c:when test="${sessionScope.user_role_id <= procedure.access}">
                                                    <td><a href="?${RequestParameter.COMMAND}=${CommandName.EXECUTE_UNFULFILLED_PROCEDURE_COMMAND}&${RequestParameter.PROCEDURE_ID}=${procedure.id}"><fmt:message key="unfulfilled_procedure.execute" /></a></td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td></td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
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
