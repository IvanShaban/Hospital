<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${sessionScope.locale != null ? sessionScope.locale : 'en'}"/>
<fmt:setBundle basename="locale"/>

<html>
<head>
    <jsp:include page="templates/links.jsp" />
    <title><fmt:message key="contacts.contacts" /></title>
</head>
<body>
<header>
    <jsp:include page="templates/header.jsp" />
</header>
<main>

</main>
<footer>
    <jsp:include page="templates/footer.jsp" />
</footer>
</body>
</html>
