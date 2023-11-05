package org.academia.persistence.jpa.inheritance.mapped_superclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractModel {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
