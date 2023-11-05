package org.academia.persistence.jpa.associations.many2many;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Many2Many {

    private EntityManagerFactory emf;

    public Many2Many() {
        this.emf = Persistence.createEntityManagerFactory("manyToMany");
    }

    public static void main(final String[] args) throws Exception {

        Many2Many many2Many = new Many2Many();

        // create new security groups
        SecurityGroup admin = new SecurityGroup();
        admin.setName("admin");
        SecurityGroup user = new SecurityGroup();
        user.setName("user");

        // create users
        User user1 = new User();
        user1.setUsername("Rui");
        user1.setPassword("secret");
        user1.addSecurityGroup(admin);
        user1.addSecurityGroup(user);
        User user2 = new User();
        user2.setUsername("Catarina");
        user2.setPassword("123");

        // persist user1
        User savedUser1 = many2Many.save(user1);

        // it's necessary to attribute the value to the sgroup again to the local
        // variable because the original object does not have an id and we want
        // avoid 2 sgroups with the same name ont the db
        user = savedUser1.getSecurityGroup(user.getName());
        admin = savedUser1.getSecurityGroup(admin.getName());

        user2.addSecurityGroup(user);
        User savedUser2 = many2Many.save(user2);
        System.out.println("User1 persisted with ID: " + savedUser1.getId());
        System.out.println("User2 persisted with ID: " + savedUser2.getId());

        // fetch user1 and its security groups
        User fetchedUser = many2Many.fetch(savedUser1.getId());
        System.out.println("Fetched user: " + fetchedUser);

        // fetch user2 and its security groups
        fetchedUser = many2Many.fetch(savedUser2.getId());
        System.out.println("Fetched user: " + fetchedUser);

        many2Many.close();

    }

    private User save(User entity) {

        EntityManager em = emf.createEntityManager();

        User savedUser = null;

        try {

            em.getTransaction().begin();

            // we are merging and not saving, as some of the security groups of
            // one user having already been previously persisted with another user and
            // already contain their IDs.
            //
            // Persist can only be used on fresh new entities, and as we are dealing with
            // previously persisted ones, merge should be used instead
            savedUser = em.merge(entity);

            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return savedUser;
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
