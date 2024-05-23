package controleur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import modele.Batiment;
import modele.Bavard;

public class Page1_Batiment_DeconnecterBavardListener implements ActionListener{
	/**
	 *  Attributs de la classe
	 */
	private JFrame frame;
	private JPanel principal;
	private Batiment bat;
	private Bavard bav;
	
	/**
	 *  Constructeur de la classe
	 */
	public Page1_Batiment_DeconnecterBavardListener(JFrame frame, JPanel principal, Batiment bat, Bavard bav) {
		this.frame =frame;
		this.principal = principal;
		this.bat = bat;
		this.bav = bav;
	}
	/**
	 *  Méthodes de la classe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.bat.deconnecterBavard(this.bav);
		
	    //////////////////////////////////////////////////////////////
	    // NORTH
	    //////////////////////////////////////////////////////////////
	    // Création du panel north
	    JPanel north = new JPanel();
	    north.setLayout(new GridLayout(1,2));
	    north.setPreferredSize(new Dimension(north.getPreferredSize().width, 50));
	    // Création des labels et des boutons
	    
	    JLabel infoCreateBavardButton = new JLabel("Créer un bavard : ");
	    infoCreateBavardButton.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
	    infoCreateBavardButton.setBackground(Color.GRAY); // Définit la couleur de fond en gris
	    infoCreateBavardButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoCreateBavardButton.setHorizontalAlignment(SwingConstants.CENTER);
	    infoCreateBavardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    JButton createBavardButton = new JButton("Bavard");
	    createBavardButton.setBackground(Color.BLUE); // Définit la couleur de fond en vert
	    createBavardButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    createBavardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    // Ajout des controleurs
	    Page1_Batiment_CreateBavardListener p1bCBL = new Page1_Batiment_CreateBavardListener(frame,principal,bat);
	    createBavardButton.addActionListener(p1bCBL);
	    
	    // Affectation à la panel north
	    north.add(infoCreateBavardButton);
	    north.add(createBavardButton);
	    
	    //////////////////////////////////////////////////////////////
	    // CENTER
	    //////////////////////////////////////////////////////////////
	    // Création du panel north
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(bat.getBavards().size(),2));
	    center.setPreferredSize(new Dimension(center.getPreferredSize().width, 20));
	    
	    for (int i = 0; i<bat.getBavards().size(); i++) {
	    	// Création du sous panel 
	    	JPanel centerBavard = new JPanel();
	    	centerBavard.setLayout(new GridLayout(1,2));
		    centerBavard.setPreferredSize(new Dimension(centerBavard.getPreferredSize().width, 20));
	    	
		    JButton createConnBavardButton = new JButton("Connecter");
		    createConnBavardButton.setBackground(Color.GREEN); // Définit la couleur de fond en vert
		    createConnBavardButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
		    createConnBavardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    	
		    JButton createDisconnBavardButton = new JButton("Déconnecter");
		    createDisconnBavardButton.setBackground(Color.RED); // Définit la couleur de fond en vert
		    createDisconnBavardButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
		    createDisconnBavardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    
		    // Ajout des controleurs Connecter
		    Page1_Batiment_ConnecterBavardListener p1bConnBL = new Page1_Batiment_ConnecterBavardListener(frame,principal,bat,bat.getBavards().get(i));
		    createConnBavardButton.addActionListener(p1bConnBL);
		    
		    // Ajout des controleurs Deconnecter
		    Page1_Batiment_DeconnecterBavardListener p1bDeconnBL = new Page1_Batiment_DeconnecterBavardListener(frame,principal,bat,bat.getBavards().get(i));
		    createDisconnBavardButton.addActionListener(p1bDeconnBL);
		    
		    centerBavard.add(createConnBavardButton);
		    centerBavard.add(createDisconnBavardButton);
		    
		    JLabel infoConnBavardButton = new JLabel(String.valueOf(i) + ".");
		    infoConnBavardButton.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
		    infoConnBavardButton.setBackground(Color.GRAY); // Définit la couleur de fond en gris
		    infoConnBavardButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
		    infoConnBavardButton.setHorizontalAlignment(SwingConstants.CENTER);
		    infoConnBavardButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    
		    center.add(infoConnBavardButton);
		    center.add(centerBavard);
	    }
	    
	    //////////////////////////////////////////////////////////////
	    // SOUTH
	    //////////////////////////////////////////////////////////////
	    JPanel south = new JPanel();
	    south.setLayout(new GridLayout(1,1));
	   
	    JButton goConciergeButton = new JButton("Concierge");
	    goConciergeButton.setBackground(Color.BLUE); // Définit la couleur de fond en vert
	    goConciergeButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    goConciergeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    // Ajout des controleurs Direction vers la page Concierge
	    Page1_Batiment_DirectionConciergeListener p1bDCL = new Page1_Batiment_DirectionConciergeListener(frame,bat,bat.getConcierge());
	    goConciergeButton.addActionListener(p1bDCL);
	    south.add(goConciergeButton);
	    
	    //////////////////////////////////////////////////////////////
	    // ENDING
	    //////////////////////////////////////////////////////////////
	    // Retirer tous les trucs dans panel
	    this.principal.removeAll();
	    
	    // ScrollBar 
	    JScrollPane scrollPane = new JScrollPane(center);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    // Ajout du panel north à panel
	    principal.add(north,BorderLayout.NORTH);
	    // Ajout du panel center à panel
	    principal.add(center,BorderLayout.CENTER);
	    // Ajout du panel south à panel
	    principal.add(south,BorderLayout.SOUTH);
	    // Ajout du scrollbar à panel
	    principal.add(scrollPane,BorderLayout.EAST);
	    
	    // Ajout du panel à la fenêtre
	    frame.getContentPane().add(principal);
	    frame.getContentPane().revalidate(); // Revalide la mise en page pour afficher les nouveaux composants
	    frame.getContentPane().repaint(); // Redessine la fenêtre pour refléter les modifications
	}
}

