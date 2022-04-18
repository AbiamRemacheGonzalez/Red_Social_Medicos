package com.example.red_social_medicos.Control.Commands;

import com.example.red_social_medicos.Control.XSLTProcessor;
import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;
import com.example.red_social_medicos.Model.User;
import com.example.red_social_medicos.Persistence.*;

import javax.servlet.ServletException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisitPostCommunityCommand extends FrontCommand{
    private CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();
    private MembersEntityFacade membersEntityFacade = new MembersEntityFacade();
    private PostsEntityFacade postsEntityFacade = new PostsEntityFacade();
    private EvaluationsEntityFacade evaluationsEntityFacade = new EvaluationsEntityFacade();
    private ModeratorsEntityFacade moderatorsEntityFacade = new ModeratorsEntityFacade();

    private UsersEntityFacade usersEntityFacade = new UsersEntityFacade();
    private final String first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\community_first_step.xsl";
    private final String second_step_xsl_file_path="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\community_second_step_1.xsl";
    private final String post_first_step_xsl_file_path ="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_first_step.xsl";
    private final String post_second_step_xsl_file_path="C:\\Users\\equipo\\IdeaProjects\\Red_Social_Medicos\\src\\main\\webapp\\xsl_files\\post_second_step.xsl";
    private int communityId;
    private User loadedUser;


    @Override
    public void process() throws ServletException, IOException, JAXBException {
        communityId = Integer.parseInt(request.getParameter("communityId"));
        loadedUser = (User) session.getAttribute("loadedUser");
        getCommunityDetails();
        getPostCommunities();
        forward("/community_main.jsp");
    }

    private void getPostCommunities() {
        response.setContentType("text/html");
        List<Post> posts = postsEntityFacade.findByCommunityId(communityId);
        List<String> posts_html = getPostsHtmlTransformation(posts);
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
        User user = (User)session.getAttribute("loadedUser");
        session.setAttribute("userIsMember",membersEntityFacade.isMemberOfACommunity(user.getUserId(),communityId));
        session.setAttribute("posts_html",posts_html);
        session.setAttribute("posts",posts);
        session.setAttribute("communitiesPosts",communitiesPosts);
        session.setAttribute("usersPosts",usersPosts);
        session.setAttribute("postLikes",postLikes);
        session.setAttribute("postUserEvaluation",postUserEvaluation);
    }

    private List<String> getPostsHtmlTransformation(List<Post> posts) {
        List<String> posts_html = new ArrayList<>();
        if(posts.isEmpty()){
            posts_html.add("This community doesn't have posts.");
            return posts_html;
        }
        XSLTProcessor xsltProcessor = new XSLTProcessor(post_first_step_xsl_file_path,post_second_step_xsl_file_path);
        for (Post post: posts) {
            posts_html.add(xsltProcessor.getTransformation(post.toXML()));
        }
        return posts_html;
    }

    private void getCommunityDetails() {
        Community community = communitiesEntityFacade.find(communityId);
        XSLTProcessor xsltProcessor = new XSLTProcessor(first_step_xsl_file_path,second_step_xsl_file_path);
        String community_html = xsltProcessor.getTransformation(community.toXML());
        session.setAttribute("userIsModerator",moderatorsEntityFacade.isModeratorOfACommunity(loadedUser.getUserId(),communityId));
        session.setAttribute("community_html",community_html);
        session.setAttribute("community",community);
    }
}
