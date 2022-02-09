<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 06.02.2022
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>
<%@ page import="com.epam.hospital.entity.UserRole" %>
<%@ page import="com.epam.hospital.entity.PatientStatus" %>
<html>
<head>
    <jsp:include page="templates/links.jsp" />
    <title>New procedure</title>
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
            <form class="needs-validation" action="controller" method="post" novalidate>
                <input type="hidden" name="${RequestParameter.COMMAND}"
                       value="${CommandName.CREATE_NEW_PROCEDURE_COMMAND}">
                <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">
                <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">
                <div class="row g-3">
                    <div class="col-12">
                        <label for="name-of-procedure" class="form-label">Name of procedure</label>
                        <input type="text" class="form-control" id="name-of-procedure" placeholder=""
                               name="${RequestParameter.PROCEDURE_NAME}" value="" required>
                        <div class="invalid-feedback">
                            Valid name is required.
                        </div>
                    </div>

                    <div class="col-md-5">
                        <label for="patient-id" class="form-label">Patient id</label>
                        <input type="text" class="form-control" id="patient-id" placeholder=""
                               name="${RequestParameter.PATIENT_ID}" value="" required>
                        <div class="invalid-feedback">
                            Valid name is required.
                        </div>
                    </div>

                    <div class="col-md-5">
                        <label for="access" class="form-label">Performer</label>
                        <select class="form-select" id="access" name="${RequestParameter.PROCEDURE_ACCESS}" required>
                            <option value="">Choose...</option>
                            <option value="3">Doctor</option>
                            <option value="4">Nurse</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid department.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="specification" class="form-label">Specification</label>
                        <input type="text" class="form-control" id="specification" placeholder=""
                               name="${RequestParameter.PROCEDURE_SPECIFICATION}" value="" required>
                        <div class="invalid-feedback">
                            Valid patronymic is required.
                        </div>
                    </div>

                    <hr class="my-4">
                </div>
                <button class="w-100 btn btn-primary btn-lg" type="submit">Create</button>
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