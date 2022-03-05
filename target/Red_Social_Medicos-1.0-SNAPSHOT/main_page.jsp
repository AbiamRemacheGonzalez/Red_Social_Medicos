<%@ page import="com.example.red_social_medicos.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 04/03/2022
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<html>
<head>
    <title>Communities</title>
</head>
<body>
Hola, bienvenido <%= loadedUser.getUserName() %>
<a href="login.jsp">Cerrar Sesión</a>
</body>
</html>
