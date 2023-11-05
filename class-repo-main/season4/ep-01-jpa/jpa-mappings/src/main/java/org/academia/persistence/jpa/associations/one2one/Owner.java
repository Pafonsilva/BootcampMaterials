package org.academia.persistence.jpa.associations.one2one;

import javax.persistence.*;

@Entity
@Table(name = "owner_one2one")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "owner", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Car car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
