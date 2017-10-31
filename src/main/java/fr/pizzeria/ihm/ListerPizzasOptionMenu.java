package fr.pizzeria.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.console.Pizza;

import fr.pizzeria.dao.IPizzaDao;
@Controller
public class ListerPizzasOptionMenu extends OptionMenu {

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return "Liste des Pizza";
	}

	@Autowired
	public ListerPizzasOptionMenu(IPizzaDao pDao) {
		mDao = pDao;
	}

	@Override
	public void execute() {

		for (Pizza p : mDao.findAllPizzas()) {
			System.out.println(p.toString());
		}

	}

}
