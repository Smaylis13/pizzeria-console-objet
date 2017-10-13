package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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

	public static void main(String... args) throws SavePizzaException {

		OptionMenu optionMenu;
		PizzaDao pizzaDao = new PizzaDao();

		sScanner.useLocale(Locale.US);// Pour pouvoir utiliser le point et la
										// virgule aussi
		Map<Integer, OptionMenu> options = new HashMap<>();
		options.put(1, new ListerPizzasOptionMenu(pizzaDao));
		options.put(2, new AjouterPizzaOptionMenu(pizzaDao));
		options.put(3, new ModifierPizzaOptionMenu(pizzaDao));
		options.put(4, new SupprimerPizzaOptionMenu(pizzaDao));
		try {
			while (true) {
				afficherMenu();
				OptionMenu choix = options.get(sScanner.nextInt());
				if (choix == null) {
					System.out.println("Merci de votre visite :)  Aurevoir \u2639.");
					return;
				}
				System.out.println(choix.getLibelle());
				choix.execute();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sScanner.close();
		}
	}

	/*
	 * private static void initListPizza(List<Pizza> pPizzas){ pPizzas.add(new
	 * Pizza("PEP", "Pépéroni", 12.5)); pPizzas.add(new Pizza( "MAR",
	 * "Margherita" ,14.00)); pPizzas.add(new Pizza( "REIN", "La Reine",
	 * 11.50)); pPizzas.add(new Pizza( "FRO", "La 4 fromages", 12.00));
	 * pPizzas.add(new Pizza( "CAN", "La cannibale", 12.50)); pPizzas.add(new
	 * Pizza( "SAV" ,"La savoyarde" ,13.00)); pPizzas.add(new Pizza( "ORI",
	 * "L’orientale" ,13.50)); pPizzas.add(new Pizza( "IND", "L’indienne",
	 * 14.00)); }
	 */
	public static void afficherMenu() {

		System.out.println("\n***** Pizzeria Administration *****" + "\n\t 1. Lister les pizzas"
				+ "\n\t 2. Ajouter une nouvelle pizza" + "\n\t 3. Mettre à jour une pizza"
				+ "\n\t 4. Supprimer une pizza" + "\n\t 99. Sortir");
	}

}
