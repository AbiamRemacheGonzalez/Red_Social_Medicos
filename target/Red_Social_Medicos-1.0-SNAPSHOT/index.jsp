<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="prueba.css" media="screen"/>
</head>
<body>
<div class="container">
<div class="left">
    <div class="header">
        <h2 class="animation a1">Welcome Back</h2>
        <h4 class="animation a2">Log in to your account using email and password</h4>
    </div>
    <div class="form">
        <input type="email" class="form-field animation a3" placeholder="Email Address">
        <input type="password" class="form-field animation a4" placeholder="Password">
        <p class="animation a5"><a href="#">Forgot Password</a></p>
        <button class="animation a6">LOGIN</button>
    </div>
</div>
<div class="right"></div>
</div>
<form action="FrontControllerServlet">
    <input type="hidden" name="command" value="LoginCommand">
    <input type="text" name="userEmail" placeholder="Email Address">
    <input type="password" name="userPassword" placeholder="Password">
    <input type="submit" name="Sign in">
</form>
</body>
</html>