<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.02.2022
  Time: 1:30
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Sign-up</title>
</head>
<body class="bg-light">
    <header>
        <jsp:include page="templates/header.jsp" />
    </header>
    <div class="container">
        <main>
            <div class="py-5 text-center">
<%--                <img class="d-block mx-auto mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">--%>
                <h2>Checkout form</h2>
<%--                <p class="lead">Below is an example form built entirely with Bootstrap’s form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>--%>
            </div>

            <div class="row g-5">
                <div class="col-md-7 col-lg-8">
                    <form class="needs-validation" action="controller" method="post" novalidate>
                        <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SIGN_UP_COMMAND}">
                        <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="4">
                            <div class="row g-3">
                                <div class="col-sm-6">
                                    <label for="firstName" class="form-label">Name</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" name="${RequestParameter.USER_NAME}" value="" required>
                                    <div class="invalid-feedback">
                                        Valid name is required.
                                    </div>
                                </div>

                                <div class="col-sm-6">
                                    <label for="lastName" class="form-label">Surname</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" name="${RequestParameter.USER_SURNAME}" value="" required>
                                    <div class="invalid-feedback">
                                        Valid surname is required.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="patronymic" class="form-label">Patronymic</label>
                                    <input type="text" class="form-control" id="patronymic" placeholder="" name="${RequestParameter.USER_PATRONYMIC}" value="" required>
                                    <div class="invalid-feedback">
                                        Valid patronymic is required.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="phone-number" class="form-label">Phone number</label>
                                    <div class="input-group has-validation">
                                        <span class="input-group-text">+</span>
                                        <input type="tel" class="form-control" id="phone-number" placeholder="375291234567" name="${RequestParameter.PHONE_NUMBER}" value="" required>
                                        <div class="invalid-feedback">
                                            Your phone number is required.
                                        </div>
                                    </div>
                                </div>

                                <hr class="my-4">

                                <div class="col-12">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" class="form-control" id="email" placeholder="you@example.com" name="${RequestParameter.EMAIL}" value="" required>
                                    <div class="invalid-feedback">
                                        Please enter a valid email address.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="password" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="password" placeholder="" name="${RequestParameter.PASSWORD}" value="" required>
                                    <div class="invalid-feedback">
                                        Please enter a valid password.
                                    </div>
                                </div>

                                <hr class="my-4">

                                <div class="col-md-5">
                                    <label for="country" class="form-label">Department</label>
                                    <select class="form-select" id="country" name="${RequestParameter.DEPARTMENT_ID}" required>
                                        <option value="">Choose...</option>
                                        <option value="1">General surgical department</option>
                                        <option value="2">Admission department</option>
                                        <option value="3">Сardio surgery department</option>
                                        <option value="4">Purulent surgical department</option>
                                        <option value="5">Pediatric surgical department</option>
                                        <option value="6">Resuscitation department</option>
                                        <option value="7">Allergy department</option>
                                    </select>
                                    <div class="invalid-feedback">
                                        Please select a valid department.
                                    </div>
                                </div>

                                <div class="col-12">
                                    <label for="specialisation" class="form-label">Specialisation</label>
                                    <input type="text" class="form-control" id="specialisation" placeholder="" name="${RequestParameter.USER_SPECIALISATION}" value="" required>
                                    <div class="invalid-feedback">
                                        Please enter your specialisation.
                                    </div>
                                </div>
                            </div>

                        <hr class="my-4">

                        <button class="w-100 btn btn-primary btn-lg" type="submit">Sign up</button>
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
