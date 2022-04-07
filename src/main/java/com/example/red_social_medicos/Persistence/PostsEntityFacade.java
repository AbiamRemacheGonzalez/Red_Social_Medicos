package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PostsEntityFacade extends AbstractFacade{
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostsEntityFacade() {
        super(Post.class);
    }

    public List<Post> getUserCommunitiesPosts(int userId){
        CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();
        List<Post> userCommunitiesPosts = new ArrayList<>();
        List<Community> userCommunities = communitiesEntityFacade.findByUserId(userId);
        for (Community userCommunity: userCommunities) {
            List<Post> userCommunityPosts = this.findByCommunityId(userCommunity.getCommunityId());
            userCommunitiesPosts.addAll(userCommunityPosts);
        }
        return userCommunitiesPosts;
    }

    public List<Post> findByCommunityId(int communityId){
        return em.createQuery("SELECT c from  Post c where c.communityId = :communityId order by c.creationDate")
                .setParameter("communityId",communityId)
                .getResultList();
    }
}
