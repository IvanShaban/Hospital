<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 05.02.2022
  Time: 21:19
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
    <title>New patient</title>
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
                       value="${CommandName.CREATE_NEW_PATIENT_COMMAND}">
                <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">
                <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">
                <input type="hidden" name="${RequestParameter.PATIENT_STATUS}" value="${PatientStatus.ENABLE}">
                <div class="row g-3">
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label">Name</label>
                        <input type="text" class="form-control" id="firstName" placeholder=""
                               name="${RequestParameter.PATIENT_NAME}" value="" required>
                        <div class="invalid-feedback">
                            Valid name is required.
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <label for="lastName" class="form-label">Surname</label>
                        <input type="text" class="form-control" id="lastName" placeholder=""
                               name="${RequestParameter.PATIENT_SURNAME}" value="" required>
                        <div class="invalid-feedback">
                            Valid surname is required.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="patronymic" class="form-label">Patronymic</label>
                        <input type="text" class="form-control" id="patronymic" placeholder=""
                               name="${RequestParameter.PATIENT_PATRONYMIC}" value="" required>
                        <div class="invalid-feedback">
                            Valid patronymic is required.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" id="address" placeholder=""
                               name="${RequestParameter.PATIENT_ADDRESS}" value="" required>
                        <div class="invalid-feedback">
                            Valid address is required.
                        </div>
                    </div>

                    <hr class="my-4">

                    <div class="col-12">
                        <label for="provisional-diagnosis" class="form-label">Provisional diagnosis</label>
                        <input type="text" class="form-control" id="provisional-diagnosis" placeholder=""
                               name="${RequestParameter.PATIENT_PROVISIONAL_DIAGNOSIS}" value="" required>
                        <div class="invalid-feedback">
                            Valid provisional diagnosis is required.
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <label for="allergy" class="form-label">Allergy</label>
                        <input type="text" class="form-control" id="allergy" placeholder=""
                               name="${RequestParameter.PATIENT_ALLERGY}" value="" required>
                        <div class="invalid-feedback">
                            Valid name is required.
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <label for="blood-type" class="form-label">Blood type</label>
                        <input type="text" class="form-control" id="blood-type" placeholder=""
                               name="${RequestParameter.PATIENT_BLOOD_TYPE}" value="" required>
                        <div class="invalid-feedback">
                            Valid surname is required.
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <label for="chamber" class="form-label">Chamber</label>
                        <input type="number" class="form-control" id="chamber" placeholder=""
                               name="${RequestParameter.PATIENT_CHAMBER_ID}" value="" required>
                        <div class="invalid-feedback">
                            Valid surname is required.
                        </div>
                    </div>
                </div>

                <hr class="my-4">

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