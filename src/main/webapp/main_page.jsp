<%@ page import="com.example.red_social_medicos.Model.User" %><%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 04/03/2022
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<% String communities_html = (String) session.getAttribute("communities_html");%>
<html>
<head>
    <title>Communities</title>
    <link rel="stylesheet" type="text/css" href="prueba.css" media="screen"/>
</head>
<body>
<header>
<nav class="navMenu">
    <a href="#">Home</a>
    <a href="#">Posts</a>
    <a href="#">Profile</a>
    <a href="#">LogOut</a>
    <div class="dot"></div>
</nav>
</header>

<div class="container">
    <%=communities_html%>
</div>
</body>
</html>
