package modele;

//Définition de la classe PapotageEvent
class PapotageEvent {
	/**
	 *  Attributs de la classe
	 */
	private String sujet;
	private String corps;

	// Constructeur de la classe
	public PapotageEvent(String sujet, String corps) {
		this.sujet = sujet;
		this.corps = corps;
	}

	
	// Méthodes de la classe

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getCorps() {
		return corps;
	}

	public void setCorps(String corps) {
		this.corps = corps;
	}
}

