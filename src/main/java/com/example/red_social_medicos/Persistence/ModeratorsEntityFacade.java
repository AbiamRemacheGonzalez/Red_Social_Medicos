package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Moderator;

import javax.persistence.EntityManager;

public class ModeratorsEntityFacade extends AbstractFacade{
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    public  ModeratorsEntityFacade() {super(Moderator.class);    }

    @Override
    protected EntityManager getEntityManager() {return em;}

    public Boolean isModeratorOfACommunity(int userId, int communityId){
        Long exist = (Long) em.createQuery("SELECT count(c) from Moderator c where c.communityId = :communityId and c.userId = :userId").setParameter("communityId",communityId).setParameter("userId",userId).getSingleResult();
        if(exist == 1) return true;
        return false;
    }
}
