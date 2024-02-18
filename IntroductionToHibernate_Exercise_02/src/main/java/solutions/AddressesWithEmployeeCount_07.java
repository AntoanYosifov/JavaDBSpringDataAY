package solutions;

import entities.Address;
import utils.Utils;

import javax.persistence.EntityManager;

public class AddressesWithEmployeeCount_07 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.createQuery("FROM Address a " +
                                " ORDER BY a.employees.size DESC ",
                        Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
