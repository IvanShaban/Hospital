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
    <title><fmt:message key="search_procedure.search_procedure" /></title>
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
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="patient-id" class="form-label"><fmt:message key="search_procedure.patient_card_number" /></label>
                                <input type="number" class="form-control" id="patient-id" placeholder=""
                                       name="${RequestParameter.PATIENT_ID}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="search_procedure.valid_patient_card_number" />
                                </div>
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="search_procedure.search" /></button>

                            <c:if test="${requestScope.procedures != null}">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col"><fmt:message key="search_procedure.patient_card_number" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.procedure_name" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.specification" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.appointed_doctor" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.access" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.performed_personal" /></th>
                                            <th scope="col"><fmt:message key="search_procedure.execution" /></th>
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
                                                    <c:when test="${procedure.access == 3}">
                                                        <td><fmt:message key="search_procedure.doctor" /></td>
                                                    </c:when>
                                                    <c:when test="${procedure.access == 4}">
                                                        <td><fmt:message key="search_procedure.nurse" /></td>
                                                    </c:when>
                                                </c:choose>
                                                <c:forEach items="${requestScope.users}" var="user">
                                                    <c:if test="${user.id == procedure.performedUserId}">
                                                        <td>${user.surname} ${user.name}</td>
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${procedure.performedUserId == 0}">
                                                    <td></td>
                                                    <c:choose>
                                                        <c:when test="${sessionScope.user_role_id <= procedure.access}">
                                                            <td><a href="?${RequestParameter.COMMAND}=${CommandName.EXECUTE_PATIENT_PROCEDURE_COMMAND}&${RequestParameter.PROCEDURE_ID}=${procedure.id}"><fmt:message key="search_procedure.execute" /></a></td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td></td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>
                                                <td></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
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
