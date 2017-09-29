package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;


public abstract class OptionMenu {
	
	protected IPizzaDao mDao;
	
	public abstract String getLibelle();
	public abstract void execute() throws StockageException;
	
	/*private void initListPizza(){

		mPizzas.add(new Pizza("PEP", "Pépéroni", 12.5));
		mPizzas.add(new Pizza( "MAR", "Margherita" ,14.00));
		mPizzas.add(new Pizza( "REIN", "La Reine", 11.50));
		mPizzas.add(new Pizza( "FRO", "La 4 fromages", 12.00));
		mPizzas.add(new Pizza( "CAN", "La cannibale", 12.50));
		mPizzas.add(new Pizza( "SAV" ,"La savoyarde" ,13.00));
		mPizzas.add(new Pizza( "ORI", "L’orientale" ,13.50));
		mPizzas.add(new Pizza( "IND", "L’indienne", 14.00));
	}*/
	
	/*public List<Pizza> getmPizzas() {
		return mPizzas;
	}*/
	
	protected void afficherListPizzas(List<Pizza> pPizzas){
		for (Pizza p : pPizzas){
			System.out.println(p);
		}
	}


	
}
