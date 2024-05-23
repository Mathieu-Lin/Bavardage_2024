package vue;
import javax.swing.*;

import controleur.Page1_Batiment_ConnecterBavardListener;
import controleur.Page1_Batiment_CreateBavardListener;
import controleur.Page1_Batiment_DeconnecterBavardListener;
import controleur.Page1_Batiment_DirectionConciergeListener;
import modele.Batiment;

import java.awt.*;

public class Page1_Batiment_JFrame extends JFrame {
	/**
	 *  Attributs de la classe
	 */
	/*
	 * Valeurs constantes : 
	 * - HAUTEUR de la fenetre
	 * - LARGEUR de la fenetre 
	*/
	private static final int HAUTEUR = 700, LARGEUR = 600;
	private Batiment bat;
	
	/**
	 *  Constructeur de la classe
	 */
	public Page1_Batiment_JFrame(Batiment bat) {
	    //////////////////////////////////////////////////////////////
	    // BEGINNING
	    //////////////////////////////////////////////////////////////
		// Suppression de la fenetre précédente
		dispose();		
		// Création de la fenêtre
	    JFrame frame = new JFrame("Batiment des bavardages !");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(HAUTEUR, LARGEUR);

	    // Création du panel principal
	    JPanel principal = new JPanel();
	    principal.setLayout(new BorderLayout());
	    
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
	    center.setPreferredSize(new Dimension(center.getPreferredSize().width, 50));
	    
	    for (int i = 0; i<bat.getBavards().size(); i++) {
	    	// Création du sous panel 
	    	JPanel centerBavard = new JPanel();
	    	centerBavard.setLayout(new GridLayout(1,2));
		    centerBavard.setPreferredSize(new Dimension(centerBavard.getPreferredSize().width, 50));
	    	
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

	    // Affichage de la fenêtre
	    frame.setVisible(true);
	    
	    
	}
	/**
	 *  Méthodes de la classe
	 */
	
}
