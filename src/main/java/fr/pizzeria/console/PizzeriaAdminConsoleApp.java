package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.*;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import fr.pizzeria.persistence.DbManager;

public class PizzeriaAdminConsoleApp {
	public static final Scanner sScanner = new Scanner(System.in);
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String... args) {

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
					LOG.info("Merci de votre visite :)  Aurevoir \u2639.");
					return;
				}
				LOG.info(choix.getLibelle());
				choix.execute();

			}
		} catch (Exception e) {
			LOG.error(e.getMessage(),e);
		} finally {
			new DbManager().close();
			LOG.info("DB Manger closed");
			sScanner.close();
		}
	}


	private static void afficherMenu() {

		LOG.info("\n***** Pizzeria Administration *****" + "\n\t 1. Lister les pizzas"
				+ "\n\t 2. Ajouter une nouvelle pizza" + "\n\t 3. Mettre à jour une pizza"
				+ "\n\t 4. Supprimer une pizza" + "\n\t 99. Sortir");
	}

}
