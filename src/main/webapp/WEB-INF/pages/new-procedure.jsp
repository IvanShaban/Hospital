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
    <title><fmt:message key="new_procedure.new_procedure" /></title>
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
                                <label for="name-of-procedure" class="form-label"><fmt:message key="new_procedure.name_of_procedure" /></label>
                                <input type="text" class="form-control" id="name-of-procedure" placeholder=""
                                       name="${RequestParameter.PROCEDURE_NAME}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_procedure.valid_name_of_procedure" />
                                </div>
                            </div>

                            <div class="col-md-5">
                                <label for="patient-id" class="form-label"><fmt:message key="new_procedure.patient_card_number" /></label>
                                <input type="text" class="form-control" id="patient-id" placeholder=""
                                       name="${RequestParameter.PATIENT_ID}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_procedure.valid_patient_card_number" />
                                </div>
                            </div>

                            <div class="col-md-5">
                                <label for="access" class="form-label"><fmt:message key="new_procedure.performer" /></label>
                                <select class="form-select" id="access" name="${RequestParameter.PROCEDURE_ACCESS}" required>
                                    <option value=""><fmt:message key="new_procedure.choose" /></option>
                                    <option value="3"><fmt:message key="new_procedure.doctor" /></option>
                                    <option value="4"><fmt:message key="new_procedure.nurse" /></option>
                                </select>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_procedure.select_valid_performer." />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="specification" class="form-label"><fmt:message key="new_procedure.specification" /></label>
                                <input type="text" class="form-control" id="specification" placeholder=""
                                       name="${RequestParameter.PROCEDURE_SPECIFICATION}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_procedure.valid_specification" />
                                </div>
                            </div>

                            <hr class="my-4">
                        </div>
                        <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="new_procedure.create" /></button>
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