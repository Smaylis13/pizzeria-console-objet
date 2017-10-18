package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE ("Viande"),  SANS_VIANDE("Sans Viande"), POISSON("Poisson");
	
	private String name;
	  //Constructeur
	private CategoriePizza(String name){ // private obligatoire sinon ça ne compile pas !
	    this.name = name;
	  }
	public static CategoriePizza valueOf(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case 1:
			return VIANDE;
		case 2:
			return SANS_VIANDE;
		case 3:
			return POISSON;
		
		}
		return null;
	}
	  
}
