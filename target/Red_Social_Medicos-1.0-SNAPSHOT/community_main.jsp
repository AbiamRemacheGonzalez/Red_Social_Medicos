<%@ page import="com.example.red_social_medicos.Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.red_social_medicos.Model.Post" %>
<%@ page import="com.example.red_social_medicos.Model.Community" %>
<%@ page import="com.example.red_social_medicos.Persistence.DatabaseCommunityLoader" %>
<%@ page import="com.example.red_social_medicos.Persistence.DatabaseUserLoader" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<% Community community= (Community) session.getAttribute("community");%>
<% DatabaseCommunityLoader databaseCommunityLoader = new DatabaseCommunityLoader();%>
<% String community_html= (String) session.getAttribute("community_html");%>
<% List<String> posts_html = (List<String>) session.getAttribute("posts_html");%>
<% List<Post> posts = (List<Post>) session.getAttribute("posts");%>
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
        <a href="communities_main_page.jsp">Explore</a>
        <a href="#">Profile</a>
        <a href="index.jsp">LogOut</a>
        <div class="dot"></div>
    </nav>
</header>

<div class="container">
    <%=community_html%><br>
    <%
        String command = "JoinCommunityCommand";
        String button = "<input type=\"submit\" class=\"joinButton\" name=\"Join\" value=\"Join\"></input>\n";
        if(databaseCommunityLoader.userIsMember(community.getCommunityId(),loadedUser.getUserId())){
            command = "LeaveCommunityCommand";
            button = "<input type=\"submit\" class=\"leaveButton\" name=\"Leave\" value=\"Leave\"></input>\n";
        }
        out.println("<form action=\"FrontControllerServlet\">\n" +
                "           <input type=\"hidden\" name=\"command\" value='"+command+"'></input>\n" +
                "           <input type=\"hidden\" name=\"communityId\" value='" +community.getCommunityId() + "'></input>\n"+
                            button +
                "       </form>\n");
    %><br>

    <%
        DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
        for (int i = 0; i < posts.size(); i++) {
            Community currentCommunity = databaseCommunityLoader.getCommunity(posts.get(i).getCommunityId());
            User currentUser =  databaseUserLoader.loadUser(posts.get(i).getUserId());
            String htmlPostTransformation = posts_html.get(i);
            out.println("<table>" +
                    "<tr>\n" +
                    "   <td>\n" +
                    "       <form action=\"FrontControllerServlet\">\n" +
                    "           <input type=\"hidden\" name=\"command\" value=\"VisitPostCommunityCommand\"></input>\n" +
                    "           <input type=\"hidden\" name=\"communityId\" value='" +currentCommunity.getCommunityId() + "'></input>\n"+
                    "           <input type=\"submit\" class=\"communitySubmit\" name='"+currentCommunity.getCommunityName()+"' value='"+currentCommunity.getCommunityName()+"'></input>\n" +
                    "       </form>\n" +
                    "   </td>\n" +
                    "   <td> <p style=\"color:#4E4F50;font-size:12px\">Posted by "+currentUser.getUserName()+" at "+posts.get(i).getCreationDate()+"</td>"+
                    "   <td> <p style=\"font-size:12px\">Likes "+posts.get(i).getPostEvaluation()+"</p></td>"+
                    "</tr>" +
                    htmlPostTransformation +
                    "<div class=\"postfoot\"><tr>\n" +
                    "   <td>\n" +
                    "       <form action=\"FrontControllerServlet\">\n" +
                    "           <input type=\"hidden\" name=\"command\" value=\"CommentPostCommand\"></input>\n" +
                    "           <input type=\"hidden\" name=\"postId\" value='"+posts.get(i).getPostId()+"'></input>\n" +
                    "           <input type=\"submit\" class=\"commmentSubmit\" name=\"Comment\" value=\"Comment\"></input>\n" +
                    "       </form>\n" +
                    "   </td>\n" +
                    "   <td colspan=\"2\">\n" +
                    "       <form action=\"FrontControllerServlet\">\n" +
                    "           <input type=\"hidden\" name=\"command\" value=\"EvaluateCommand\"></input>\n" +
                    "           <input type=\"hidden\" name=\"postId\" value='"+posts.get(i).getPostId()+"'>\n" +
                    "           <input type=\"submit\" class=\"commmentSubmit\" name=\"Like\" value=\"Like\"></input>\n" +
                    "       </form>\n" +
                    "   </td>\n" +
                    "</tr></div>"+
                    "</table><br>");
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
