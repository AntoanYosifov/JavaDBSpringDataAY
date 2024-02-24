package _03_universitySystem;


import utils.Utils;

import javax.persistence.EntityManager;

public class _03_Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager("CodeFirstEx");
        entityManager.getTransaction().begin();




        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
