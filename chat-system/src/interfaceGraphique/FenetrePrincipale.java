package interfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class FenetrePrincipale {

	private JFrame frame;

	private Controleur controleur;
	
	/**
	 * Create the application.
	 */
	public FenetrePrincipale(Controleur controleur) {
		this.controleur = controleur;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ChatSystem");
		frame.setBounds(100, 100, 739, 520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panelLeft = new JPanel();
		GridBagConstraints gbc_panelLeft = new GridBagConstraints();
		gbc_panelLeft.fill = GridBagConstraints.BOTH;
		gbc_panelLeft.gridx = 0;
		gbc_panelLeft.gridy = 0;
		frame.getContentPane().add(panelLeft, gbc_panelLeft);
		GridBagLayout gbl_panelLeft = new GridBagLayout();
		gbl_panelLeft.columnWeights = new double[]{1.0};
		gbl_panelLeft.rowWeights = new double[]{1.0, 1.0};
		panelLeft.setLayout(gbl_panelLeft);
		
		JPanel panelPseudo = new JPanel();
		GridBagConstraints gbc_panelPseudo = new GridBagConstraints();
		gbc_panelPseudo.insets = new Insets(0, 0, 5, 0);
		gbc_panelPseudo.fill = GridBagConstraints.BOTH;
		gbc_panelPseudo.gridx = 0;
		gbc_panelPseudo.gridy = 0;
		panelLeft.add(panelPseudo, gbc_panelPseudo);
		GridBagLayout gbl_panelPseudo = new GridBagLayout();
		gbl_panelPseudo.columnWidths = new int[]{0, 0, 0};
		gbl_panelPseudo.rowHeights = new int[]{0, 0, 0};
		gbl_panelPseudo.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelPseudo.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelPseudo.setLayout(gbl_panelPseudo);

		/*--------------------Panel Pseudo----------------------------*/
		
		JLabel labelPseudo = new JLabel(controleur.demandePseudo());
		GridBagConstraints gbc_labelPseudo = new GridBagConstraints();
		gbc_labelPseudo.insets = new Insets(10, 10, 0, 0);
		gbc_labelPseudo.gridx = 0;
		gbc_labelPseudo.gridy = 0;
		gbc_labelPseudo.weightx = 2;
		panelPseudo.add(labelPseudo, gbc_labelPseudo);
		
		JButton bouttonChangerPseudo = new JButton("Changer pseudo");
		GridBagConstraints gbc_bouttonChangerPseudo = new GridBagConstraints();
		gbc_bouttonChangerPseudo.insets = new Insets(5, 0, 0, 0);
		gbc_bouttonChangerPseudo.gridx = 1;
		gbc_bouttonChangerPseudo.gridy = 0;
		panelPseudo.add(bouttonChangerPseudo, gbc_bouttonChangerPseudo);
		
		JLabel labelPseudoErreur = new JLabel("Pseudo déjà pris");
		labelPseudoErreur.setForeground(Color.RED);
		labelPseudoErreur.setVisible(false);
		GridBagConstraints gbc_labelPseudoErreur = new GridBagConstraints();
		gbc_labelPseudoErreur.insets = new Insets(0, 0, 0, 0);
		gbc_labelPseudoErreur.gridx = 0;
		gbc_labelPseudoErreur.gridy = 1;
		panelPseudo.add(labelPseudoErreur, gbc_labelPseudoErreur);
		
		/*--------------------Onglets----------------------------*/
		
		JTabbedPane panelOnglets = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_panelOnglets = new GridBagConstraints();
		gbc_panelOnglets.fill = GridBagConstraints.BOTH;
		gbc_panelOnglets.gridx = 0;
		gbc_panelOnglets.gridy = 1;
		gbc_panelOnglets.weighty = 15;
		panelLeft.add(panelOnglets, gbc_panelOnglets);
		
		JPanel panelHistoriques = new JPanel();
		panelOnglets.addTab("Historiques", null, panelHistoriques, null);
		
		JPanel panelActifs = new JPanel();
		panelOnglets.addTab("Actifs", null, panelActifs, null);
		
		JPanel panelEnCours = new JPanel();
		panelOnglets.addTab("En Cours", null, panelEnCours, null);
		
		/*----------------------Panel Right---------------------------*/
		JPanel panelRight = new JPanel();
		GridBagConstraints gbc_panelRight = new GridBagConstraints();
		gbc_panelRight.fill = GridBagConstraints.BOTH;
		gbc_panelRight.gridx = 1;
		gbc_panelRight.weightx = 3;
		gbc_panelRight.gridy = 0;
		frame.getContentPane().add(panelRight, gbc_panelRight);
	}
}
