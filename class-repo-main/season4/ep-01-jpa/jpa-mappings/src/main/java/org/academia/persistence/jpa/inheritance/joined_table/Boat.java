package org.academia.persistence.jpa.inheritance.joined_table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "BoatJoinedTable")
@Table(name = "boat_joined_table")
public class Boat extends Vehicle {

    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "engines=" + engines +
                "} " + super.toString();
    }
}
