<%@ page import="com.example.red_social_medicos.Model.User" %>
<%@ page import="com.example.red_social_medicos.Model.Aditionaluserinfo" %>
<%@ page import="com.example.red_social_medicos.Model.Comment" %>
<%@ page import="com.example.red_social_medicos.Model.Post" %><%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 09/04/2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Comment comment = (Comment) session.getAttribute("comment");%>
<% Post currentPost = (Post) session.getAttribute("currentPost");%>

<html>
<head>
    <title>Comment Page</title>
    <link rel="stylesheet" type="text/css" href="css_files/base_style.css" media="screen"/>
</head>
<body>
<%
    String Edit = (String) request.getParameter("editmode");
    if(request.getParameter("editmode")==null) Edit = "";
%>
<div class="container">

    <p><h2 style="color:#a6a3a3;">Comment Page</h2></p>
    <p style="padding-top:4px;color:#4E4F50;font-size:14px">In comment page you can see your comment and edit him.</p><br>
    <form action="FrontControllerServlet">
        <input type="hidden" name="command" value="EditCommentCommand">
        <table>
            <tr>
                <th>Post title</th>
                <td><%=currentPost.getPostTitle()%></td>
            </tr>
            <tr>
                <th>Comment</th>
                    <%
                        if(Edit.equals("true")){
                            out.println("<td><input type=\"text\" name=\"comment-input\" value=\""+comment.getComment()+"\"></td>");
                        }else{
                            out.println("<td><input type=\"text\" name=\"comment-input\" value=\""+comment.getComment()+"\" readonly></td>");
                        }
                    %>
            </tr>
            <tr>
                <th>Last Edit Date</th>
                <td><%if(comment.getCreationDate() != null){ out.println(comment.getCreationDate().toString());}else{out.println("No date");}%></td>
            </tr>
            <tr>
                <th></th>
                <td>
                <%
                    if(comment.getCreationDate() != null) {
                        if (Edit.equals("true")) {
                            out.println("   <input type=\"hidden\" name=\"editmode\" value=\"false\"></td>" +
                                    "    <td><input type='submit' name='Edit' value='Edit Off'></td>");
                        } else {
                            out.println("   <input type=\"hidden\" name=\"editmode\" value=\"true\"></td>" +
                                    "       <td><input type='submit' name='Edit' value='Edit On'></td>");
                        }
                    }
                %>
                </td>
            </tr>
        </table>
    </form><br>
    <a href="main_page.jsp" class="joinButton">Go back</a>
</div>

</body>
</html>

