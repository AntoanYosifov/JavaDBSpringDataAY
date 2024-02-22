package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Utils {
    public static EntityManager getEntityManager(String persistenceUnit){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnit);

        return  factory.createEntityManager();
    }
}
