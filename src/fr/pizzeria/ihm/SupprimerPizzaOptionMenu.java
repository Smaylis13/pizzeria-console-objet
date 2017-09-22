package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.PizzaDao;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		PizzaDao pizzaDao = new PizzaDao();
		List<Pizza> lListPizza = pizzaDao.findAllPizzas();
		System.out.println("Veuillez choisir la pizza à supprimer :");
		afficherListPizzas(lListPizza);
		System.out.println("(99 pour abandonnér)");
		String code = PizzeriaAdminConsoleApp.sScanner.next();
		if(!code.equals("99")){
			for (int i = 0 ; i < lListPizza.size() ; i++){
				Pizza p = lListPizza.get(i);
				if(p.getmCode().equals(code.toUpperCase())){
					if(lListPizza.remove(i) != null){
						System.out.println("la pizza "+p+"a bien été supprimer" );
					}
				}
			}
		}
	}







}
