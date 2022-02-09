<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 07.02.2022
  Time: 1:45
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
    <title>Search procedure</title>
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
            <form class="needs-validation" action="controller" method="get" novalidate>
                <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SEARCH_PROCEDURE_COMMAND}">
                <%--                    <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">--%>
                <%--                    <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">--%>
                <div class="row g-3">
                    <div class="col-sm-6">
                        <label for="procedure-id" class="form-label">Procedure id</label>
                        <input type="number" class="form-control" id="procedure-id" placeholder=""
                               name="${RequestParameter.PROCEDURE_ID}" value="" required>
                        <div class="invalid-feedback">
                            Valid procedure id is required.
                        </div>
                    </div>

                    <button class="w-100 btn btn-primary btn-lg" type="submit">Search</button>

                    <c:if test="${requestScope.procedure != null}">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Procedure number</th>
                                <th scope="col">Patient card number</th>
                                <th scope="col">Procedure name</th>
                                <th scope="col">Appointed doctor id</th>
                                <th scope="col">Specification</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>${requestScope.procedure.id}</td>
                                <td>${requestScope.procedure.patientsId}</td>
                                <td>${requestScope.procedure.proceduresName}</td>
                                <td>${requestScope.procedure.appointedDoctorsId}</td>
                                <td>${requestScope.procedure.specification}</td>
                            </tr>
                            </tbody>
                        </table>
                    </c:if>
                </div>
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
