package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu{

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Liste des Pizza";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		PizzaDao pizzaDao = new PizzaDao();
		for ( Pizza p : pizzaDao.findAllPizzas()){
			System.out.println(p.toString());
		}
		
	}









}
