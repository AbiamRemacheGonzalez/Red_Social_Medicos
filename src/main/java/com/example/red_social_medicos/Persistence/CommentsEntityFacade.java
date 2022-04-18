package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.Comment;

import javax.persistence.EntityManager;

public class CommentsEntityFacade extends AbstractFacade{

    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    public CommentsEntityFacade() {super(Comment.class);    }

    @Override
    protected EntityManager getEntityManager() {return em;}

}
