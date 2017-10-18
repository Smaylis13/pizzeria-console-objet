package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.console.Pizza;

/**
 * 
 * @author ISMAIL GACHA
 *
 */
public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza, Pizza pizza);
	boolean deletePizza(Pizza pizza);
}
