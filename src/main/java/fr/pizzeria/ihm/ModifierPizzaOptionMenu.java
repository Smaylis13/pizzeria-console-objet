package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.persistence.DbManager;

@Controller
public class ModifierPizzaOptionMenu extends OptionMenu {

	private static final Logger LOG = LoggerFactory.getLogger(ModifierPizzaOptionMenu.class);
	
	 @Autowired
	private Scanner scanner;

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Modifier une Pizza ";
	}
	@Autowired
	public ModifierPizzaOptionMenu(IPizzaDao pDao){
		mDao = pDao;
	}
	public void execute() {
		// TODO Auto-generated method stub
		LOG.info("Veuillez choisir la pizza à modifier (Tapper le CODE) :");
		List<Pizza> listPizza = mDao.findAllPizzas();
		afficherListPizzas(listPizza);
		//System.out.println("(99 pour abandonnér)");
		String code = this.scanner.next();
		//if(!code.equals("99")){
			for (Pizza p : listPizza){
				if(p.getmCode().equals(code.toUpperCase())){
					LOG.info("Veuillez saisir le nouveau code :");
					p.setmCode(this.scanner.next());
					LOG.info("Veuillez saisir le nouveau nom :");
					p.setmNom(this.scanner.next());
					LOG.info("Veuillez saisir le nouveau prix:");
					p.setmPrix(this.scanner.nextDouble());
					
					mDao.updatePizza(code, p);
					
			//	}
			}
		}
			
	}



	
}
