package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.Page2_Concierge_DirectionBavardListener;
import controleur.Page1_Batiment_CreateBavardListener;
import controleur.Page2_Concierge_RetourBatimentListener;
import modele.Batiment;
import modele.Bavard;
import modele.Concierge;
import modele.PapotageEvent;

public class Page2_Concierge_JFrame extends JFrame {
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
	private Concierge con;
	/**
	 *  Constructeur de la classe
	 */
	public Page2_Concierge_JFrame(Batiment bat, Concierge con) {
	    //////////////////////////////////////////////////////////////
	    // BEGINNING
	    //////////////////////////////////////////////////////////////
	    // Création de la fenêtre
	    JFrame frame = new JFrame("Concierge des bavardages !");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(HAUTEUR, LARGEUR);
	    
	    // Création du panel principal
	    JPanel principal = new JPanel();
	    principal.setLayout(new BorderLayout());
	   
	    //////////////////////////////////////////////////////////////
	    // NORTH
	    //////////////////////////////////////////////////////////////
	    JPanel north = new JPanel();
	    north.setLayout(new GridLayout(1,2));
	    north.setPreferredSize(new Dimension(north.getPreferredSize().width, 50));
	    // Création des labels et des boutons
	    
	    JLabel infoMessagesNorth = new JLabel("Messages reçus : ");
	    infoMessagesNorth.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
	    infoMessagesNorth.setBackground(Color.GRAY); // Définit la couleur de fond en gris
	    infoMessagesNorth.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoMessagesNorth.setHorizontalAlignment(SwingConstants.CENTER);
	    infoMessagesNorth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    JLabel infoNorth2 = new JLabel("");
	    infoNorth2.setBackground(Color.BLUE); // Définit la couleur de fond en vert
	    infoNorth2.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoNorth2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    // Affectation à la panel north
	    north.add(infoMessagesNorth);
	    north.add(infoNorth2);
	    
	    //////////////////////////////////////////////////////////////
	    // CENTER
	    //////////////////////////////////////////////////////////////
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(bat.getBavards().size(),2));
	    center.setPreferredSize(new Dimension(center.getPreferredSize().width, 50));
	    
	    for (int i = 0; i<bat.getConcierge().getBavardsConnectes().size(); i++) {
	    	// Création du sous panel 
	    	JPanel centerBavard = new JPanel();
	    	centerBavard.setLayout(new GridLayout(2,1));
		    centerBavard.setPreferredSize(new Dimension(centerBavard.getPreferredSize().width, 50));
		   
		    // Création du sous panel 2
	    	JPanel centerBavard2 = new JPanel();
	    	centerBavard2.setLayout(new GridLayout(1,2));
		    centerBavard2.setPreferredSize(new Dimension(centerBavard2.getPreferredSize().width, 50));
		    
		    JLabel infoBavardWithId = new JLabel("Bavard " + i + " : ");
		    infoBavardWithId.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
		    infoBavardWithId.setBackground(Color.GREEN); // Définit la couleur de fond en vert
		    infoBavardWithId.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
		    infoBavardWithId.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    infoBavardWithId.setHorizontalAlignment(SwingConstants.CENTER);
		    
		    JButton goMessagesDetailsButton = new JButton("Voir details");
		    goMessagesDetailsButton.setBackground(Color.BLUE); // Définit la couleur de fond en vert
		    goMessagesDetailsButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
		    goMessagesDetailsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		    
		    // Ajout des controleurs Direction Messages
		    Page2_Concierge_DirectionBavardListener p2CDBL = new Page2_Concierge_DirectionBavardListener(frame,bat, bat.getConcierge().getBavardsConnectes().get(i));
		    goMessagesDetailsButton.addActionListener(p2CDBL);
		    
		    String sujet = "";
		    String messageText = "";
		    Bavard b = bat.getConcierge().getBavardsConnectes().get(i);
		    for (int i1 = 0; i1<b.getMessagesRecus().size(); i1++) {
		    	sujet = sujet + "Sujet "+i1+ " : " + b.getMessagesRecus().get(i1).getSujet() + "\n";
		    	messageText = b.afficherSujet(sujet);
		    }
            JTextField createBavardTextField = new JTextField(messageText);
            createBavardTextField.setEditable(false);
            createBavardTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
		    centerBavard2.add(infoBavardWithId);
		    centerBavard2.add(goMessagesDetailsButton);
		    centerBavard.add(centerBavard2);
		    centerBavard.add(createBavardTextField);
            center.add(centerBavard);
	    }
	    //////////////////////////////////////////////////////////////
	    // SOUTH
	    //////////////////////////////////////////////////////////////
	    JPanel south = new JPanel();
	    south.setLayout(new GridLayout(1,1));
	   
	    JButton goReturnButton = new JButton("Retour");
	    goReturnButton.setBackground(Color.BLUE); // Définit la couleur de fond en vert
	    goReturnButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    goReturnButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    // Ajout des controleurs Direction vers la page Concierge
	    Page2_Concierge_RetourBatimentListener p1bDCL = new Page2_Concierge_RetourBatimentListener(frame,bat);
	    goReturnButton.addActionListener(p1bDCL);
	    south.add(goReturnButton);
	    
	    //////////////////////////////////////////////////////////////
	    // ENDING
	    //////////////////////////////////////////////////////////////
	    // Ajout du panel north à panel
	    principal.add(north,BorderLayout.NORTH);
	    // Ajout du panel center à panel
	    principal.add(center,BorderLayout.CENTER);
	    // Ajout du panel south à panel
	    principal.add(south,BorderLayout.SOUTH);
	    
	    // Ajout du panel à la fenêtre
	    frame.getContentPane().add(principal);


	    // Affichage de la fenêtre
	    frame.setVisible(true);
	    
	    
	}
	/**
	 *  Méthodes de la classe
	 */

}
