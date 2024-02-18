package solutions;

import entities.Department;
import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class EmployeesMaximumSalaries_12 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();
        entityManager.getTransaction().begin();

        List<Department> departmentList = entityManager.createQuery("FROM Department d ", Department.class)
                .getResultList();

        for (Department department : departmentList) {
            BigDecimal maxSalary = department.getEmployees().stream()
                    .map(Employee::getSalary)
                    .max(BigDecimal::compareTo)
                    .orElse(BigDecimal.ZERO);

            BigDecimal minValue = BigDecimal.valueOf(30000);
            BigDecimal maxValue = BigDecimal.valueOf(70000);

            if (maxSalary.compareTo(minValue) < 0 || maxSalary.compareTo(maxValue) > 0) {
                System.out.printf("%s %.2f\n", department.getName(), maxSalary);
            }

        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
