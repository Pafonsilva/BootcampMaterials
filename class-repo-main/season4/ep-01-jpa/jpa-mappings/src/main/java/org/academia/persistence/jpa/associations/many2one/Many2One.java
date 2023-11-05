package org.academia.persistence.jpa.associations.many2one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Many2One {

    private EntityManagerFactory emf;

    public Many2One() {
        this.emf = Persistence.createEntityManagerFactory("manyToOne");
    }

    public static void main(final String[] args) throws Exception {

        Many2One many2One = new Many2One();

        // create a new Category
        Category surfBoard = new Category();
        surfBoard.setName("Surfboards");

        Category wetSuits = new Category();
        wetSuits.setName("WetSuits");

        // create new products and establish relations
        Product product = new Product();
        product.setName("Shortboard");
        surfBoard.addProduct(product);
        product = new Product();
        product.setName("Longboard");
        surfBoard.addProduct(product);

        product = new Product();
        product.setName("Neoprene");
        wetSuits.addProduct(product);

        // persist everything
        surfBoard = many2One.save(surfBoard);
        System.out.println("SurfBoard persisted with ID: " + surfBoard.getId());
        wetSuits = many2One.save(wetSuits);
        System.out.println("WetSuits persisted with ID: " + wetSuits.getId());

        // fetch category
        Category fetchedCategory = many2One.fetchCategory(surfBoard);
        System.out.println("Fetched category: " + fetchedCategory);

        // fetch and print products
        // (products are lazy loaded, so not available from fetchedCategory anymore)
        for (Product savedProduct : surfBoard.getProducts()) {

            Product fetchedProduct = many2One.fetchProduct(savedProduct);

            System.out.println("Fetched product: " + fetchedProduct);
        }

        many2One.close();
    }

    private Category save(Category entity) {

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

    private Category fetchCategory(Category category) {

        return (Category) fetch(category.getId(), Category.class);
    }

    private Product fetchProduct(Product product) {

        return (Product) fetch(product.getId(), Product.class);
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
