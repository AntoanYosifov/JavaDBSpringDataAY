package solutions;

import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class ContainsEmployee_03 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String[] nameInQuestion = scanner.nextLine().split(" ");

        Long employeeCount = entityManager.createQuery("SELECT COUNT(e) FROM Employee e" +
                        " WHERE e.firstName = :first_name" +
                        " AND e.lastName = :last_name", Long.class)
                .setParameter("first_name", nameInQuestion[0])
                .setParameter("last_name", nameInQuestion[1])
                .getSingleResult();

        if (employeeCount > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
