package solutions;

import entities.Project;
import utils.Utils;

import javax.persistence.EntityManager;

import java.util.List;

public class FindLatest10Projects_09 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        List<Project> projectList = entityManager.createQuery("FROM Project p" +
                        " ORDER BY p.startDate DESC, p.name", Project.class)
                .setMaxResults(10)
                .getResultList();

        projectList.forEach(p -> System.out.println(p.toString()));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
