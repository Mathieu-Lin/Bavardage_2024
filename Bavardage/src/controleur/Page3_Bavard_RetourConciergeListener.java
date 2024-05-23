package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modele.Batiment;
import vue.Page1_Batiment_JFrame;
import vue.Page2_Concierge_JFrame;

public class Page3_Bavard_RetourConciergeListener implements ActionListener {
	/**
	 *  Attributs de la classe
	 */
	private JFrame frame;
	private Batiment bat;
	/**
	 *  Constructeur de la classe
	 */
	public Page3_Bavard_RetourConciergeListener (JFrame frame, Batiment bat) {
		this.frame = frame;
		this.bat = bat;
	}
	/**
	 *  Méthodes de la classe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		frame.dispose();
		new Page2_Concierge_JFrame(bat,bat.getConcierge());
	}
	
	
}
