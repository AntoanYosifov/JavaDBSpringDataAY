import entities.Bike;
import entities.Car;
import entities.Truck;
import utils.Utils;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.getEntityManager();

        entityManager.getTransaction().begin();

        Bike bike = new Bike(21);
        Car car = new Car(4);
        Truck truck = new Truck(25000, 40000);

        entityManager.persist(bike);
        entityManager.persist(car);
        entityManager.persist(truck);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
