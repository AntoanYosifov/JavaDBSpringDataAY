package _01_wizardDeposits;

import utils.Utils;

import javax.persistence.EntityManager;

public class WizardDeposits {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager("CodeFirstEx");
        entityManager.getTransaction().begin();



        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
