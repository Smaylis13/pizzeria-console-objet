package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.persistence.DbManager;

/**
 * 
 * @author IG
 *
 *
 */
public class PizzaDao implements IPizzaDao {

	private List<Pizza> mListPizza;
	private Connection connection;

	private static ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDao.class);

	private void openConnection() {
		try {
			connection = DriverManager.getConnection(bundle.getString("db.url"), "root", "");
		} catch (SQLException e) {
			throw new RuntimeException("Impossible de se connecter à la base de donnée");
		} finally {

		}
	}

	private void closeConnection() {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PizzaDao() {
		mListPizza = new ArrayList<>();
	}

	/**
	 * findAllPizzas retourne la liste des pizzas dans la base de donnée
	 * 
	 * @return List<Pizza>
	 */
	@Override
	public List<Pizza> findAllPizzas() {
		mListPizza.clear();
		EntityManager em = new DbManager().getEntityManagerFactory().createEntityManager();

		mListPizza = em.createQuery("FROM Pizza p").getResultList();
		if (mListPizza.isEmpty()) {
			LOG.info("Aucune pizza dans la base");
		}

		em.close();
		return mListPizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {

		EntityManager em = new DbManager().getEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();

		em.close();
		return mListPizza.add(pizza);
	}

	/**
	 * Mise à d'une Pizza dans la base de donnée en fonction de son CODE
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		EntityManager em = new DbManager().getEntityManagerFactory().createEntityManager();
		if (mListPizza.isEmpty()) {
			LOG.info("Liste pizza vide");
			return true;
		}
		// Pizza pizzaBase = mListPizza.stream().filter(p ->
		// p.getmCode().equals(codePizza)).collect(Collectors.toList()).get(0);

		em.getTransaction().begin();
		em.merge(pizza);

		em.getTransaction().commit();

		em.close();

		return false;
	}

	@Override
	public boolean deletePizza(Pizza pizza) {

		/*Pizza pizza = mListPizza.stream().filter(p -> p.getmCode().equals(codePizza)).collect(Collectors.toList())
				.get(0);*/
		if (pizza != null) {
			EntityManager em = new DbManager().getEntityManagerFactory().createEntityManager();

			em.getTransaction().begin();

			em.remove(em.contains(pizza) ? pizza : em.merge(pizza));
			
			em.getTransaction().commit();
			
			LOG.info("La pizza [" + pizza + "] a bien été supprimée");
		
			em.close();
			return true;
		}
		/*
		 * for (int i = 0; i < mListPizza.size(); i++) { Pizza lPizza =
		 * mListPizza.get(i); if (lPizza.compCode(codePizza)) {
		 * mListPizza.remove(lPizza); // #DB if (deletePizzaDB(lPizza)) {
		 * LOG.info("La pizza [" + lPizza + "] a bien été supprimée"); } // #fin
		 * DB return true; } }
		 */
		return false;
	}

	private boolean deletePizzaDB(Pizza p) {
		openConnection();

		Statement statement = null;
		try {
			statement = connection.createStatement();
			String query = "DELETE FROM PIZZA WHERE PIZZA.ID = " + p.getId();

			return statement.execute(query);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection();
		}
		return false;

	}

}
