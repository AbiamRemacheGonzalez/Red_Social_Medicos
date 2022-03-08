<%@ page import="com.example.red_social_medicos.Model.User" %>
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
    <a href="#">Communities</a>
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
