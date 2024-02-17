package solutions;

import entities.Town;
import utils.Utils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ChangeCasing_02 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        TypedQuery<Town> selectFromTown = entityManager.createQuery("SELECT t FROM Town t", Town.class);
        List<Town> resultList = selectFromTown.getResultList();

        for (Town town : resultList) {
            String name = town.getName();

            if(name.length() <= 5){
                String upperCaseName = name.toUpperCase();

                town.setName(upperCaseName);

                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
