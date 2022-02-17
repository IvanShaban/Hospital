<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/sign-up-style.css">
<head>
    <jsp:include page="templates/links.jsp" />
    <title><fmt:message key="sign_up.sign_up" /></title>
</head>
<body class="bg-light">
    <header>
        <jsp:include page="templates/header.jsp" />
    </header>
    <div class="container">
        <main>
            <div class="py-5 text-center">
                <h2><fmt:message key="sign_up.checkout_form" /></h2>
            </div>

            <div class="row g-5">
                <div class="col-md-7 col-lg-8">
                    <form class="needs-validation" action="controller" method="post" novalidate>
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SIGN_UP_COMMAND}">
                        <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="4">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="firstName" class="form-label"><fmt:message key="sign_up.name" /></label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" name="${RequestParameter.USER_NAME}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_name" />
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <label for="lastName" class="form-label"><fmt:message key="sign_up.surname" /></label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" name="${RequestParameter.USER_SURNAME}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_surname" />
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="patronymic" class="form-label"><fmt:message key="sign_up.patronymic" /></label>
                                    <input type="text" class="form-control" id="patronymic" placeholder="" name="${RequestParameter.USER_PATRONYMIC}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_patronymic" />
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="phone-number" class="form-label"><fmt:message key="sign_up.phone_number" /></label>
                                    <div class="input-group has-validation">
                                        <span class="input-group-text">+</span>
                                        <input type="tel" class="form-control" id="phone-number" placeholder="375291234567" name="${RequestParameter.PHONE_NUMBER}" value="" required>
                                        <div class="invalid-feedback">
                                            <fmt:message key="sign_up.valid_phone_number" />
                                        </div>
                                    </div>
                                </div>

                                <hr class="my-4">

                                <div class="col-12">
                                    <label for="email" class="form-label"><fmt:message key="sign_up.email" /></label>
                                    <input type="email" class="form-control" id="email" placeholder="you@example.com" name="${RequestParameter.EMAIL}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.enter_valid_email" />
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="password" class="form-label"><fmt:message key="sign_up.password" /></label>
                                    <input type="password" class="form-control" id="password" placeholder="" name="${RequestParameter.PASSWORD}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_password" />
                                    </div>
                                </div>

                                <hr class="my-4">

                                <div class="col-md-5">
                                    <label for="country" class="form-label"><fmt:message key="sign_up.department" /></label>
                                    <select class="form-select" id="country" name="${RequestParameter.DEPARTMENT_ID}" required>
                                        <option value=""><fmt:message key="sign_up.choose" /></option>
                                        <c:forEach items="${requestScope.departments}" var="department">
                                            <option value="${department.id}">${department.title}</option>
                                        </c:forEach>
                                    </select>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_department" />
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="specialisation" class="form-label"><fmt:message key="sign_up.specialisation" /></label>
                                    <input type="text" class="form-control" id="specialisation" placeholder="" name="${RequestParameter.USER_SPECIALISATION}" value="" required>
                                    <div class="invalid-feedback">
                                        <fmt:message key="sign_up.valid_specialisation" />
                                    </div>
                                </div>
                            </div>

                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit"><fmt:message key="sign_up.sign_up" /></button>
                    </form>
                </div>
            </div>
        </main>
    </div>
    <footer>
        <jsp:include page="templates/footer.jsp" />
    </footer>
<script src="static/form-validation.js"></script>
</body>
</html>
