<%@ page import="com.example.red_social_medicos.Model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.red_social_medicos.Model.Post" %>
<%@ page import="com.example.red_social_medicos.Model.Community" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User loadedUser = (User) session.getAttribute("loadedUser");%>
<% List<String> posts_html = (List<String>) session.getAttribute("posts_html");%>
<% List<Post> posts = (List<Post>) session.getAttribute("posts");%>
<% List<Community> communitiesPosts = (List<Community>) session.getAttribute("communitiesPosts");%>
<% List<User> usersPosts = (List<User>) session.getAttribute("usersPosts");%>
<% List<Long> postLikes = (List<Long>) session.getAttribute("postLikes");%>
<% List<Boolean> postUserEvaluation = (List<Boolean>) session.getAttribute("postUserEvaluation");%>
<% Long numberOfPages = (Long) session.getAttribute("numberOfPages");%>
<% int currentPage = (int) session.getAttribute("currentPage");%>

<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css_files/base_style.css" media="screen"/>
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

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

<div class="container">
    <p><h2 style="color:#a6a3a3;">Home</h2></p>
    <p style="padding-top:4px;color:#4E4F50;font-size:14px">Welcome <%=loadedUser.getUserName()%>! In home page you can see the posts of the communities you are joined.</p><br>
    <%
        out.println("<table class='search'><tr><td>\n" +
                "<form action='FrontControllerServlet'>\n" +
                "           <input type=\"hidden\" name=\"command\" value=\"SearchPostCommand\"></input>\n" +
                "           <input type=\"hidden\" name=\"page\" value=\"1\"></input>\n" +
                "           <input class='input-text' name='search_text' placeholder='Buscar post' type='text'/>\n" +
                "           <button type='submit'><i class='fa fa-search'></i></button>\n" +
                "</form>\n" +
                "</td></tr></table><br>");


        for (int i = 0; i < posts.size(); i++) {
            Community currentCommunity = communitiesPosts.get(i);
            User currentUser = usersPosts.get(i);
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
                    "   <td> <p style=\"font-size:12px\">Likes "+postLikes.get(i)+"</p></td>"+
                    "</tr>");
            out.println(htmlPostTransformation);
            out.println("<div class=\"postfoot\"><tr>\n" +
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
                    "           <input type=\"hidden\" name=\"postId\" value='"+posts.get(i).getPostId()+"'>\n"+
                    "           <input type=\"hidden\" name=\"requestOriginPath\" value='/main_page.jsp'>\n");
            if(postUserEvaluation.get(i)){
                out.println("           <input type=\"submit\" class=\"commmentSubmit\" name=\"Dislike\" value=\"Dislike\"></input>\n");
            }else{
                out.println("           <input type=\"submit\" class=\"commmentSubmit\" name=\"Like\" value=\"Like\"></input>\n");
            }

            out.println("       </form>\n" +
                    "   </td>\n" +
                    "</tr></div>"+
                    "</table><br>");
        }
        out.println("<p style=\"padding-top:3px;padding-bottom:10px;color:#4E4F50;font-size:14px;text-align:center;\">Page "+currentPage+" of "+numberOfPages+"</p>");
        out.println("<div style=\"text-align:center;\">");
        if(currentPage!=1)out.println("<a href=\"FrontControllerServlet?command=SearchPostCommand&page="+(currentPage-1)+"\">Anterior</a>");
        for (int i = 1; i <= numberOfPages; i++) {
            out.println("<a href=\"FrontControllerServlet?command=SearchPostCommand&page="+i+"\">"+i+"</a>");
        }
        if(currentPage!=numberOfPages)out.println("<a href=\"FrontControllerServlet?command=SearchPostCommand&page="+(currentPage+1)+"\">Siguiente</a>");
        out.println("</div>");

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
