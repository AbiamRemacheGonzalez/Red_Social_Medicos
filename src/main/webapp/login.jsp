<%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 04/03/2022
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="prueba.css" media="screen"/>
</head>
<body>
<h2>Welcome Back</h2>
<h4>Log in to your account using email and password</h4>
<form action="FrontControllerServlet">
    <input type="hidden" name="command" value="LoginCommand">
    <input type="text" name="userEmail" placeholder="Email Address">
    <input type="password" name="userPassword" placeholder="Password">
    <input type="submit" name="Sign in">
</form>
</body>
</html>
