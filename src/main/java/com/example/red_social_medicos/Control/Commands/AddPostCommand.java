package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AddPostCommand extends FrontCommand {
    PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
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
        Post newPost = new Post();
        newPost.setUserId(loadedUser.getUserId());
        newPost.setCreationDate(Timestamp.valueOf(LocalDateTime.now()));
        newPost.setPostEvaluation(0);
        newPost.setCommunityId(community.getCommunityId());
        newPost.setPostTitle(postTitle);
        newPost.setPostDescription(postDescription);
        postsEntityFacade.create(newPost);
    }
}
