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
    <link rel="stylesheet" href="static/cards-style.css">
    <title><fmt:message key="department_chambers.department_chambers" /></title>
</head>
<body>
    <header>
        <jsp:include page="templates/header.jsp" />
    </header>
    <main>
    <div class="d-flex">
        <jsp:include page="templates/sidebar.jsp" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3 col-xl-3">
                    <a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_NEW_CHAMBER_PAGE_COMMAND}">
                        <div class="card bg-c-green order-card">
                            <div class="card-block">
                                <h6 class="m-b-20"></h6>
                                <h2 class="text-right"><i class="fa fa-cart-plus f-left"></i><span>+</span></h2>
                                <p class="m-b-0"><span class="f-right"><fmt:message key="department_chambers.add_new_chamber" /></span></p>
                            </div>
                        </div>
                    </a>
                </div>
                <c:forEach items="${requestScope.chambers}" var="chamber">
                    <div class="col-md-3 col-xl-3">
                        <a href="?${RequestParameter.COMMAND}=${CommandName.GOTO_CHAMBER_INFO_PAGE_COMMAND}&${RequestParameter.CHAMBER_ID}=${chamber.id}">
                            <div class="card bg-c-blue order-card">
                                <div class="card-block">
                                    <h6 class="m-b-20">${requestScope.department.title}</h6>
                                    <h2 class="text-right"><i class="fa fa-cart-plus f-left"></i><span>${chamber.id}</span></h2>
                                    <p class="m-b-0"><fmt:message key="department_chambers.free_beds" /><span class="f-right">${chamber.bedsNumber}</span></p>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
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