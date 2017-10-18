package fr.pizzeria.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.PizzaDao;

public class DbManager {
	private static final Logger LOG = LoggerFactory.getLogger(DbManager.class);
	private static EntityManagerFactory entityManagerFactory=null;

	public void open() {
		if (entityManagerFactory == null){
			entityManagerFactory = Persistence.createEntityManagerFactory("pizzaria");
			LOG.info("entityManagerFactory Opened"+entityManagerFactory.toString());
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory == null)
			open();
		return entityManagerFactory;
	}

	public void close() {
		if (entityManagerFactory != null){
			entityManagerFactory.close();
			LOG.info("entityManagerFactory closed");
		}
	}

}
