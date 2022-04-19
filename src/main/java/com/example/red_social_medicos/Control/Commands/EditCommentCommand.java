package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Comment;
import com.example.red_social_medicos.Persistence.CommentsEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;

public class EditCommentCommand extends FrontCommand{
    CommentsEntityFacade commentsEntityFacade = new CommentsEntityFacade();
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        Comment updateComment = (Comment) session.getAttribute("comment");
        if(!updateComment.getComment().equals(request.getParameter("comment-input"))){
            commentsEntityFacade.updateComment(updateComment, request.getParameter("comment-input"));
            session.setAttribute("comment",commentsEntityFacade.find(updateComment.getCommentId()));
        }
        forward("/comment_page.jsp");
    }
}
