package solutions;

import entities.Address;
import entities.Employee;
import entities.Town;
import utils.Utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns_13 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();
        entityManager.getTransaction().begin();

        Scanner scanner = new Scanner(System.in);
        String townName = scanner.nextLine();

        Town townEntity = entityManager.createQuery("FROM Town t" +
                        " WHERE t.name = :townName", Town.class)
                .setParameter("townName", townName)
                .getSingleResult();

        List<Address> addressesByTown = entityManager.createQuery("FROM Address a " +
                        " WHERE a.town =  :town", Address.class)
                .setParameter("town", townEntity)
                .getResultList();

        List<Employee> employeeList = entityManager.createQuery("FROM Employee e ", Employee.class)
                .getResultList();

        for (Employee employee : employeeList) {

            if (addressesByTown.contains(employee.getAddress())) {
                employee.setAddress(null);
                entityManager.persist(employee);
            }
        }

        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        for (Address address : addressesByTown) {
            entityManager.remove(address);
        }

        entityManager.remove(townEntity);

        entityManager.getTransaction().commit();

        System.out.printf("%d address in %s deleted\n", addressesByTown.size(), townName);

        entityManager.close();
    }
}
