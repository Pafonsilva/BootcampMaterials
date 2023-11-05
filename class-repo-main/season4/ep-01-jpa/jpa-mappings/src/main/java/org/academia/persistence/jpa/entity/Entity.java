package org.academia.persistence.jpa.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Entity {

    private EntityManagerFactory emf;


    public Entity() {
        this.emf = Persistence.createEntityManagerFactory("entity");
    }

    public static void main(String[] args) {

        Entity entity = new Entity();

        User user = new User();
        user.setName("Jorge Antunes");
        user.setEmail("jorge@gmail.com");
        user.setPassword("secret");

        // persist user
        User savedUser = entity.save(user);
        System.out.println("User persisted with ID: " + savedUser.getId());

        // fetch user
        User fetchedUser = entity.fetch(savedUser.getId());
        System.out.println("Fetched user: " + fetchedUser);

        entity.close();
    }

    private User save(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return user;
    }

    private User fetch(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(User.class, id);

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
