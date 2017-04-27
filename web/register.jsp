<%--
  Created by IntelliJ IDEA.
  User: 石昊
  Date: 2017/4/8
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<p>这是注册页面</p>
<div>
    <form action="${pageContext.request.contextPath}/login?state=register" method="post">
        username:<input type="text" name="username"><br>
        password:<input type="text" name="password"><br>
        <input type="submit" value="submit">
    </form>
    <h3>${msg}</h3>
</div>
</body>
</html>
