package fr.pizzeria.console;

import java.util.Locale;
import java.util.Scanner;

public class PizzeriaAdminConsoleApp {
	public static final Scanner sScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Pizzas pizzas = new Pizzas();
		boolean exit = true;

		sScanner.useLocale(Locale.US);// Pour pouvoir utiliser le point et la virgule aissi
		while(exit){
			afficherMenu();
			switch (sScanner.nextInt()) {
				case 1:
					System.out.println("Liste des Pizzas :");
					pizzas.afficher();
					break;
				case 2:
					System.out.println("Ajout d’une nouvelle pizza");
					pizzas.addPizza();
					break;
				case 3:
					System.out.println("Mise à jour d’une pizza");
					pizzas.update();
					break;
				case 4:
					System.out.println("Suppression d’une pizza");
					pizzas.delete();
					break;
					
				default:
					System.out.println("Merci de votre visite :)  Aurevoir \u2639.");
					exit = false;
					//TODO exit
					break;
			}
		}
		sScanner.close();
	}

	public static void afficherMenu(){
		 
		System.out.println("\n***** Pizzeria Administration *****" +
		"\n\t 1. Lister les pizzas" +
		"\n\t 2. Ajouter une nouvelle pizza" +
		"\n\t 3. Mettre à jour une pizza" +
		"\n\t 4. Supprimer une pizza" + 
		"\n\t 99. Sortir");
	}

	}
