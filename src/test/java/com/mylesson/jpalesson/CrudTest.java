package com.mylesson.jpalesson;

import com.mylesson.jpalesson.entity.Customer;
import com.mylesson.jpalesson.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrudTest {

    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setup() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void insert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1lop");
        customer.setName("jhones");
        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void find() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1lop");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1lop", customer.getId());
        Assertions.assertEquals("jhones", customer.getName());

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void udpate() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1lop");
        customer.setName("michael sweet");

        entityManager.merge(customer);
        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void delete() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1lop");
        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}













