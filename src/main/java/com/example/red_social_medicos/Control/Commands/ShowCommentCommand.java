package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Comment;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.CommentsEntityFacade;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ShowCommentCommand extends FrontCommand{
    CommentsEntityFacade commentsEntityFacade = new CommentsEntityFacade();
    PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        Integer postId = Integer.parseInt(request.getParameter("postId"));
        Post curentPost = (Post) postsEntityFacade.find(postId);
        User loadedUser = (User) session.getAttribute("loadedUser");
        Comment comment = commentsEntityFacade.findComment(postId, loadedUser.getUserId());
        if(comment == null){
            comment = new Comment();
            comment.setComment("No comment");
            comment.setCreationDate(null);
        }
        session.setAttribute("comment",comment);
        session.setAttribute("currentPost",curentPost);
        forward("/comment_page.jsp");
    }
}
