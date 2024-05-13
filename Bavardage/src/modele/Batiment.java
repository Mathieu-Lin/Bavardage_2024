package modele;

import java.util.ArrayList;

public class Batiment {
	/**
	 *  Attributs de la classe
	 */
    // Liste des Bavards présents dans le bâtiment
    private ArrayList<Bavard> bavards;
    
    // Le concierge du bâtiment
    Concierge concierge;

	/**
	 *  Constructeur de la classe
	 */
    // Constructeur de la classe Batiment
    public Batiment() {
        // Initialisation des listes
        bavards = new ArrayList<Bavard>();
        concierge = new Concierge();
    }

	/**
	 *  Méthodes de la classe
	 */
    // Méthode pour créer un nouveau Bavard
    public Bavard creerNouveauBavard() {
        Bavard nouveauBavard = new Bavard();
        // Ajouter le Bavard à la liste des Bavards du bâtiment
        bavards.add(nouveauBavard);
        // Abonner le Bavard au concierge
        concierge.sAbonner(nouveauBavard);
        return nouveauBavard;
    }

    // Méthode pour permettre aux Bavards de se connecter
    public void connecterBavard(Bavard bavard) {
        // Ajouter le Bavard à la liste des Bavards du bâtiment
        bavards.add(bavard);
        // Abonner le Bavard au concierge
        concierge.sAbonner(bavard);
    }

    // Méthode pour permettre aux Bavards de se désabonner
    public void deconnecterBavard(Bavard bavard) {
        // Retirer le Bavard de la liste des Bavards du bâtiment
        bavards.remove(bavard);
        // Se désabonner du concierge
        concierge.seDesabonner(bavard);
    }

	public ArrayList<Bavard> getBavards() {
		return bavards;
	}

	public void setBavards(ArrayList<Bavard> bavards) {
		this.bavards = bavards;
	}

	public Concierge getConcierge() {
		return concierge;
	}

	public void setConcierge(Concierge concierge) {
		this.concierge = concierge;
	}
    
    
}
