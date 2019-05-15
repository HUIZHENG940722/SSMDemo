<%--
  Created by IntelliJ IDEA.
  User: HUIZHENG
  Date: 2019/5/12
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <%--登录表单--%>
    <form action="login" method="post">
        用户名:<input name="userName" type="text" placeholder="请输入用户"><br>
        密码:<input name="userPwd" type="password" placeholder="请输入密码"><br>
        <input type="submit" value="登录"><label>${loginError}</label><br>
    </form>
</body>
</html>
