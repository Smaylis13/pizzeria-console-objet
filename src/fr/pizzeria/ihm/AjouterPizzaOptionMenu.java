package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;

public class AjouterPizzaOptionMenu extends OptionMenu {


	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une Pizza ! ";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir un CODE");
		newPizza.setmCode(PizzeriaAdminConsoleApp.sScanner.next());
		System.out.println("Veuillez saisir un NOM");
		newPizza.setmNom(PizzeriaAdminConsoleApp.sScanner.next());
		System.out.println("Veuillez saisir un PRIX");
		newPizza.setmPrix(PizzeriaAdminConsoleApp.sScanner.nextDouble());
		PizzaDao pizzaDao = new PizzaDao();
		pizzaDao.saveNewPizza(newPizza);
		afficherListPizzas(pizzaDao.findAllPizzas());

	}


}
