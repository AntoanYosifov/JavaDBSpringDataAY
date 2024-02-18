package solutions;

import entities.Address;
import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class InsertAddress_06 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);

        String addressText = "Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        entityManager.persist(address);

        String lastName = scanner.nextLine();

        entityManager.createQuery("UPDATE Employee e" +
                        " SET e.address = :address" +
                        " WHERE e.lastName = :name")
                .setParameter("name", lastName)
                .setParameter("address", address)
                .executeUpdate();

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
