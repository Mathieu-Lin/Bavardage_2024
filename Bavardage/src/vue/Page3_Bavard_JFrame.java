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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controleur.Page2_Concierge_RetourBatimentListener;
import controleur.Page3_Bavard_RetourConciergeListener;
import controleur.Page3_Bavard_SendMessageListener;
import modele.Batiment;
import modele.Bavard;

public class Page3_Bavard_JFrame extends JFrame {
    /**
     *  Attributs de la classe
     */
    private static final int HAUTEUR = 700, LARGEUR = 600;
    private Batiment bat;
    private Bavard bav;

    /**
     *  Constructeur de la classe
     */
    public Page3_Bavard_JFrame(Batiment bat, Bavard b) {
        this.bat = bat;
        this.bav = b;
	    //////////////////////////////////////////////////////////////
	    // BEGINNING
	    //////////////////////////////////////////////////////////////
	    // Création de la fenêtre
	    JFrame frame = new JFrame("Bavardez !");
        frame.setTitle("Bavardez !");
        frame.setSize(HAUTEUR, LARGEUR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Création du panel principal
        JPanel principal = new JPanel();
        principal.setLayout(new GridLayout(3,1));
        
	    //////////////////////////////////////////////////////////////
	    // NORTH
	    //////////////////////////////////////////////////////////////
        // Création et ajout du panel north
        JPanel north = createNorthPanel();
	    //////////////////////////////////////////////////////////////
	    // CENTER
	    //////////////////////////////////////////////////////////////
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3,2));
	    center.setPreferredSize(new Dimension(center.getPreferredSize().width, 50));
	    
	    JLabel infoSubject = new JLabel("Sujet : ");
	    infoSubject.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
	    infoSubject.setBackground(Color.GRAY); // Définit la couleur de fond en gris
	    infoSubject.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoSubject.setHorizontalAlignment(SwingConstants.CENTER);
	    infoSubject.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
        JTextField createTextFieldSubject = new JTextField();
        createTextFieldSubject.setEditable(true);
        createTextFieldSubject.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
	    JLabel infoComment = new JLabel("Commentez : ");
	    infoComment.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
	    infoComment.setBackground(Color.GRAY); // Définit la couleur de fond en gris
	    infoComment.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoComment.setHorizontalAlignment(SwingConstants.CENTER);
	    infoComment.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
        JTextField createTextFieldBody = new JTextField();
        createTextFieldBody.setEditable(true);
        createTextFieldBody.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    JLabel infoButtonPub = new JLabel("Envoyez : ");
	    infoButtonPub.setOpaque(true); // Permet de rendre le fond opaque pour pouvoir changer sa couleur
	    infoButtonPub.setBackground(Color.GRAY); // Définit la couleur de fond en gris
	    infoButtonPub.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    infoButtonPub.setHorizontalAlignment(SwingConstants.CENTER);
	    infoButtonPub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    JButton sendButton = new JButton();
	    sendButton.setBackground(Color.BLUE); // Définit la couleur de fond en vert
	    sendButton.setForeground(Color.WHITE); // Définit la couleur de l'écriture en blanc
	    sendButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    
	    // Ajout des controleurs Direction vers la page Concierge
	    Page3_Bavard_SendMessageListener p3bSML = new Page3_Bavard_SendMessageListener(frame,bat,bav,createTextFieldSubject, createTextFieldBody);
	    sendButton.addActionListener(p3bSML);

	    center.add(infoSubject);
	    center.add(createTextFieldSubject);
	    center.add(infoComment);
	    center.add(createTextFieldBody);
	    center.add(infoButtonPub);
	    center.add(sendButton);
	    
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
	    Page3_Bavard_RetourConciergeListener p1bRCL = new Page3_Bavard_RetourConciergeListener(frame,bat);
	    goReturnButton.addActionListener(p1bRCL);
	    south.add(goReturnButton);

	    //////////////////////////////////////////////////////////////
	    // ENDING
	    //////////////////////////////////////////////////////////////
	    // Ajout du panel north à panel
	    principal.add(north);
	    // Ajout du panel center à panel
	    principal.add(center);
	    // Ajout du panel south à panel
	    principal.add(south);
	    
        // Ajout du panel principal à la fenêtre
        frame.getContentPane().add(principal);

        // Affichage de la fenêtre
        frame.setVisible(true);
    }

    private JPanel createNorthPanel() {
        JPanel north = new JPanel();
        north.setLayout(new GridLayout(this.bav.getMessagesRecus().size(), 1));
        north.setPreferredSize(new Dimension(north.getPreferredSize().width, 50));

        if (this.bav.getMessagesRecus().isEmpty()) {
            north.add(createMessagePanel("Aucun message", ""));
        } else {
            for (int i = 0; i < this.bav.getMessagesRecus().size(); i++) {
                String sujet = this.bav.getMessagesRecus().get(i).getSujet();
                String corps = this.bav.getMessagesRecus().get(i).getCorps();
                north.add(createMessagePanel(sujet, corps));
            }
        }

        return north;
    }

    private JPanel createMessagePanel(String sujet, String corps) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, 50));

        JPanel sujetPanel = new JPanel();
        sujetPanel.setLayout(new GridLayout(1, 2));
        sujetPanel.setPreferredSize(new Dimension(sujetPanel.getPreferredSize().width, 50));

        JLabel sujetLabel = new JLabel("Sujet : ");
        sujetLabel.setOpaque(true);
        sujetLabel.setBackground(Color.GRAY);
        sujetLabel.setForeground(Color.WHITE);
        sujetLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sujetLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel sujetContentLabel = new JLabel(sujet);
        sujetContentLabel.setOpaque(true);
        sujetContentLabel.setBackground(Color.BLUE);
        sujetContentLabel.setForeground(Color.WHITE);
        sujetContentLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        sujetPanel.add(sujetLabel);
        sujetPanel.add(sujetContentLabel);

        JTextField corpsTextField = new JTextField(corps);
        corpsTextField.setEditable(false);
        corpsTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.add(sujetPanel);
        panel.add(corpsTextField);

        return panel;
    }
}
