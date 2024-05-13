package modele;

import java.util.ArrayList;

public class Concierge {
	/**
	 *  Attributs de la classe
	 */
    // Liste des Bavards connectés au concierge
    private ArrayList<Bavard> bavardsConnectes;
    
	/**
	 *  Constructeur de la classe
	 */
    public Concierge() {
    	this.bavardsConnectes = new ArrayList<Bavard>();
    }
    
	/**
	 *  Méthodes de la classe
	 */
    
    // Méthode pour s'abonner au concierge
    public void sAbonner(Bavard bavard) {
        this.bavardsConnectes.add(bavard);
    }

	// Méthode pour se désabonner du concierge
    public void seDesabonner(Bavard bavard) {
        this.bavardsConnectes.remove(bavard);
    }

    // Méthode pour transmettre un message à tous les Bavards connectés
    public void transmettreMessage(PapotageEvent message) {
        for (int i = 0; i<this.bavardsConnectes.size(); i++) {
            this.bavardsConnectes.get(i).onPapotageEventReceived(message);
        }
    }

    // Méthode appelée lorsqu'un événement de messagerie est reçu
    public void onPapotageEventReceived(PapotageEvent event) {
        // Ne fait rien, car le concierge n'est pas destinataire des messages
    }
    public ArrayList<Bavard> getBavardsConnectes() {
		return bavardsConnectes;
	}

	public void setBavardsConnectes(ArrayList<Bavard> bavardsConnectes) {
		this.bavardsConnectes = bavardsConnectes;
	}
}
