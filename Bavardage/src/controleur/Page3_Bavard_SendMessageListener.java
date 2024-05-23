package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import modele.Batiment;
import modele.Bavard;
import modele.PapotageEvent;
import vue.Page3_Bavard_JFrame;

public class Page3_Bavard_SendMessageListener implements ActionListener {
	/**
	 *  Attributs de la classe
	 */
	private JFrame frame;
	private Batiment bat;
	private Bavard bav;
	private JTextField sub;
	private JTextField body;
	/**
	 *  Constructeur de la classe
	 */
	public Page3_Bavard_SendMessageListener(JFrame frame, Batiment bat, Bavard bav, JTextField sub, JTextField body) {
		this.frame = frame;
		this.bat = bat;
		this.bav = bav;
		this.sub = sub;
		this.body = body;
	}
	/**
	 *  Méthodes de la classe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
        // Récupérer le sujet et le corps du message depuis les champs de texte
        String sujet = sub.getText();
        String corps = body.getText();

        // Créer un nouvel événement de type PapotageEvent
        PapotageEvent message = new PapotageEvent(sujet, corps);

        bat.getBavards().remove(bav);
        ArrayList<Bavard>  bavards = bat.getBavards();
        // Envoyer le message via le Bavard
        bav.envoyerMessage(message, bat.getConcierge());
        bavards.add(bav);
        bat.setBavards(bavards);
        
        // Effacer les champs de texte après l'envoi du message
        sub.setText("");
        body.setText("");
		
		frame.dispose();
		new Page3_Bavard_JFrame(bat, bav);
	}
	
}
