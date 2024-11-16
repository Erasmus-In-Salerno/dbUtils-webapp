package com.dbutils_webapp;

import com.dbutils_webapp.model.Entity;
import com.dbutils_webapp.repository.EntityRepository;
import com.dbutils_webapp.repository.impl.EntityRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbUtilsWebAppApplication {
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DbUtilsWebAppApplication.class, args);

		EntityRepository<Entity> entityRepository = context.getBean(EntityRepositoryImpl.class);

		Entity neueEntitaet = new Entity();
		neueEntitaet.setName("neue");
		entityRepository.saveEntity(neueEntitaet);
	}

}
