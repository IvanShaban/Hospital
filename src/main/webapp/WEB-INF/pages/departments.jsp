<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/departments-style.css">
<head>
    <jsp:include page="templates/links.jsp" />
    <title><fmt:message key="departments.departments" /></title>
</head>
<body>
    <header>
        <jsp:include page="templates/header.jsp" />
    </header>
    <main>
        <div class="container px-4 py-5" id="featured-3">
            <h2 class="pb-2 border-bottom">Columns with icons</h2>
            <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
                <div class="feature col">
                    <div class="feature-icon bg-primary bg-gradient">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#collection"/></svg>
                    </div>
                    <h2>Featured title</h2>
                    <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                    <a href="#" class="icon-link">
                        Call to action
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
                    </a>
                </div>
                <div class="feature col">
                    <div class="feature-icon bg-primary bg-gradient">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#people-circle"/></svg>
                    </div>
                    <h2>Featured title</h2>
                    <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                    <a href="#" class="icon-link">
                        Call to action
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
                    </a>
                </div>
                <div class="feature col">
                    <div class="feature-icon bg-primary bg-gradient">
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#toggles2"/></svg>
                    </div>
                    <h2>Featured title</h2>
                    <p>Paragraph of text beneath the heading to explain the heading. We'll add onto it with another sentence and probably just keep going until we run out of words.</p>
                    <a href="#" class="icon-link">
                        Call to action
                        <svg class="bi" width="1em" height="1em"><use xlink:href="#chevron-right"/></svg>
                    </a>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <jsp:include page="templates/footer.jsp" />
    </footer>
</body>
</html>
