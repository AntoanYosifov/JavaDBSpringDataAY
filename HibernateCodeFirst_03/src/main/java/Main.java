import entities.shampoo.BasicIngredient;
import entities.shampoo.BasicLabel;
import entities.shampoo.BasicShampoo;
import entities.shampoo.ProductionBatch;
import entities.vehicle.Bike;
import entities.vehicle.Car;
import entities.vehicle.Truck;
import utils.Utils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        ProductionBatch batch = new ProductionBatch(LocalDate.now());
        BasicLabel label = new BasicLabel("red");
        BasicShampoo shampoo = new BasicShampoo("whatever", label, batch);

        BasicIngredient ingredient = new BasicIngredient(100, "B12");
        BasicIngredient ingredient2 = new BasicIngredient(50, "B11");

        shampoo.addIngredient(ingredient);
        shampoo.addIngredient(ingredient2);

        entityManager.persist(ingredient);
        entityManager.persist(ingredient2);

        entityManager.persist(batch);
        entityManager.persist(label);
        entityManager.persist(shampoo);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
