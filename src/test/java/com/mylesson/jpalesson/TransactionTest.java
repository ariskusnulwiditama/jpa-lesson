package com.mylesson.jpalesson;

import com.mylesson.jpalesson.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class TransactionTest {


    @Test
    void transaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Assertions.assertNotNull(entityTransaction);

        try {
            entityTransaction.begin();

//            manipulasi database
            entityTransaction.commit();
        }catch (Throwable throwable) {
            entityTransaction.rollback();
        }
    }
}
