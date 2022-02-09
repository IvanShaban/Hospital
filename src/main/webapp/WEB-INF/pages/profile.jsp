<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 05.02.2022
  Time: 15:39
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
    <title>Profile</title>
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
                <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">
                <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">
                <div class="row g-3">
                    <div class="col-sm-6">
                        <label for="firstName" class="form-label">Name</label>
                        <input type="text" class="form-control" id="firstName" placeholder=""
                               name="${RequestParameter.USER_NAME}" value="" required>
                        <div class="invalid-feedback">
                            Valid name is required.
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <label for="lastName" class="form-label">Surname</label>
                        <input type="text" class="form-control" id="lastName" placeholder=""
                               name="${RequestParameter.USER_SURNAME}" value="" required>
                        <div class="invalid-feedback">
                            Valid surname is required.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="patronymic" class="form-label">Patronymic</label>
                        <input type="text" class="form-control" id="patronymic" placeholder=""
                               name="${RequestParameter.USER_PATRONYMIC}" value="" required>
                        <div class="invalid-feedback">
                            Valid patronymic is required.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="phone-number" class="form-label">Phone number</label>
                        <div class="input-group has-validation">
                            <span class="input-group-text">+</span>
                            <input type="number" class="form-control" id="phone-number" placeholder=""
                                   name="${RequestParameter.PHONE_NUMBER}" value="" required>
                            <div class="invalid-feedback">
                                Your phone number is required.
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <div class="col-12">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder=""
                               name="${RequestParameter.EMAIL}" value="" required>
                        <div class="invalid-feedback">
                            Please enter a valid email address.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" placeholder=""
                               name="${RequestParameter.PASSWORD}" value="" required>
                        <div class="invalid-feedback">
                            Please enter a valid password.
                        </div>
                    </div>

                    <hr class="my-4">

                    <div class="col-md-5">
                        <label for="country" class="form-label">Department</label>
                        <select class="form-select" id="country" name="${RequestParameter.DEPARTMENT_ID}" required>
                            <option value="">Choose...</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                        <div class="invalid-feedback">
                            Please select a valid department.
                        </div>
                    </div>

                    <div class="col-12">
                        <label for="specialisation" class="form-label">Specialisation</label>
                        <input type="text" class="form-control" id="specialisation" placeholder=""
                               name="${RequestParameter.USER_SPECIALISATION}" value="" required>
                        <div class="invalid-feedback">
                            Please enter your specialisation.
                        </div>
                    </div>
                </div>

                <hr class="my-4">

                <button class="w-100 btn btn-primary btn-lg" type="submit">Confirm</button>
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
