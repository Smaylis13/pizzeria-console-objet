package fr.pizzeria.console;


import java.lang.reflect.Field;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.ToString;
/**
 * 
 * @author ETY23
 *
 */
public class Pizza {
	private int mId;
	
	@ToString
	private String mCode;
	
	@ToString(uppercase=true)
	private String mNom;
	
	private double mPrix;
	/**
	 * sID un id static qui s'incrémente à chaque ajout de pizza 
	 */
	private static int sID = 0;
	CategoriePizza mCategorie;
	public Pizza(String pCode,String pNom, double pPrix){
		  mId = sID;
		  System.out.println("Mon id est : "+mId);
		  sID++;
		  mCode = pCode;
		  mNom = pNom;
		  mPrix = pPrix;
	}
	public Pizza(String pCode,String pNom, double pPrix, CategoriePizza pCategorie) {
		this(pCode, pNom, pPrix);
		mCategorie = pCategorie;
	}
	
	public CategoriePizza getmCategorie() {
		return mCategorie;
	}
	public Pizza setmCategorie(CategoriePizza mCategorie) {
		this.mCategorie = mCategorie;
		return this;
	}
	public Pizza() {
		// TODO Auto-generated constructor stub
		this("EEE","EEEEEE",0.2);
	}



	public String getmCode() {
		return mCode;
	}

	public String getmNom() {
		return mNom;
	}

	public double getmPrix() {
		return mPrix;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mCode == null) ? 0 : mCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (mCode == null) {
			if (other.mCode != null)
				return false;
		} else if (!mCode.equals(other.mCode))
			return false;
		return true;
	}

	public boolean compCode(String pCode){
		return pCode.equals(mCode);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String returnString = " ";
		///String returnString = mCode+" -> "+mNom+" ("+String.format("%.2f", mPrix)+"€) Catégorie : " + mCategorie;
		for (Field f : this.getClass().getDeclaredFields()){
			try{
				if( f.get(this) instanceof String){
					if(f.getAnnotation(ToString.class) != null && f.getAnnotation(ToString.class).uppercase()){
						String tmp = (String) f.get(this);
						returnString +=  tmp.toUpperCase()+ " ";
					}else{
						returnString +=  (String) f.get(this) + " ";
					}
				}else{
					if( f.getName().equals("mPrix"))
						returnString += " ("+String.format("%.2f", mPrix)+"€) " ;
					else if (f.getName().equals("mCategorie"))
						returnString +=  f.get(this);
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		return returnString;
	}


	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public void setmNom(String mNom) {
		this.mNom = mNom;
	}

	public void setmPrix(double mPrix) {
		this.mPrix = mPrix;
	}
	
}
