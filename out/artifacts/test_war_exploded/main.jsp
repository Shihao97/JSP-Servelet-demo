<%--
  Created by IntelliJ IDEA.
  User: 石昊
  Date: 2017/4/8
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.test.web.entity.User" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>id</th>
            <th>username</th>
            <th>password</th>
            <th>delete</th>
            <th><a href="${pageContext.request.contextPath}/login?state=toadd">add</a></th>
        </tr>
        <%
            List<User> list = (List<User>) request.getAttribute("list");
            int num = 0;
            for(int i=0;i<list.size()&&list!=null;i++){
        %>
        <tr>
            <td><%=++num%></td>
            <td><a href="${pageContext.request.contextPath}/login?state=toedit&username=<%=list.get(i).getUsername()%>"><%=list.get(i).getUsername()%></a> </td>
            <td><%=list.get(i).getPassword()%></td>
            <td><a href="${pageContext.request.contextPath}/login?state=del&username=<%=list.get(i).getUsername()%>">delete</a> </td>
            <td></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
