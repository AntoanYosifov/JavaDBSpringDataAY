package solutions;

import com.mysql.cj.x.protobuf.MysqlxResultset;
import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class IncreaseSalaries_10 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();
        entityManager.getTransaction().begin();

        String departments = "Engineering, Tool Design, Marketing, Information Services";
        String[] departmentNames = departments.split(", ");

        List<Employee> employeeList = entityManager.createQuery("SELECT e FROM Employee e " +
                        " WHERE e.department.name IN (:departments)", Employee.class)
                .setParameter("departments", Arrays.asList(departmentNames))
                .getResultList();

        for (Employee employee : employeeList) {
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal increase = currentSalary.multiply(new BigDecimal("0.12"));
            BigDecimal increasedSalary = currentSalary.add(increase);
            employee.setSalary(increasedSalary);
            entityManager.persist(employee);
        }

        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        " WHERE e.department.name IN (:departments)", Employee.class)
                .setParameter("departments", Arrays.asList(departmentNames))
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s ($%.2f)\n",
                        e.getFirstName(), e.getLastName(), e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
