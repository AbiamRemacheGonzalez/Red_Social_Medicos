package com.example.red_social_medicos.Persistence;

import com.example.red_social_medicos.Model.EmailDatabaseEntity;
import com.example.red_social_medicos.Model.User;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UsersEntityFacade extends AbstractFacade<User> {

    @PersistenceContext
    private final EntityManager em = EntityManagerGenerator.getEntityManager("entities");

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersEntityFacade() {
        super(User.class);
    }

    public User findBy(String userEmail, String userPassword) {
        EmailDatabaseEntity userMail = EmailDatabaseEntity.getEmailByString(userEmail);
        List<User> users = em.createQuery("SELECT c from  User c where c.userPassword = :userPassword and c.userEmail = :userEmail").setParameter("userPassword",userPassword).setParameter("userEmail",userMail).getResultList();
        if(users.isEmpty()) return null;
        return users.get(0);
    }
}
