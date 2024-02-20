import entities.shampoo.BasicLabel;
import entities.shampoo.BasicShampoo;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;
import utils.Utils;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        BasicLabel label = new BasicLabel("red");
        BasicShampoo shampoo = new BasicShampoo("whatever", label);

        entityManager.persist(label);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
