<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
    <title>First page</title>
</head>
<body>
    <h2>welcome to home page</h2>

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="logout"/>
    </form:form>
<hr>
    <%--<security:authorize url="${pageContext.request.contextPath}/leader.jsp">--%>
        <a href="${pageContext.request.contextPath}/leader">leader page</a>
    <%--</security:authorize>--%>
    <%--<security:authorize url="system.jsp">--%>
        <a href="${pageContext.request.contextPath}/system">system page</a>
    <%--</security:authorize>--%>
</body>
</html>