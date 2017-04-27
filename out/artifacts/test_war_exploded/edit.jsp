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
    <title>edit</title>
</head>
<body>
<p>这是编辑页面</p>
<div>
    <form action="${pageContext.request.contextPath}/login?state=edit" method="post">
        username:<input type="text" value="<%request.getAttribute("_username");%>" name="username"><br>
        password:<input type="password" value="<%request.getAttribute("_password");%>" name="password"><br>
        <input type="submit" value="submit">
    </form>
</div>
</body>
</html>
