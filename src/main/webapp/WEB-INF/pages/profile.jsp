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
    <title><fmt:message key="profile.profile" /></title>
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
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.PROFILE_CHANGE_COMMAND}">
                        <div class="row g-3">
                            <div class="col-sm-6">
                                <label for="firstName" class="form-label"><fmt:message key="profile.name" /></label>
                                <input type="text" class="form-control" id="firstName" placeholder=""
                                       name="${RequestParameter.USER_NAME}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_name" />
                                </div>
                            </div>

                            <div class="col-sm-6">
                                <label for="lastName" class="form-label"><fmt:message key="profile.surname" /></label>
                                <input type="text" class="form-control" id="lastName" placeholder=""
                                       name="${RequestParameter.USER_SURNAME}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_surname" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="patronymic" class="form-label"><fmt:message key="profile.patronymic" /></label>
                                <input type="text" class="form-control" id="patronymic" placeholder=""
                                       name="${RequestParameter.USER_PATRONYMIC}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_patronymic" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="phone-number" class="form-label"><fmt:message key="profile.phone_number" /></label>
                                <div class="input-group has-validation">
                                    <span class="input-group-text">+</span>
                                    <input type="number" class="form-control" id="phone-number" placeholder=""
                                           name="${RequestParameter.PHONE_NUMBER}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="profile.valid_phone_number" />
                                    </div>
                                </div>
                            </div>

                            <hr class="my-4">

                            <div class="col-12">
                                <label for="email" class="form-label"><fmt:message key="profile.email" /></label>
                                <input type="email" class="form-control" id="email" placeholder=""
                                       name="${RequestParameter.EMAIL}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.enter_valid_email" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="password" class="form-label"><fmt:message key="profile.password" /></label>
                                <input type="password" class="form-control" id="password" placeholder=""
                                       name="${RequestParameter.PASSWORD}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_password" />
                                </div>
                            </div>

                            <hr class="my-4">

                            <div class="col-md-5">
                                <label for="country" class="form-label"><fmt:message key="profile.department" /></label>
                                <select class="form-select" id="country" name="${RequestParameter.DEPARTMENT_ID}" required>
                                    <option value=""><fmt:message key="profile.choose" /></option>
                                    <c:forEach items="${requestScope.departments}" var="department">
                                        <option value="${department.id}">${department.title}</option>
                                    </c:forEach>
                                </select>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_department" />
                                </div>
                            </div>

                            <div class="col-12">
                                <label for="specialisation" class="form-label"><fmt:message key="profile.specialisation" /></label>
                                <input type="text" class="form-control" id="specialisation" placeholder=""
                                       name="${RequestParameter.USER_SPECIALISATION}" value="" required>
                                <div class="invalid-feedback">
                                    <fmt:message key="profile.valid_specialisation" />
                                </div>
                            </div>
                        </div>

                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="profile.confirm" /></button>
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
