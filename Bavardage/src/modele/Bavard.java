package modele;

import java.util.ArrayList;
import java.util.List;

public class Bavard implements PapotageListener {
    /**
     *  Attributs de la classe
     */
    private ArrayList<PapotageEvent> messagesRecus;

    /**
     *  Constructeur de la classe
     */
    public Bavard() {
        this.messagesRecus = new ArrayList<>();
    }



	/**
     *  Méthodes de la classe
     */
    // Méthode pour envoyer un message à travers le concierge
    public void envoyerMessage(PapotageEvent message, Concierge concierge) {
        concierge.transmettreMessage(message);
    }

    // Méthode appelée lorsqu'un événement de messagerie est reçu
    @Override
    public void onPapotageEventReceived(PapotageEvent event) {
        messagesRecus.add(event);
        afficherMessage(event.getSujet(), event.getCorps());
    }

    // Méthode pour afficher un message reçu
    public String afficherMessage(String sujet, String corps) {
        // Logique pour afficher le message dans l'interface utilisateur du Bavard
        return sujet + " : \n" + corps;
    }
    public String afficherSujet(String corps) {
        // Logique pour afficher le message dans l'interface utilisateur du Bavard
        return corps;
    }
    public String afficherCorps(String corps) {
        // Logique pour afficher le message dans l'interface utilisateur du Bavard
        return corps;
    }

    public PapotageEvent getLastMessage() {
        if (messagesRecus.isEmpty()) {
            return null;
        }
        return messagesRecus.get(messagesRecus.size() - 1);
    }
    public ArrayList<PapotageEvent> getMessagesRecus() {
		return messagesRecus;
	}

	public void setMessagesRecus(ArrayList<PapotageEvent> messagesRecus) {
		this.messagesRecus = messagesRecus;
	}
}
