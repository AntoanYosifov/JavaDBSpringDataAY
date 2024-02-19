package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike extends Vehicle{

    private int gearsCount;
    private static final String BIKE_TYPE = "Bike";

    public Bike(int gearsCount) {
        super(BIKE_TYPE, 250);
        this.gearsCount = gearsCount;
    }

    public Bike() {

    }
}
