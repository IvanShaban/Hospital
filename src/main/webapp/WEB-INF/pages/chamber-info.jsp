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
    <jsp:include page="templates/links.jsp"/>
    <link rel="stylesheet" href="static/cards-style.css">
    <link rel="stylesheet" href="static/body-style.css">
    <title><fmt:message key="chamber_info.admin_personal" /></title>
</head>
<body>
    <header>
        <jsp:include page="templates/header.jsp"/>
    </header>
    <main>
    <div class="d-flex">
        <jsp:include page="templates/sidebar.jsp"/>
        <div class="d-flex flex-wrap">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3 col-xl-3">
                        <div class="card bg-c-blue order-card">
                            <div class="card-block">
                                <h6 class="m-b-20">${sessionScope.department_title}</h6>
                                <h2 class="text-right"><i
                                        class="fa fa-cart-plus f-left"></i><span>${sessionScope.chamber.id}</span></h2>
                                <p class="m-b-0"><fmt:message key="chamber_info.free_beds" /><span class="f-right">${sessionScope.chamber_free_beds}</span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row g-5">
                <div class="col-md-7 col-lg-8">
                    <form class="needs-validation" action="controller" method="post" novalidate>
                        <div class="row g-3">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col"><fmt:message key="chamber_info.card_number" /></th>
                                        <th scope="col"><fmt:message key="chamber_info.surname" /></th>
                                        <th scope="col"><fmt:message key="chamber_info.name" /></th>
                                        <th scope="col"><fmt:message key="chamber_info.patronymic" /></th>
                                        <th scope="col"><fmt:message key="chamber_info.provisional_diagnosis" /></th>
                                        <th scope="col"><fmt:message key="chamber_info.writing_out" /></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${requestScope.patients}" var="patient">
                                        <tr>
                                            <td>${patient.id}</td>
                                            <td>${patient.surname}</td>
                                            <td>${patient.name}</td>
                                            <td>${patient.patronymic}</td>
                                            <td>${patient.provisionalDiagnosis}</td>
                                            <td><a href="?${RequestParameter.COMMAND}=${CommandName.WRITE_OUT_PATIENT_COMMAND}&${RequestParameter.PATIENT_ID}=${patient.id}"><fmt:message key="chamber_info.write_out" /></a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
    <footer>
        <jsp:include page="templates/footer.jsp"/>
    </footer>
    <script src="static/form-validation.js"></script>
</body>
</html>