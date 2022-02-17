<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<link rel="stylesheet" href="static/footer-style.css">
    <footer class="footer mt-auto py-3 bg-light">
        <div class="container">
            <span class="text-muted"><fmt:message key="footer.content" /></span>
        </div>
    </footer>
</html>
