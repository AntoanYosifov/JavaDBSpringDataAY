package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car extends Vehicle {
    private static final String CAR_TYPE = "Car";
    private int doorsCount;

    public Car(int doorsCount) {
        super(CAR_TYPE, 25000);
        this.doorsCount = doorsCount;
    }

    public Car() {

    }
}
