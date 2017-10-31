package fr.pizzeria.console;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import ch.qos.logback.core.Context;
import fr.pizzeria.config.ServiceConfig;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import fr.pizzeria.persistence.DbManager;

@Controller
public class PizzeriaAdminConsoleApp {

	@Autowired
	private Scanner sScanner;
	
	@Autowired
	private PizzaDao pizzaDao;

	@Autowired
	public Logger LOG;

	private Map<Integer, OptionMenu> options = new HashMap<>();
	
	@Autowired
	AnnotationConfigApplicationContext context;

	@PostConstruct
	public void init() {
		AtomicInteger incr = new AtomicInteger();
		context.getBeansOfType(OptionMenu.class)
		.forEach((idSpring, option) -> {
			options.put(incr.incrementAndGet(), option);
		});
	}

	/**
	 * Démmarage de l'application
	 */
	public void demarrer() {
		sScanner.useLocale(Locale.US);
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
			LOG.error(e.getMessage(), e);
		} finally {
			new DbManager().close();
			LOG.info("DB Manger closed");
			sScanner.close();
		}
	}

	private void afficherMenu() {

		LOG.info("***** Pizzeria Administration *****");
		options.forEach((cle, option) -> {
			LOG.info(cle + ". " + option.getLibelle());
			
		});

		
	}

}
