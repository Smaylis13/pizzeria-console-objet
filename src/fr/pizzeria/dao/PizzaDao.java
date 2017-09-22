package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;

/**
 * 
 * @author ETY23
 *
 *
 */
public class PizzaDao implements IPizzaDao {

	private static List<Pizza> mListPizza;
	public PizzaDao() {
		if(mListPizza == null){
		mListPizza = new ArrayList<>();
		mListPizza.add(new Pizza("PEP", "Pépéroni", 12.5));
		mListPizza.add(new Pizza( "MAR", "Margherita" ,14.00));
		mListPizza.add(new Pizza( "REIN", "La Reine", 11.50));
		mListPizza.add(new Pizza( "FRO", "La 4 fromages", 12.00));
		mListPizza.add(new Pizza( "CAN", "La cannibale", 12.50));
		mListPizza.add(new Pizza( "SAV" ,"La savoyarde" ,13.00));
		mListPizza.add(new Pizza( "ORI", "L’orientale" ,13.50));
		mListPizza.add(new Pizza( "IND", "L’indienne", 14.00));
		}
	}
	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return mListPizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub
		return mListPizza.add(pizza);
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		for (int i = 0;  i < mListPizza.size() ; i++){
			if(mListPizza.get(i).compCode(codePizza)){
				mListPizza.set(i, pizza);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {

		for (int i = 0;  i < mListPizza.size() ; i++){
			if(mListPizza.get(i).compCode(codePizza)){
				mListPizza.remove(i);
				return true;
			}
		}
		return false;
	}

	//private List<Pizza> mPizzas = new ArrayList<Pizza>();
	/*
	public Pizzas() {
		super();

	}
	public void delete(){
		System.out.println("Veuillez choisir la pizza à supprimer :");
		afficher();
		System.out.println("(99 pour abandonnér)");
		String code = PizzeriaAdminConsoleApp.sScanner.next();
		if(!code.equals("99")){
			for (int i = 0 ; i < mPizzas.size() ; i++){
				Pizza p = mPizzas.get(i);
				if(p.getmCode().equals(code.toUpperCase())){
					if(mPizzas.remove(i) != null){
						System.out.println("la pizza "+p+"a bien été supprimer" );
					}
				}
			}
		}
	}
	public void update(){
		System.out.println("Veuillez choisir la pizza à modifier :");
		afficher();
		System.out.println("(99 pour abandonnér)");
		String code = PizzeriaAdminConsoleApp.sScanner.next();
		if(!code.equals("99")){
			for (Pizza p : mPizzas){
				if(p.getmCode().equals(code.toUpperCase())){
					System.out.println("Veuillez saisir le nouveau code :");
					p.setmCode(PizzeriaAdminConsoleApp.sScanner.next());
					System.out.println("Veuillez saisir le nouveau nom :");
					p.setmNom(PizzeriaAdminConsoleApp.sScanner.next());
					System.out.println("Veuillez saisir le nouveau prix:");
					p.setmPrix(PizzeriaAdminConsoleApp.sScanner.nextDouble());
					
				}
			}
		}
	}

	public void addPizza(){
		Pizza newPizza = new Pizza();
		System.out.println("Veuillez saisir un CODE");
		newPizza.setmCode(PizzeriaAdminConsoleApp.sScanner.next());
		System.out.println("Veuillez saisir un NOM");
		newPizza.setmNom(PizzeriaAdminConsoleApp.sScanner.next());
		System.out.println("Veuillez saisir un PRIX");
		newPizza.setmPrix(PizzeriaAdminConsoleApp.sScanner.nextDouble());
		mPizzas.add(newPizza);
	}
	public void afficher(){
		for(Pizza p : mPizzas){
			System.out.println(p.toString());
		}
	}*/

}
