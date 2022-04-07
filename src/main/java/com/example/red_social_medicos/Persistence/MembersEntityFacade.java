package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MembersEntityFacade extends AbstractFacade{
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembersEntityFacade() {super(Member.class);}

    public Long getCountOfMembers(int communityId){
        return (Long) em.createQuery("SELECT count(c) from Member c where c.communityId = :communityId").setParameter("communityId",communityId).getSingleResult();
    }

    public Boolean isMemberOfACommunity(int userId, int communityId){
        Long exist = (Long) em.createQuery("SELECT count(c) from Member c where c.communityId = :communityId and c.userId = :userId").setParameter("communityId",communityId).setParameter("userId",userId).getSingleResult();
        if(exist == 1) return true;
        return false;
    }

    public int getMemberId(int userId, int communityId){
        return (Integer) em.createQuery("select c.memberId from Member c where c.userId = :userId and c.communityId = :communityId").setParameter("communityId",communityId).setParameter("userId",userId).getSingleResult();
    }

    public void removeByUserAndCommunityId(int userId, int communityId){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.createQuery("delete from Member c where c.userId = :userId and c.communityId = :communityId")
                .setParameter("communityId",communityId)
                .setParameter("userId",userId)
                .executeUpdate();
        et.commit();
    }
}
