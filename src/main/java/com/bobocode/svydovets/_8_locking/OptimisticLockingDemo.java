package com.bobocode.svydovets._8_locking;

import com.bobocode.svydovets.bibernate.config.BibernateConfiguration;
import com.bobocode.svydovets.bibernate.session.Session;
import com.bobocode.svydovets.bibernate.session.SessionFactory;
import com.bobocode.svydovets.entity.Product;
import lombok.extern.slf4j.Slf4j;

/**
 * This demo shows optimistic locking with Bibernate using the {@link com.bobocode.svydovets.bibernate.annotation.Version} annotation.
 */
@Slf4j
public class OptimisticLockingDemo {
    private static final long PRODUCT_ID = 1L;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) throws InterruptedException {
        initSessionFactory();

        // Insert a new Product with auto-resolved initial value of version field
        try (Session session = sessionFactory.openSession()) {
            Product product = new Product();
            product.setId(PRODUCT_ID);
            product.setQuantity(5);
            session.save(product);
        }

        // Update Product with auto-incremented version field
        try (Session session = sessionFactory.openSession()) {
            Product product = session.find(Product.class, PRODUCT_ID);
            product.setQuantity(10);
        }

        // Remove Product with version field
        try (Session session = sessionFactory.openSession()) {
            Product product = session.find(Product.class, PRODUCT_ID);
            session.delete(product);
        }
    }

    private static void initSessionFactory() {
        var configuration = new BibernateConfiguration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
    }
}
