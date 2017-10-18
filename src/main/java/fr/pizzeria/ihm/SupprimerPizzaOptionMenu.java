package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		return null;
	}
	public SupprimerPizzaOptionMenu(IPizzaDao pDao){
		mDao = pDao;
	}
	@Override
	public void execute() {
		List<Pizza> lListPizza = mDao.findAllPizzas();
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
