package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.CommunitiesEntityFacade;
import com.example.red_social_medicos.Persistence.EvaluationsEntityFacade;
import com.example.red_social_medicos.Persistence.PostsEntityFacade;
import com.example.red_social_medicos.Persistence.UsersEntityFacade;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchPostCommand extends FrontCommand{
    private PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
    private EvaluationsEntityFacade evaluationsEntityFacade = new EvaluationsEntityFacade();
    private CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();
    private UsersEntityFacade usersEntityFacade = new UsersEntityFacade();

    private String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
    private String second_step_xsl_file_path= "C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";

    @Override
    public void process() throws ServletException, IOException, JAXBException {
        Integer page = Integer.parseInt(request.getParameter("page"));
        String searchKey = (request.getParameter("search_text")==null)?"":request.getParameter("search_text");
        User loadedUser = (User) session.getAttribute("loadedUser");

        List<Post> posts = postsEntityFacade.searchUserCommunitiesPostsOptimized(loadedUser.getUserId(), searchKey,page);

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
        session.setAttribute("numberOfPages",postsEntityFacade.getCountOfPages(loadedUser.getUserId(), searchKey));
        session.setAttribute("currentPage",page);
        session.setAttribute("posts_html",posts_html);
        session.setAttribute("communitiesPosts",communitiesPosts);
        session.setAttribute("usersPosts",usersPosts);
        session.setAttribute("postLikes",postLikes);
        session.setAttribute("postUserEvaluation",postUserEvaluation);
        forward("/main_page.jsp");
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
