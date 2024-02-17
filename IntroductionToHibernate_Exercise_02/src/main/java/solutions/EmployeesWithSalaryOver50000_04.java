package solutions;

import utils.Utils;

import javax.persistence.EntityManager;
import java.util.List;

public class EmployeesWithSalaryOver50000_04 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        List<String> resultList = entityManager.createQuery("SELECT e.firstName FROM Employee e" +
                " WHERE e.salary > 50000", String.class).getResultList();

        System.out.println(String.join("\n", resultList));
    }
}
