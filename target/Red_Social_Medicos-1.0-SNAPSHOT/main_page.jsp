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
    <link rel="stylesheet" type="text/css" href="css_files/base_style.css" media="screen"/>
</head>
<body>
<!-- Navbar-->
<header></header>
<nav class="navMenu">
    <a href="#">Home</a>
    <a href="#">Posts</a>
    <a href="#">Profile</a>
    <a href="#">LogOut</a>
    <div class="dot"></div>
</nav>


<!-- For demo purpose -->
<div class="container">
    <%=communities_html%>
    <div class="pt-5 text-white">
        <header class="py-5 mt-5">
            <h1 class="display-4">Explore</h1>
            <p class="lead mb-0">Using Bootstrap 4 and Javascript, create a transparent navbar which changes its style on scroll.</p>
            <p class="lead mb-0">Snippet by
                <a href="https://bootstrapious.com" class="text-white">
                    <u>Bootstrapious</u></a>
            </p>
        </header>
        <div class="py-5">
            <p class="lead">Lorem ipsum dolor sit amet, <strong class="font-weight-bold">consectetur adipisicing </strong>elit. Explicabo consectetur odio voluptatum facere animi temporibus, distinctio tempore enim corporis quam <strong class="font-weight-bold">recusandae </strong>placeat! Voluptatum voluptate, ex modi illum quas nam distinctio.</p>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
        <div class="py-5">
            <p class="lead">Lorem ipsum dolor sit amet, <strong class="font-weight-bold">consectetur adipisicing </strong>elit. Explicabo consectetur odio voluptatum facere animi temporibus, distinctio tempore enim corporis quam <strong class="font-weight-bold">recusandae </strong>placeat! Voluptatum voluptate, ex modi illum quas nam distinctio.</p>
            <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        </div>
    </div>
</div>



</body>
</html>
