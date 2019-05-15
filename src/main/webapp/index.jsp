<%@ page contentType="text/html;charset=utf-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:if test="${user==null}">
    <a href="loginUi">登录</a>
    <a href="registerUi">注册</a>
</c:if>
<c:if test="${user!=null}">
    欢迎您:${user.userName}
    <input type="button" value="退出登录">
</c:if>
</body>
</html>
