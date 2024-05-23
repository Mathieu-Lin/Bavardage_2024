package testeur;

import modele.Batiment;
import modele.Bavard;
import modele.Concierge;
import modele.PapotageEvent;
import vue.Page1_Batiment_JFrame;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Batiment b = new Batiment();
		//Bavard bav = b.creerNouveauBavard();
		//Concierge c = new Concierge();
		//bav.envoyerMessage(new PapotageEvent("Coucou","Tralala"),c);
		Page1_Batiment_JFrame interfaceBatiment = new Page1_Batiment_JFrame(b);
	}

}
