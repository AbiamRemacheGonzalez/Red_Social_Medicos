<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="css_files/main_style.css" media="screen"/>
</head>
<body>
<div class="container">
<div class="left">
    <div class="header">
        <h2 class="animation a1">Welcome Back</h2>
        <h4 class="animation a2">Log in to your account using email and password</h4>
    </div>
    <form class ="form" action="FrontControllerServlet">
        <input type="hidden" name="command" value="LoginCommand">
        <input type="text" name="userEmail" class="form-field animation a3" placeholder="Email Address">
        <input type="password" name="userPassword" class="form-field animation a4" placeholder="Password">
        <input type="submit" name="Sign in" class="animation a6">
    </form>
</div>
<div class="right"></div>
</div>
</body>
</html>