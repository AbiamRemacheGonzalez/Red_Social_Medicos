package com.example.red_social_medicos.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager(String persistenceUnitName) {
        if(persistenceUnitName=="") persistenceUnitName = "default";
        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
        return entityManagerFactory.createEntityManager();
    }
}
