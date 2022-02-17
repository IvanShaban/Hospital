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
    <title><fmt:message key="search_patient.search_patient" /></title>
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
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SEARCH_PATIENT_COMMAND}">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="patient-id" class="form-label"><fmt:message key="search_patient.patient_card_number" /></label>
                                <input type="number" class="form-control" id="patient-id" placeholder=""
                                       name="${RequestParameter.PATIENT_ID}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="search_patient.valid_card_number" />
                                </div>
                            </div>

                            <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="search_patient.search" /></button>

                            <c:if test="${requestScope.patient != null}">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col"><fmt:message key="search_patient.patient_card_number" /></th>
                                            <th scope="col"><fmt:message key="search_patient.chamber" /></th>
                                            <th scope="col"><fmt:message key="search_patient.doctor" /></th>
                                            <th scope="col"><fmt:message key="search_patient.surname" /></th>
                                            <th scope="col"><fmt:message key="search_patient.name" /></th>
                                            <th scope="col"><fmt:message key="search_patient.patronymic" /></th>
                                            <th scope="col"><fmt:message key="search_patient.provisional_diagnosis" /></th>
                                            <th scope="col"><fmt:message key="search_patient.address" /></th>
                                            <th scope="col"><fmt:message key="search_patient.status" /></th>
                                            <th scope="col"><fmt:message key="search_patient.blood_type" /></th>
                                            <th scope="col"><fmt:message key="search_patient.allergy" /></th>
                                            <th scope="col"><fmt:message key="search_patient.writing_out" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${requestScope.patient.id}</td>
                                            <c:if test="${requestScope.patient.chambersId == 0}">
                                                <td></td>
                                            </c:if>
                                            <c:if test="${requestScope.patient.chambersId != 0}">
                                                <td>${requestScope.patient.chambersId}</td>
                                            </c:if>
                                            <td>${requestScope.user.surname} ${requestScope.user.name}</td>
                                            <td>${requestScope.patient.surname}</td>
                                            <td>${requestScope.patient.name}</td>
                                            <td>${requestScope.patient.patronymic}</td>
                                            <td>${requestScope.patient.provisionalDiagnosis}</td>
                                            <td>${requestScope.patient.address}</td>
                                            <td>${requestScope.patient.status}</td>
                                            <td>${requestScope.patient.bloodType}</td>
                                            <td>${requestScope.patient.allergy}</td>
                                            <c:if test="${requestScope.patient.chambersId != 0}">
                                                <c:if test="${sessionScope.user_role_id <= UserRole.MANAGER.value}">
                                                    <td><a href="?${RequestParameter.COMMAND}=${CommandName.WRITE_OUT_SEARCH_PATIENT_COMMAND}&${RequestParameter.PATIENT_ID}=${requestScope.patient.id}"><fmt:message key="search_patient.write_out" /></a></td>
                                                </c:if>
                                            </c:if>
                                            <td></td>
                                        </tr>
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