package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;

@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	 @Autowired
		private Scanner scanner;

	@Override
	public String getLibelle() {
		return "Supprimer";
	}

	@Autowired
	public SupprimerPizzaOptionMenu(IPizzaDao pDao) {
		mDao = pDao;
	}

	@Override
	public void execute() {
		List<Pizza> lListPizza = mDao.findAllPizzas();
		System.out.println("Veuillez choisir la pizza à supprimer :");
		afficherListPizzas(lListPizza);
		System.out.println("(99 pour abandonnér)");
		String code = this.scanner.next();
		if (!code.equals("99")) {
			for (int i = 0; i < lListPizza.size(); i++) {
				Pizza p = lListPizza.get(i);
				if (p.getmCode().equals(code.toUpperCase())) {
					System.out.println("la pizza " + p + " va être supprimer (O/N)");
					this.scanner.next();
					if (mDao.deletePizza(p) && lListPizza.remove(i) != null) {
						System.out.println("la pizza " + p + " a bien été supprimer");
					}
				}
			}
		}
	}

}
