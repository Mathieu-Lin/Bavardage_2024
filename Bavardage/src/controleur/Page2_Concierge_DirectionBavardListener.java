package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import modele.Batiment;
import modele.Bavard;
import vue.Page1_Batiment_JFrame;
import vue.Page3_Bavard_JFrame;

public class Page2_Concierge_DirectionBavardListener implements ActionListener{
	/**
	 *  Attributs de la classe
	 */
	private JFrame frame;
	private Batiment bat;
	private Bavard bav;
	/**
	 *  Constructeur de la classe
	 */
	public Page2_Concierge_DirectionBavardListener (JFrame frame, Batiment bat, Bavard bav) {
		this.frame = frame;
		this.bat = bat;
		this.bav = bav;
	}
	/**
	 *  Méthodes de la classe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		frame.dispose();
		new Page3_Bavard_JFrame(bat,bav);
	}
}
