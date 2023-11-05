package org.academia.persistence.jpa.associations.one2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class One2One {

    private EntityManagerFactory emf;

    private One2One() {
        this.emf = Persistence.createEntityManagerFactory("oneToOne");
    }

    public static void main(final String[] args) throws Exception {

        One2One one2One = new One2One();

        // create a new car
        Car car = new Car();
        car.setModel("Sorento");
        car.setMake("Kia");

        // create a new boat
        Owner owner = new Owner();
        owner.setName("Rui");

        // establish bidirectional relations
        car.setOwner(owner);
        owner.setCar(car);

        // persist both
        Owner savedOwner = (Owner) one2One.save(owner);
        System.out.println("Car persisted with ID: " + savedOwner.getId());
        System.out.println("Owner persisted with ID: " + savedOwner.getCar().getId());

        // fetch both
        Owner fetchedOwner = (Owner) one2One.fetch(savedOwner.getId(), Owner.class);
        System.out.println("Fetched owner: " + fetchedOwner);
        System.out.println("Fetched car: " + fetchedOwner.getCar());

        one2One.close();

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
