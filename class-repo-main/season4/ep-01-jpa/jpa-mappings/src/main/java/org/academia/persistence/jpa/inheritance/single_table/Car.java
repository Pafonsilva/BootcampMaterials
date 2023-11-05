package org.academia.persistence.jpa.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity (name="CarSingleTable")
@DiscriminatorValue("car")
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
