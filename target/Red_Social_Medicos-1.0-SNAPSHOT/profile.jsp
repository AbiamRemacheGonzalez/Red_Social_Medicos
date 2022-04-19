<%@ page import="com.example.red_social_medicos.Model.User" %>
<%@ page import="com.example.red_social_medicos.Model.Aditionaluserinfo" %><%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 09/04/2022
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<% Aditionaluserinfo aditionaluserinfo = (Aditionaluserinfo) session.getAttribute("additionuserinfo");%>

<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="css_files/base_style.css" media="screen"/>
</head>
<body>
<header>
    <nav class="navMenu">
        <%
            out.println("<a href=\"FrontControllerServlet?command=LoginCommand&userEmail="+loadedUser.getUserEmail().toString()+"&userPassword="+loadedUser.getUserPassword()+"\">Home</a>");
        %>
        <%
            out.println("<a href=\"FrontControllerServlet?command=ExploreCommunitiesCommand\">Explore</a>");
        %>
        <a href="profile.jsp">Profile</a>
        <a href="index.jsp">LogOut</a>
        <div class="dot"></div>
    </nav>
</header>
<%
    String Edit = (String) request.getParameter("editmode");
    if(request.getParameter("editmode")==null) Edit = "";
%>
<div class="container">
    <p><h2 style="color:#a6a3a3;">Profile</h2></p>
    <p style="padding-top:4px;color:#4E4F50;font-size:14px">In profile page you can see all your profile information.</p><br>
    <form action="FrontControllerServlet">
        <input type="hidden" name="command" value="EditAdditionalInfoCommand">
<table>
    <tr>
        <th></th>
        <th>Email</th>
        <th>Age</th>
        <th>Sex</th>
        <th>Nationality</th>
        <th></th>
    </tr>
    <tr>
    <td><%=loadedUser.getUserName()%></td>
    <td><%=loadedUser.getUserEmail().toString()%></td>
        <%
            if(Edit.equals("true")){
                out.println("   <td><input type='text' name='age' value='"+aditionaluserinfo.getUserAge()+"'></td>\n" +
                            "   <td><input type='text' name='sex' value='"+aditionaluserinfo.getUserSex()+"'></td>\n" +
                            "   <td><input type='text' name='nationality' value='"+aditionaluserinfo.getUserNationality()+"'>\n" +
                            "   <input type=\"hidden\" name=\"editmode\" value=\"false\"></td>"+
                            "    <td><input type='submit' name='Edit' value='Edit Off'></td>");
            }else{
                out.println("   <td><input type='text' name='age' value='"+aditionaluserinfo.getUserAge()+"' readonly></td>\n" +
                        "       <td><input type='text' name='sex' value='"+aditionaluserinfo.getUserSex()+"' readonly></td>\n" +
                        "       <td><input type='text' name='nationality' value='"+aditionaluserinfo.getUserNationality()+"' readonly></td>" +
                        "   <input type=\"hidden\" name=\"editmode\" value=\"true\"></td>"+
                        "       <td><input type='submit' name='Edit' value='Edit On'></td>");
            }
        %>
    </tr>
</table>
    </form>
</div>

<footer id="mobile-footer">
    <div id="mobile-menu">
        <div id="mobile-footer-container">
            <div class="mobile-link">
                <a href="#" class="text-center">My Account</a>
            </div>
            <div class="mobile-link">
                <a href="#" class="text-center">Reviews</a>
            </div>
            <div class="mobile-link">
                <a href="#" class="text-center">Contact Us</a>
            </div>
        </div>
    </div>
    <div id="mobile-footer-close">
        <button id="mobile-footer-btn">
            <div class="mobile-btn-close is-rotating-back">
                <span></span>
            </div>
        </button>
    </div>
</footer>
</body>
</html>
