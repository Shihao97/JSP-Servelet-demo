<%--
  Created by IntelliJ IDEA.
  User: 石昊
  Date: 2017/4/8
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
  </head>
  <body>
  <p>这是登录页面</p>
  <div>
  <form action="${pageContext.request.contextPath}/login?state=login" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" value="login">
  </form>
  <h3>${msg}</h3>
  </div>
  </body>
</html>
