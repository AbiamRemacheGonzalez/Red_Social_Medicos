package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Evaluation;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.EvaluationsEntityFacade;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EvaluateCommand extends FrontCommand{
    private EvaluationsEntityFacade evaluationsEntityFacade = new EvaluationsEntityFacade();
    private PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
    private User loadedUser;
    private String requestOriginPath;
    @Override
    public void process() throws ServletException, IOException, JAXBException {
        loadedUser = (User) session.getAttribute("loadedUser");
        requestOriginPath = request.getParameter("requestOriginPath");

        evaluatePost();

        updateDataPage();

        forward(requestOriginPath);
    }

    private void evaluatePost() {

        Integer postId = Integer.parseInt(request.getParameter("postId"));
        
        Evaluation evaluation = new Evaluation();
        evaluation.setUserId(loadedUser.getUserId());
        evaluation.setPostId(postId);
        
        if(evaluationsEntityFacade.isEvaluate(evaluation)){
            evaluationsEntityFacade.removeEvaluation(evaluation);
        }else{
            evaluationsEntityFacade.create(evaluation);
        }
    }

    private void updateDataPage() {
        List<Post> posts = (List<Post>) session.getAttribute("posts");

        List<Long> postLikes = new ArrayList<>();
        List<Boolean> postUserEvaluation = new ArrayList<>();
        for (Post post: posts) {
            postLikes.add(evaluationsEntityFacade.getLikes(post.getPostId()));
            postUserEvaluation.add(evaluationsEntityFacade.isEvaluate(post.getPostId(), loadedUser.getUserId()));
        }
        session.setAttribute("postLikes",postLikes);
        session.setAttribute("postUserEvaluation",postUserEvaluation);
    }
}
