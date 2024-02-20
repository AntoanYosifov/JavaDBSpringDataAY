import entities.shampoo.BasicLabel;
import entities.shampoo.BasicShampoo;
import entities.shampoo.ProductionBatch;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;
import utils.Utils;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("red");
        BasicShampoo shampoo = new BasicShampoo("whatever", label, batch);

        entityManager.persist(batch);
        entityManager.persist(label);
        entityManager.persist(shampoo);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
