package org.academia.persistence.jpa.inheritance.joined_table;

import javax.persistence.*;

@Entity(name = "VehicleJoinedTable")
@Table(name = "vehicle_joined_table")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
