package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Aditionaluserinfo;
import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.*;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginCommand extends FrontCommand{
    private UsersEntityFacade usersEntityFacade = new UsersEntityFacade();
    private PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
    private EvaluationsEntityFacade evaluationsEntityFacade = new EvaluationsEntityFacade();
    private CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();
    private AditionalUsersInfoEntityFacade aditionalUsersInfoEntityFacade = new AditionalUsersInfoEntityFacade();

    private String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
    private String second_step_xsl_file_path= "C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";


    @Override
    public void process() throws ServletException, IOException, JAXBException {
        System.out.print(first_step_xsl_file_path);
        System.out.print(second_step_xsl_file_path);
        if (checkLoginValues()){
            forward("/main_page.jsp");
        }else{
            forward("/login_error.jsp");
        }
    }

    private boolean checkLoginValues() {
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        User loadedUser = usersEntityFacade.findBy(userEmail,userPassword);
        Aditionaluserinfo aditionaluserinfo = aditionalUsersInfoEntityFacade.getAdditionaluserinfo(loadedUser.getUserId());
        session.setAttribute("loadedUser",loadedUser);
        session.setAttribute("additionuserinfo",aditionaluserinfo);
        if(loadedUser!=null) {
            List<Post> posts = postsEntityFacade.searchUserCommunitiesPostsOptimized(loadedUser.getUserId(), "",1);//postsEntityFacade.getUserCommunitiesPosts(loadedUser.getUserId());
            List<Community> communitiesPosts = new ArrayList<>();
            List<User> usersPosts = new ArrayList<>();
            List<Long> postLikes = new ArrayList<>();
            List<Boolean> postUserEvaluation = new ArrayList<>();
            for (Post post: posts) {
                communitiesPosts.add(communitiesEntityFacade.find(post.getCommunityId()));
                usersPosts.add(usersEntityFacade.find(post.getUserId()));
                postLikes.add(evaluationsEntityFacade.getLikes(post.getPostId()));
                postUserEvaluation.add(evaluationsEntityFacade.isEvaluate(post.getPostId(), loadedUser.getUserId()));
            }
            List<String> posts_html = getPostsHtmlTransformation(posts);
            session.setAttribute("posts",posts);
            session.setAttribute("numberOfPages",postsEntityFacade.getCountOfPages(loadedUser.getUserId(), ""));
            session.setAttribute("currentPage",1);
            session.setAttribute("posts_html",posts_html);
            session.setAttribute("communitiesPosts",communitiesPosts);
            session.setAttribute("usersPosts",usersPosts);
            session.setAttribute("postLikes",postLikes);
            session.setAttribute("postUserEvaluation",postUserEvaluation);
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
