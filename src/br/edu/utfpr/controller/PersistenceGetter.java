package br.edu.utfpr.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Bernardo Vale
 *         Date: 20/12/12
 *         Time: 20:32
 */
public class PersistenceGetter {
    private static final String PERSISTENCE_UNIT_NAME = "jee1912";
    private static EntityManagerFactory factory;
    private static EntityManager em;


    public static EntityManager getManager(){
        if(em == null){
           factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
           em = factory.createEntityManager();
        }
        return em;
    }
    private PersistenceGetter() {
    }
}
