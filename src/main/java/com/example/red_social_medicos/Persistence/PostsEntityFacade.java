package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Community;
import com.example.red_social_medicos.Model.Post;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class PostsEntityFacade extends AbstractFacade{
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");
    CommunitiesEntityFacade communitiesEntityFacade = new CommunitiesEntityFacade();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostsEntityFacade() {
        super(Post.class);
    }

    public List<Post> findByCommunityId(int communityId){
        return em.createQuery("SELECT c from  Post c where c.communityId = :communityId order by c.creationDate")
                .setParameter("communityId",communityId)
                .getResultList();
    }

    public Long getCountOfPages(int userId, String searchKey){
        Long numOfPosts = (Long)em.createQuery("SELECT count(p) FROM Community c JOIN Post p ON c.communityId = p.communityId JOIN Member m ON p.communityId = m.communityId WHERE m.userId = :userId and p.postDescription LIKE concat('%',:searchKey,'%')")
                .setParameter("userId",userId)
                .setParameter("searchKey",searchKey)
                .getSingleResult();
        if(numOfPosts%5 != 0){
            return  (numOfPosts/5)+1;
        }else{
            return numOfPosts/5;
        }
    }

    public List<Post> searchUserCommunitiesPostsOptimized(int userId, String searchKey,Integer numOfPage){
        int first = (numOfPage-1)*5;
        return em.createQuery("SELECT p FROM Community c " +
                        "JOIN Post p ON c.communityId = p.communityId " +
                        "JOIN Member m ON p.communityId = m.communityId " +
                        "WHERE m.userId = :userId and p.postDescription " +
                        "LIKE concat('%',:searchKey,'%') order by p.postTitle")
                .setParameter("userId",userId)
                .setParameter("searchKey",searchKey)
                .setMaxResults(5)
                .setFirstResult(first)
                .getResultList();
    }
}
