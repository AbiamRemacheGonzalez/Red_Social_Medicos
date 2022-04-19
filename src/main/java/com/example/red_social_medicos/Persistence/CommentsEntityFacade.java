package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Comment;
import com.example.red_social_medicos.Model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CommentsEntityFacade extends AbstractFacade{

    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    public CommentsEntityFacade() {super(Comment.class);    }

    @Override
    protected EntityManager getEntityManager() {return em;}

    public Comment findComment(int postId, int userId){
        List<Comment> Res = em.createQuery("SELECT c from  Comment c where c.userId = :userId and c.postId = :postId")
                .setParameter("userId",userId)
                .setParameter("postId",postId)
                .getResultList();
        if(Res.isEmpty())return null;
        return Res.get(0);
    }

    public void updateComment(Comment comment, String newComment){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveDayAgo = now.minusDays(5);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createQuery("update Comment c set c.comment = :comment where c.commentId = :commentId and c.creationDate > :fiveDayAgo")
                .setParameter("comment",newComment)
                .setParameter("commentId",comment.getCommentId())
                .setParameter("fiveDayAgo", Timestamp.valueOf(fiveDayAgo))
                .executeUpdate();
        et.commit();
    }
//Timestamp.valueOf(LocalDateTime.now())
}
