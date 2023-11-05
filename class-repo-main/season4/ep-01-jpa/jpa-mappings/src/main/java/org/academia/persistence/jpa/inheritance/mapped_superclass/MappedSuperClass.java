package org.academia.persistence.jpa.inheritance.mapped_superclass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class MappedSuperClass {

    private EntityManagerFactory emf;

    private MappedSuperClass() {
        this.emf = Persistence.createEntityManagerFactory("mappedSuperClass");
    }

    public static void main(final String[] args) throws Exception {

        MappedSuperClass mappedSuperClass = new MappedSuperClass();

        // create a new customer
        Customer customer = new Customer();
        customer.setName("Jorge");

        // create a new Account
        Account account = new Account();
        account.setBalance(100);

        // persist customer
        Customer savedCustomer = (Customer) mappedSuperClass.save(customer);
        System.out.println("Customer persisted with ID: " + savedCustomer.getId());

        // persist account
        Account savedAccount = (Account) mappedSuperClass.save(account);
        System.out.println("Account persisted with ID: " + savedAccount.getId());

        // fetch customer
        Customer fetchedCustomer = (Customer) mappedSuperClass.fetch(savedCustomer.getId(), Customer.class);
        System.out.println("Fetched customer: " + fetchedCustomer);

        // fetch account
        Account fetchedAccount = (Account) mappedSuperClass.fetch(savedAccount.getId(), Account.class);
        System.out.println("Fetched account: " + fetchedAccount);

        mappedSuperClass.close();

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
