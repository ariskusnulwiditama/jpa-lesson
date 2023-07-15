package com.mylesson.jpalesson;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mylesson.jpalesson.util.JpaUtil;

import jakarta.persistence.EntityManagerFactory;

@SpringBootTest
public class EntityManagerFactoryTest {
	
	@Test
	void create() {
		EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
		assertNotNull(entityManagerFactory);
	}
}
