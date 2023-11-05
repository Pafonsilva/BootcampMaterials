package org.academia.persistence.jpa.inheritance.table_per_class;

import javax.persistence.*;

@Entity(name = "VehicleTablePerClass")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private Integer maxSpeed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
