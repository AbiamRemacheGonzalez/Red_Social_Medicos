package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Evaluation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EvaluationsEntityFacade extends AbstractFacade{
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    @Override
    protected EntityManager getEntityManager() {return em;}

    public EvaluationsEntityFacade() {super(Evaluation.class);}


    public Boolean isEvaluate(Evaluation evaluation){
        Long exist = (Long) em.createQuery("SELECT count(e) from Evaluation e where e.postId = :postId and e.userId = :userId")
                .setParameter("postId",evaluation.getPostId())
                .setParameter("userId",evaluation.getUserId())
                .getSingleResult();
        if(exist == 1) return true;
        return false;
    }

    public Boolean isEvaluate(int postId, int userId){
        Long exist = (Long) em.createQuery("SELECT count(e) from Evaluation e where e.postId = :postId and e.userId = :userId")
                .setParameter("postId",postId)
                .setParameter("userId",userId)
                .getSingleResult();
        if(exist == 1) return true;
        return false;
    }

    public Long getLikes(int postId){
        return (Long) em.createQuery("SELECT count(e) FROM Evaluation e WHERE e.postId = :postId")
                .setParameter("postId",postId)
                .getSingleResult();
    }

    public void removeEvaluation(Evaluation evaluation){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createQuery("delete from Evaluation e where e.userId = :userId and e.postId= :postId")
                .setParameter("postId",evaluation.getPostId())
                .setParameter("userId",evaluation.getUserId())
                .executeUpdate();
        et.commit();
    }
}
