package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.DatabasePostLogger;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class AddPostCommand extends FrontCommand {
    DatabasePostLogger databasePostLogger = new DatabasePostLogger();
    private Community community;
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        community = (Community) session.getAttribute("community");
        saveNewPost();
        forward("/FrontControllerServlet?command=VisitPostCommunityCommand&communityId="+community.getCommunityId());
    }

    private void saveNewPost() {
        String postTitle = request.getParameter("postTitle");
        String postDescription = request.getParameter("postDescription");
        User loadedUser = (User) session.getAttribute("loadedUser");

        Post newPost = new Post(community.getCommunityId(),loadedUser.getUserId(),postTitle,postDescription);
        databasePostLogger.savePost(newPost);
    }
}
