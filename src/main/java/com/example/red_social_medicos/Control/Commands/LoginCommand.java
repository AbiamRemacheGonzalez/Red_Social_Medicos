package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabasePostLoader;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand extends FrontCommand{
    private DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
    private DatabasePostLoader databasePostLoader = new DatabasePostLoader();
    private final String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
    private final String second_step_xsl_file_path="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";;


    @Override
    public void process() throws ServletException, IOException, JAXBException {
        if (checkLoginValues()){
            forward("/main_page.jsp");
        }else{
            forward("/login_error.jsp");
        }
    }

    private boolean checkLoginValues() {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        User loadedUser = databaseUserLoader.loadUser(userEmail,userPassword);
        if(loadedUser!=null) {
            List<Post> posts = databasePostLoader.getMyCommunitiesPosts(loadedUser.getUserId());
            List<String> posts_html = getPostsHtmlTransformation(posts);
            session.setAttribute("posts",posts);
            session.setAttribute("posts_html",posts_html);
            session.setAttribute("loadedUser",loadedUser);
            return true;
        }
        return false;
    }

    private List<String> getPostsHtmlTransformation(List<Post> posts) {
        List<String> posts_html = new ArrayList<>();
        if(posts.isEmpty()){
            posts_html.add("Ups! You are not in a Community, try to join one.");
            return posts_html;
        }
        XSLTProcessor xsltProcessor = new XSLTProcessor(first_step_xsl_file_path,second_step_xsl_file_path);
        for (Post post: posts) {
            posts_html.add(xsltProcessor.getTransformation(post.toXML()));
        }
        return posts_html;
    }
}
