package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;

public class AjouterPizzaOptionMenu extends OptionMenu {


	public AjouterPizzaOptionMenu(IPizzaDao pDao){
		mDao = pDao;
	}
	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Ajouter une Pizza ! ";
	}

	@Override
	public void execute() throws SavePizzaException{
		// TODO Auto-generated method stub
		Pizza newPizza = new Pizza();
		System.out.print("Veuillez saisir un CODE : ");
		String code = PizzeriaAdminConsoleApp.sScanner.next();
		if(code.isEmpty())
			throw new SavePizzaException ("Le code ne doit pas être vide."); 
		newPizza.setmCode(code);
		System.out.print("Veuillez saisir un NOM : ");
		String nom = PizzeriaAdminConsoleApp.sScanner.next();
		if(nom.isEmpty())
			throw new SavePizzaException ("Le code ne doit pas être vide."); 
		newPizza.setmNom(nom);
		System.out.print("Veuillez saisir un PRIX : ");
		double prix = PizzeriaAdminConsoleApp.sScanner.nextDouble();
		if(prix == 0)
			throw new SavePizzaException ("Veuillez entrer un prix.");
		newPizza.setmPrix(prix);
		System.out.println("Veuillez choisir une catégorie : ");
		int i = 0;
		for ( Object o : CategoriePizza.values()){
			System.out.println(i+" -> " + o);
			i++;
		}
		int cat = PizzeriaAdminConsoleApp.sScanner.nextInt();
		
		newPizza.setmCategorie(CategoriePizza.valueOf(cat));
		
		System.out.println(newPizza);
		//PizzaDao pizzaDao = new PizzaDao();
		if ( ! mDao.saveNewPizza(newPizza))
			throw new SavePizzaException ("Votre pizza n'a pas été ajouté :(");
		afficherListPizzas(mDao.findAllPizzas());
		
	}


}
