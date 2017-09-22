package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;

public class ModifierPizzaOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier une Pizza :";
	}
	
	public void execute() {
		// TODO Auto-generated method stub
		PizzaDao lPizzaDao = new PizzaDao();
		System.out.println("Veuillez choisir la pizza à modifier :");
		List<Pizza> listPizza = lPizzaDao.findAllPizzas();
		afficherListPizzas(listPizza);
		//System.out.println("(99 pour abandonnér)");
		String code = PizzeriaAdminConsoleApp.sScanner.next();
		//if(!code.equals("99")){
			for (Pizza p : listPizza){
				if(p.getmCode().equals(code.toUpperCase())){
					System.out.println("Veuillez saisir le nouveau code :");
					p.setmCode(PizzeriaAdminConsoleApp.sScanner.next());
					System.out.println("Veuillez saisir le nouveau nom :");
					p.setmNom(PizzeriaAdminConsoleApp.sScanner.next());
					System.out.println("Veuillez saisir le nouveau prix:");
					p.setmPrix(PizzeriaAdminConsoleApp.sScanner.nextDouble());
					
			//	}
			}
		}
	}



	
}
