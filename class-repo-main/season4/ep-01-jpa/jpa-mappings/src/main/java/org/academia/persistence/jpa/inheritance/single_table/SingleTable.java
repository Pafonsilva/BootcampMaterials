package org.academia.persistence.jpa.inheritance.single_table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class SingleTable {

    private EntityManagerFactory emf;

    private SingleTable() {
        this.emf = Persistence.createEntityManagerFactory("singleTable");
    }

    public static void main(final String[] args) throws Exception {

        SingleTable singleTable = new SingleTable();

        // create a new car
        Car car = new Car();
        car.setMaxSpeed(200);
        car.setGears(6);

        // create a new boat
        Boat boat = new Boat();
        boat.setMaxSpeed(100);
        boat.setEngines(4);

        // persist car
        Car savedCar = (Car) singleTable.save(car);
        System.out.println("Car persisted with ID: " + savedCar.getId());

        // persist boat
        Boat savedBoat = (Boat) singleTable.save(boat);
        System.out.println("Boat persisted with ID: " + savedBoat.getId());

        // fetch car
        Car fetchedCar = (Car) singleTable.fetch(savedCar.getId(), Car.class);
        System.out.println("Fetched car: " + fetchedCar);

        // fetch boat
        Boat fetchedBoat = (Boat) singleTable.fetch(savedBoat.getId(), Boat.class);
        System.out.println("Fetched boat: " + fetchedBoat);

        singleTable.close();
    }

    private Object save(Object entity) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return entity;
    }

    private Object fetch(Integer id, Class type) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(type, id);

        } finally {

            if (em != null) {
                em.close();
            }

        }
    }

    private void close() {
        emf.close();
    }
}
