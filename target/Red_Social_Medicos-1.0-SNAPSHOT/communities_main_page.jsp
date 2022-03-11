<%@ page import="com.example.red_social_medicos.Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.red_social_medicos.Model.Community" %>
<%@ page import="com.example.red_social_medicos.Persistence.DatabaseCommunityLoader" %><%--
  Created by IntelliJ IDEA.
  User: equipo
  Date: 10/03/2022
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<% List<Community> communities = (List<Community>) session.getAttribute("communities");%>
<% DatabaseCommunityLoader databaseCommunityLoader = new DatabaseCommunityLoader();%>
        <html>
<head>
    <title>Explore</title>
    <link rel="stylesheet" type="text/css" href="css_files/base_style.css" media="screen"/>
</head>
<body>
<header>
    <nav class="navMenu">
        <%
            out.println("<a href=\"FrontControllerServlet?command=LoginCommand&userEmail="+loadedUser.getUserEmail()+"&userPassword="+loadedUser.getUserPassword()+"\">Home</a>");
        %>
        <%
            out.println("<a href=\"FrontControllerServlet?command=ExploreCommunitiesCommand\">Explore</a>");
        %>
        <a href="#">Profile</a>
        <a href="index.jsp">LogOut</a>
        <div class="dot"></div>
    </nav>
</header>

<div class="container">
    <p><h2 style="color:#a6a3a3;">Explore</h2></p>
    <p style="padding-top:4px;color:#4E4F50;font-size:14px">In explore page you can see all the communities that exist.</p><br>
    <%
        for (Community community:communities) {
            out.println("<table>" +
                    "<tr>\n" +
                    "   <td>\n" +
                    "       <form action=\"FrontControllerServlet\">\n" +
                    "           <input type=\"hidden\" name=\"command\" value=\"VisitPostCommunityCommand\"></input>\n" +
                    "           <input type=\"hidden\" name=\"communityId\" value='" +community.getCommunityId() + "'></input>\n"+
                    "           <input type=\"submit\" class=\"communitySubmit_big\" name='"+community.getCommunityName()+"' value='"+community.getCommunityName()+"'></input>\n" +
                    "       </form>\n" +
                    "   </td>\n" +
                    "<td><p style=\"color:#787a7c;font-size:15px\">"+databaseCommunityLoader.numberOfMembers(community.getCommunityId())+" members</p></td>"+
                    "</tr></table><br>");
        }
    %>
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
