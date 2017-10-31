package fr.pizzeria.console;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.config.ServiceConfig;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import fr.pizzeria.persistence.DbManager;

public class ConsoleApp {

	public static void main(String... args) {

		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);
		
		context.getBean(PizzeriaAdminConsoleApp.class).demarrer();

		
	}


}
