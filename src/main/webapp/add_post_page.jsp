<%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 04/03/2022
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Post</title>
    <link rel="stylesheet" type="text/css" href="css_files/main_style.css" media="screen"/>
</head>
<body>

<div class="container" style="background-color: #1A1A1B">
    <div class="left">
    <div class="header">
        <p><h2 style="color:#a6a3a3;">Create a post</h2></p>
    </div>
<form class="form" action="FrontControllerServlet">
    <input type="hidden" name="command" value="AddPostCommand">
    <input type="text" name="postTitle" class="form-field animation a3" placeholder="Post title">
    <textarea name="postDescription" class="form-field animation a4" placeholder="Post description"></textarea>
    <input type="submit" name="Post" value="Post" class="animation a6">
</form>
        <a href="community_main.jsp" class="joinButton">Go back</a>
    </div>
</div>
</body>
</html>