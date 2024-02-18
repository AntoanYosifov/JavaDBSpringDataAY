package solutions;

import entities.Employee;
import entities.Project;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class GetEmployeeWithProject_08 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee employee = entityManager.createQuery("FROM Employee e " +
                        "WHERE e.id = :employeeId", Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();

        String sortedProjectsNames = employee.getProjects()
                        .stream().map(Project::getName)
                        .sorted().collect(Collectors.joining("\n"));

        System.out.println(employee);
        System.out.println(sortedProjectsNames);


        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
