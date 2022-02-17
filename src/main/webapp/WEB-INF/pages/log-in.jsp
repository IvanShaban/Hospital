<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.epam.hospital.controller.constant.RequestParameter" %>
<%@ page import="com.epam.hospital.controller.command.CommandName" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/log-in-style.css">
<head>
    <jsp:include page="templates/links.jsp" />
    <title><fmt:message key="log_in.log_in" /></title>
</head>
<body class="text-center">
    <header>

    </header>
    <main class="form-signin">
        <form action="controller" method="post">
            <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.LOG_IN_COMMAND}">
            <h1 class="h3 mb-3 fw-normal"><fmt:message key="log_in.please_sign_in" /></h1>
            <div class="form-floating">
                <input type="email" name="${RequestParameter.EMAIL}" value="${requestScope.user_email}" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                <label for="floatingInput"><fmt:message key="log_in.email_address" /></label>
            </div>
            <div class="form-floating">
                <input type="password" name="${RequestParameter.PASSWORD}" value="" class="form-control" id="floatingPassword" placeholder="Password" required>
                <label for="floatingPassword"><fmt:message key="log_in.password" /></label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit"><fmt:message key="log_in.sign_in" /></button>
        </form>
    </main>
    <footer>

    </footer>
</body>
</html>
