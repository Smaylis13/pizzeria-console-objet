package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;

@Controller
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	 @Autowired
	private Scanner scanner;


	@Autowired
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
		String code = this.scanner.next();
		if(code.isEmpty())
			throw new SavePizzaException ("Le code ne doit pas être vide."); 
		newPizza.setmCode(code);
		System.out.print("Veuillez saisir un NOM : ");
		String nom = this.scanner.next();
		if(nom.isEmpty())
			throw new SavePizzaException ("Le code ne doit pas être vide."); 
		newPizza.setmNom(nom);
		System.out.print("Veuillez saisir un PRIX : ");
		double prix = this.scanner.nextDouble();
		if(prix == 0)
			throw new SavePizzaException ("Veuillez entrer un prix.");
		newPizza.setmPrix(prix);
		System.out.println("Veuillez choisir une catégorie : ");
		int i = 1;
		for ( Object o : CategoriePizza.values()){
			System.out.println(i+" -> " + o);
			i++;
		}
		int cat = this.scanner.nextInt();
		
		newPizza.setmCategorie(CategoriePizza.valueOf(cat));
		
		System.out.println(newPizza);

		if ( ! mDao.saveNewPizza(newPizza))
			throw new SavePizzaException ("Votre pizza n'a pas été ajouté :(");
		afficherListPizzas(mDao.findAllPizzas());
		
	}


}
