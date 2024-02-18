package solutions;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class FindEmployeesByFirstName_11 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);

        String patternInput = scanner.nextLine();

        String patternArgument = patternInput + "%";

        entityManager.createQuery("SELECT e FROM Employee e " +
                        " WHERE e.firstName LIKE :patternArgument", Employee.class)
                .setParameter("patternArgument", patternArgument)
                .getResultStream()
                .forEach
                        (e -> System.out.printf("%s %s - %s - ($%.2f)\n",
                                e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
