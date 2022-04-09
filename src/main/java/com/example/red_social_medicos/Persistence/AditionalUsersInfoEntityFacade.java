package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Aditionaluserinfo;

import javax.persistence.EntityManager;

public class AditionalUsersInfoEntityFacade extends AbstractFacade{

    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    public AditionalUsersInfoEntityFacade() {super(Aditionaluserinfo.class);    }

    @Override
    protected EntityManager getEntityManager() {return em;}

    public Aditionaluserinfo getAdditionaluserinfo(int userId){
        return (Aditionaluserinfo) em.createQuery("SELECT a FROM Aditionaluserinfo a WHERE a.userId = :userId")
                    .setParameter("userId",userId)
                    .getResultList().get(0);
    }
}
