import entities.Bike;
import entities.Car;
import utils.Utils;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        Bike bike = new Bike();
        Car car = new Car();

        entityManager.persist(bike);
        entityManager.persist(car);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
