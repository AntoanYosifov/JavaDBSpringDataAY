package solutions;

import entities.Employee;
import utils.Utils;

import javax.persistence.EntityManager;

public class EmployeesFromDepartment_05 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        String department = "Research and Development";

        entityManager.createQuery("SELECT e FROM Employee e" +
                        " WHERE e.department.name = :departmentName" +
                        " ORDER BY e.salary ASC, e.id ASC", Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                .forEach(e -> {
                    String format = String.format("%s %s from %s - $%.2f"
                            , e.getFirstName(), e.getLastName(), department, e.getSalary());

                    System.out.println(format);
                });


        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
