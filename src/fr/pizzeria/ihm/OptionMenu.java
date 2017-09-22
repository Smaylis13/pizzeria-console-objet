package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.Pizza;

public abstract class OptionMenu {
	
	/*public OptionMenu(){
		initListPizza();
	}
	
	protected static List<Pizza> mPizzas = new ArrayList<Pizza>();
	*/
	public abstract String getLibelle();
	public abstract void execute();
	
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
