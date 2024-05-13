package modele;

public class Bavard implements PapotageListener{
	/**
	 *  Attributs de la classe
	 */
	
	/**
	 *  Constructeur de la classe
	 */
	/**
	 *  Méthodes de la classe
	 */
    // Méthode pour envoyer un message à travers le concierge
    public void envoyerMessage(PapotageEvent message, Concierge concierge) {
        concierge.transmettreMessage(message);
    }

    // Méthode appelée lorsqu'un événement de messagerie est reçu
    public void onPapotageEventReceived(PapotageEvent event) {
    	String sujetDuMessage = event.getSujet();
    	String corpsDuMessage = event.getCorps();
    	
        // Réagir à l'événement reçu, par exemple afficher le message
        afficherMessage(event.getSujet(), event.getCorps());
    }

    // Méthode pour afficher un message reçu
    public void afficherMessage(String sujet, String corps) {
        // Logique pour afficher le message dans l'interface utilisateur du Bavard
    }
}
