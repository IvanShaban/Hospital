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
    <title><fmt:message key="new_chamber.new_chamber" /></title>
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
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.CREATE_NEW_CHAMBER_COMMAND}">
                        <input type="hidden" name="${RequestParameter.DEPARTMENT_ID}" value="${sessionScope.USER_DEPARTMENT_ID}">
                        <div class="row g-3">
                            <div class="col-md-5">
                                <label for="chamber-number" class="form-label"><fmt:message key="new_chamber.chamber_number" /></label>
                                <input type="number" class="form-control" id="chamber-number" placeholder=""
                                       name="${RequestParameter.CHAMBER_ID}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_chamber.valid_chamber_number" />
                                </div>
                            </div>
                            <div class="col-md-5">
                                <label for="number-of-beds" class="form-label"><fmt:message key="new_chamber.number_of_beds" /></label>
                                <input type="number" class="form-control" id="number-of-beds" placeholder=""
                                       name="${RequestParameter.CHAMBER_BEDS_NUMBER}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="new_chamber.valid_beds_number" />
                                </div>
                            </div>
                            <hr class="my-4">
                        </div>
                        <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="new_chamber.create" /></button>
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