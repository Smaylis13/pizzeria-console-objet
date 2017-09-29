package fr.pizzeria.console;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.naming.directory.ModificationItem;
import javax.sound.midi.Soundbank;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {
	public static final Scanner sScanner = new Scanner(System.in);
	
	public static void main(String...args) throws SavePizzaException {

		//List<Pizza> lPizzas = new ArrayList<Pizza>();
		//initListPizza(lPizzas);
		OptionMenu optionMenu;
		PizzaDao pizzaDao = new PizzaDao();

		boolean exit = true //erreur test ! 
		ListerPizzasOptionMenu listerPizzasOptionMenu = new ListerPizzasOptionMenu(pizzaDao);
		AjouterPizzaOptionMenu add = new AjouterPizzaOptionMenu(pizzaDao);
		ModifierPizzaOptionMenu upd = new ModifierPizzaOptionMenu(pizzaDao);
		SupprimerPizzaOptionMenu del = new SupprimerPizzaOptionMenu(pizzaDao);
		
		sScanner.useLocale(Locale.US);// Pour pouvoir utiliser le point et la virgule aussi
		try{
			while(exit){
				afficherMenu();
				switch (sScanner.nextInt()) {
					case 1:
						System.out.println(listerPizzasOptionMenu.getLibelle());
						listerPizzasOptionMenu.execute();
						break;
					case 2:
							System.out.println(add.getLibelle());
							add.execute();
						break;
					case 3:
						System.out.println(upd.getLibelle());
						upd.execute();;
						break;
					case 4:
						System.out.println(del.getLibelle());
						del.execute();
						break;
						
					default:
						System.out.println("Merci de votre visite :)  Aurevoir \u2639.");
						exit = false;
						break;
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		sScanner.close();
	}

	/*private static void initListPizza(List<Pizza> pPizzas){
		pPizzas.add(new Pizza("PEP", "Pépéroni", 12.5));
		pPizzas.add(new Pizza( "MAR", "Margherita" ,14.00));
		pPizzas.add(new Pizza( "REIN", "La Reine", 11.50));
		pPizzas.add(new Pizza( "FRO", "La 4 fromages", 12.00));
		pPizzas.add(new Pizza( "CAN", "La cannibale", 12.50));
		pPizzas.add(new Pizza( "SAV" ,"La savoyarde" ,13.00));
		pPizzas.add(new Pizza( "ORI", "L’orientale" ,13.50));
		pPizzas.add(new Pizza( "IND", "L’indienne", 14.00));
	}*/
	public static void afficherMenu(){
		 
		System.out.println("\n***** Pizzeria Administration *****" +
		"\n\t 1. Lister les pizzas" +
		"\n\t 2. Ajouter une nouvelle pizza" +
		"\n\t 3. Mettre à jour une pizza" +
		"\n\t 4. Supprimer une pizza" + 
		"\n\t 99. Sortir");
	}

	
}
