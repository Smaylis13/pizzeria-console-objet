package fr.pizzeria.console;

import fr.pizzeria.dao.IPizzaDao;

public class Pizza {
	private int mId;
	private String mCode;
	private String mNom;
	private double mPrix;
	private static int sID = 0;
	public Pizza(String pCode,String pNom, double pPrix){
		  mId = sID;
		  sID++;
		  mCode = pCode;
		  mNom = pNom;
		  mPrix = pPrix;
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
		return mCode+" -> "+mNom+" ("+String.format("%.2f", mPrix)+"€)";
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
