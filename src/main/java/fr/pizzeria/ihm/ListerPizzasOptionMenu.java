package fr.pizzeria.ihm;

import fr.pizzeria.console.Pizza;

import fr.pizzeria.dao.IPizzaDao;

public class ListerPizzasOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Liste des Pizza";
	}

	public ListerPizzasOptionMenu(IPizzaDao pDao) {
		mDao = pDao;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		// PizzaDao pizzaDao = new PizzaDao();
		for (Pizza p : mDao.findAllPizzas()) {
			System.out.println(p.toString());
		}

	}

}
