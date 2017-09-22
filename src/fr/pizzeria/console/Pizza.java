package fr.pizzeria.console;

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
