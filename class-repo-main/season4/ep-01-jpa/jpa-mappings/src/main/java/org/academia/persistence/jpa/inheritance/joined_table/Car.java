package org.academia.persistence.jpa.inheritance.joined_table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "CarJoinedTable")
@Table(name = "car_joined_table")
public class Car extends Vehicle {

    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }

    @Override
    public String toString() {
        return "Car{" +
                "gears=" + gears +
                "} " + super.toString();
    }
}
