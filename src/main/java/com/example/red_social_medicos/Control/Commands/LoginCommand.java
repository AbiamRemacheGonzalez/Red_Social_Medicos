package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabaseCommunityLoader;
import com.example.red_social_medicos.Persistence.DatabaseUserLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class LoginCommand extends FrontCommand{
    private DatabaseUserLoader databaseUserLoader = new DatabaseUserLoader();
    private DatabaseCommunityLoader databaseCommunityLoader = new DatabaseCommunityLoader();
    private final String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\community_first_step.xsl";
    private final String second_step_xsl_file_path="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\community_second_step.xsl";;


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
            response.setContentType("text/html");
            HttpSession session = request.getSession(true);
            String communities_html = getCommutiesHtmlTransformation();
            session.setAttribute("communities_html",communities_html);
            session.setAttribute("loadedUser",loadedUser);
            return true;
        }
        return false;
    }

    private String getCommutiesHtmlTransformation() {
        String communities_html = "";
        List<Community> communities = databaseCommunityLoader.getAllCommunities();
        XSLTProcessor xsltProcessor = new XSLTProcessor(first_step_xsl_file_path,second_step_xsl_file_path);
        for (Community community: communities) {
            communities_html = communities_html + xsltProcessor.getTransformation(community.toXML());
        }
        return communities_html;
    }
}
