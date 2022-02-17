<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>
<%@ page import="com.epam.hospital.entity.PatientStatus" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<head>
    <jsp:include page="templates/links.jsp" />
    <link rel="stylesheet" href="static/body-style.css">
    <title><fmt:message key="new_patient.new_patient" /></title>
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
                        <input type="hidden" name="${RequestParameter.PATIENT_STATUS}" value="${PatientStatus.ENABLE}">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="firstName" class="form-label"><fmt:message key="new_patient.name" /></label>
                                <input type="text" class="form-control" id="firstName" placeholder=""
                                       name="${RequestParameter.PATIENT_NAME}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_name" />
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="lastName" class="form-label"><fmt:message key="new_patient.surname" /></label>
                                <input type="text" class="form-control" id="lastName" placeholder=""
                                       name="${RequestParameter.PATIENT_SURNAME}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_surname" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="patronymic" class="form-label"><fmt:message key="new_patient.patronymic" /></label>
                                <input type="text" class="form-control" id="patronymic" placeholder=""
                                       name="${RequestParameter.PATIENT_PATRONYMIC}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_patronymic" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="address" class="form-label"><fmt:message key="new_patient.address" /></label>
                                <input type="text" class="form-control" id="address" placeholder=""
                                       name="${RequestParameter.PATIENT_ADDRESS}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_address" />
                                </div>
                            </div>

                            <hr class="my-4">

                            <div class="col-12">
                                <label for="provisional-diagnosis" class="form-label"><fmt:message key="new_patient.provisional_diagnosis" /></label>
                                <input type="text" class="form-control" id="provisional-diagnosis" placeholder=""
                                       name="${RequestParameter.PATIENT_PROVISIONAL_DIAGNOSIS}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_provisional_diagnosis" />
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="allergy" class="form-label"><fmt:message key="new_patient.allergy" /></label>
                                <input type="text" class="form-control" id="allergy" placeholder=""
                                       name="${RequestParameter.PATIENT_ALLERGY}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_allergy" />
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="blood-type" class="form-label"><fmt:message key="new_patient.blood_type" /></label>
                                <input type="text" class="form-control" id="blood-type" placeholder=""
                                       name="${RequestParameter.PATIENT_BLOOD_TYPE}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_blood_type" />
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="chamber" class="form-label"><fmt:message key="new_patient.chamber" /></label>
                                <input type="number" class="form-control" id="chamber" placeholder=""
                                       name="${RequestParameter.PATIENT_CHAMBER_ID}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_patient.valid_chamber" />
                                </div>
                            </div>
                        </div>

                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="new_patient.create" /></button>
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