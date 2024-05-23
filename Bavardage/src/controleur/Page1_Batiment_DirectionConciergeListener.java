package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Batiment;
import modele.Concierge;
import vue.Page2_Concierge_JFrame;

public class Page1_Batiment_DirectionConciergeListener implements ActionListener{
	/**
	 *  Attributs de la classe
	 */
	private JFrame frame;
	private Batiment bat;
	private Concierge con;
	/**
	 *  Constructeur de la classe
	 */
	public Page1_Batiment_DirectionConciergeListener (JFrame frame, Batiment bat, Concierge con) {
		this.frame = frame;
		this.bat = bat;
		this.con = con;
	}
	/**
	 *  Méthodes de la classe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame.dispose();
		new Page2_Concierge_JFrame(bat,con);
	}
	
	
	
	
}
