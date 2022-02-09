<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 01.02.2022
  Time: 1:29
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
<link rel="stylesheet" href="static/log-in-style.css">
<head>
    <jsp:include page="templates/links.jsp" />
    <title>Log-in</title>
</head>
<body class="text-center">
    <header>
<%--        <jsp:include page="templates/header.jsp" />--%>
    </header>
    <main class="form-signin">
        <form action="controller" method="post">
            <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.LOG_IN_COMMAND}">
            <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

            <div class="form-floating">
                <input type="email" name="${RequestParameter.EMAIL}" value="${requestScope.user_email}" class="form-control" id="floatingInput" placeholder="name@example.com" required>
                <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
                <input type="password" name="${RequestParameter.PASSWORD}" value="" class="form-control" id="floatingPassword" placeholder="Password" required>
                <label for="floatingPassword">Password</label>
            </div>

<%--            <div class="checkbox mb-3">--%>
<%--                <label>--%>
<%--                    <input type="checkbox" value="remember-me"> Remember me--%>
<%--                </label>--%>
<%--            </div>--%>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
<%--            <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>--%>
        </form>
    </main>
    <footer>
<%--        <jsp:include page="templates/footer.jsp" />--%>
    </footer>
</body>
</html>
