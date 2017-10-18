package fr.pizzeria.console;

import java.lang.reflect.Field;

import javax.persistence.*;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.ToString;
/**
 * 
 * @author IG
 *
 */
@Entity
public class Pizza {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mId;
	
	public int getId() {
		return mId;
	}
	@ToString
	@Column(name="codepizza")
	private String mCode;
	
	@ToString(uppercase=true)
	@Column(name="namePizza")
	private String mNom;
	
	@Column(name="price")
	private double mPrix;
	/**
	 * sID un id static qui s'incrémente à chaque ajout de pizza 
	 */
	private static int sID = 0;
	
	@Column(name="fk_categorie")
	CategoriePizza mCategorie;
	
	public Pizza(String pCode,String pNom, double pPrix){
		  //mId = sID;
		  //sID++;
		  mCode = pCode;
		  mNom = pNom;
		  mPrix = pPrix;
	}
	public Pizza(String pCode,String pNom, double pPrix, CategoriePizza pCategorie) {
		this(pCode, pNom, pPrix);
		mCategorie = pCategorie;
	}
	public Pizza(int pID, String pCode,String pNom, double pPrix){
		this(pCode, pNom, pPrix);
		mId = pID;
	}
	
	public CategoriePizza getmCategorie() {
		return mCategorie;
	}
	public Pizza setmCategorie(CategoriePizza mCategorie) {
		this.mCategorie = mCategorie;
		return this;
	}
	public Pizza() {
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
		StringBuilder returnString = new StringBuilder();

		for (Field f : this.getClass().getDeclaredFields()){
			try{
				if( f.get(this) instanceof String){
					if(f.getAnnotation(ToString.class) != null && f.getAnnotation(ToString.class).uppercase()){
						String tmp = (String) f.get(this);
						returnString.append(tmp.toUpperCase()+ " ");
					}else{
						returnString.append((String) f.get(this) + " ");
					}
				}else{
					if( f.getName().equals("mPrix"))
						returnString.append(" ("+String.format("%.2f", mPrix)+"€) " );
					else if (f.getName().equals("mCategorie"))
						returnString.append(f.get(this));
				}
			}catch (Exception e) {
				e.getStackTrace();
			}
		}
		return returnString.toString();
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
