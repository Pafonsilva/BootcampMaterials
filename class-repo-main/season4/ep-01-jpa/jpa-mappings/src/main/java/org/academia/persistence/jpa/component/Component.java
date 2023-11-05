package org.academia.persistence.jpa.component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Component {

    private EntityManagerFactory emf;

    private Component() {
        this.emf = Persistence.createEntityManagerFactory("component");
    }

    public static void main(final String[] args) throws Exception {

        Component component = new Component();

        // create a new student
        Address address = new Address();
        address.setCity("Fundão");
        address.setStreet("Rua de Cima");
        address.setZipcode("6666");
        Student student = new Student();
        student.setName("Jorge");
        student.setAddress(address);

        // persist student
        Student savedStudent = component.save(student);
        System.out.println("Student persisted with ID: " + savedStudent.getId());

        // fetch customer
        Student fetchedStudent = component.fetch(savedStudent.getId());
        System.out.println("Fetched student: " + fetchedStudent);

        component.close();

    }

    private Student save(Student student) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }

        return student;
    }

    private Student fetch(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(Student.class, id);

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
