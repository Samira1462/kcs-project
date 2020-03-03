
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>لاگین</title>
    <style>
        .fail{
            color: red;
        }
    </style>
</head>
<body>
<sec:if test="${param.error != null}">

    <div >
        <sec:set var = "errorMessage" value = "${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
        <sec:if test = "${fn:containsIgnoreCase(errorMessage, 'Bad credentials')}">
            <div>نام كاربری یا كلمه عبور صحیح نمی باشد</div>
        </sec:if>

        <sec:if test = "${fn:containsIgnoreCase(errorMessage, 'UserDetailsService returned null')}">
            <div>نام كاربری یا كلمه عبور صحیح نمی باشد</div>
        </sec:if>

        <sec:if test = "${fn:containsIgnoreCase(errorMessage, 'User is disabled')}">
            <div>نام كاربری مورد نظر غیرفعال می باشد
            </div>
        </sec:if>
        <sec:if test = "${fn:containsIgnoreCase(errorMessage, 'User account is locked')}">
            <div>امكان ورود به سیستم برای این نام كاربری از این شعبه مقدور نمی باشد
            </div>
        </sec:if>
    </div>
</sec:if>
    <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">

        <p>
            User Name1111:<input type="text" name="username"/>
        </p>
        <p>
            Password:<input type="text" name="password"/>
        </p>
        <input type="submit" value="login"/>
    </form:form>
    <c:if test="${param.logout != null}">
        <i class="fail">
            you have been log out
        </i>
    </c:if>
</body>
</html>
