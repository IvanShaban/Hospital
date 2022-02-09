<%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 07.02.2022
  Time: 16:15
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
    <title>Department personal</title>
</head>
<body>
<header>
    <jsp:include page="templates/header.jsp" />
</header>
<main>
    <div class="d-flex flex-wrap">
        <jsp:include page="templates/sidebar.jsp" />
        <div>
            <main>
                <div class="row g-5">
                    <div class="col-md-7 col-lg-8">
                        <form class="needs-validation" action="controller" method="get" novalidate>
                            <%--                    <input type="hidden" name="${RequestParameter.COMMAND}" value="${CommandName.SEARCH_PROCEDURE_COMMAND}">--%>
                            <input type="hidden" name="${RequestParameter.USER_ROLE_ID}" value="${sessionScope.user_role_id}">
                            <input type="hidden" name="${RequestParameter.USER_ID}" value="${sessionScope.user_id}">
                            <div class="row g-3">
                                <table class="table table-hover">
                                    <thead>
                                    <tr>
                                        <th scope="col">#</th>
                                        <th scope="col">Number of beds</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${requestScope.chambers}" var="chamber">
                                        <tr>
                                            <th scope="row">${chamber.id}</th>
                                            <td>${chamber.bedsNumber}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>
            </main>
        </div>
    </div>
</main>
<footer>
    <jsp:include page="templates/footer.jsp" />
</footer>
<script src="static/form-validation.js"></script>
</body>
</html>