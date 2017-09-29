package fr.pizzeria.model;

public enum CategoriePizza {
	VIANDE ("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String name;
	  //Constructeur
	private CategoriePizza(String name){ // private obligatoire sinon ça ne compile pas !
	    this.name = name;
	  }
	public static CategoriePizza valueOf(int i) {
		// TODO Auto-generated method stub
		switch (i) {
		case 0:
			return VIANDE;
		case 1:
			return POISSON;
		case 2:
			return SANS_VIANDE;
		}
		return null;
	}
	  
}
