package testeur;

import modele.Batiment;
import modele.Bavard;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Batiment b = new Batiment();
		Bavard bav = b.creerNouveauBavard();
		System.out.println("ok");
	}

}
