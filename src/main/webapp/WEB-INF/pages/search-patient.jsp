<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 06.02.2022
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>
<%@ page import="com.epam.hospital.entity.UserRole" %>
<html>
<head>
    <jsp:include page="templates/links.jsp" />
    <title>Search patient</title>
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
                <%--                    <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">--%>
                <%--                    <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">--%>
                <div class="row g-3">
                    <div class="col-sm-6">
                        <label for="patient-id" class="form-label">Patient card number</label>
                        <input type="number" class="form-control" id="patient-id" placeholder=""
                               name="${RequestParameter.PATIENT_ID}" value="" required>
                        <div class="invalid-feedback">
                            Valid card number is required.
                        </div>
                    </div>

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Search</button>

                    <c:if test="${requestScope.patient != null}">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Patient card number</th>
                                <th scope="col">Chamber</th>
                                <th scope="col">Doctor</th>
                                <th scope="col">Surname</th>
                                <th scope="col">Name</th>
                                <th scope="col">Patronymic</th>
                                <th scope="col">Provisional diagnosis</th>
                                <th scope="col">Address</th>
                                <th scope="col">Status</th>
                                <th scope="col">Blood type</th>
                                <th scope="col">Allergy</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>${requestScope.patient.id}</td>
                                <td>${requestScope.patient.chambersId}</td>
                                <td>${requestScope.patient.doctorsId}</td>
                                <td>${requestScope.patient.surname}</td>
                                <td>${requestScope.patient.name}</td>
                                <td>${requestScope.patient.patronymic}</td>
                                <td>${requestScope.patient.provisionalDiagnosis}</td>
                                <td>${requestScope.patient.address}</td>
                                <td>${requestScope.patient.status}</td>
                                <td>${requestScope.patient.bloodType}</td>
                                <td>${requestScope.patient.allergy}</td>
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