package Authentification;

import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JButton;

import InterfaceCuisinier.InterfaceCuisinier;
import InterfaceGerant.InterfaceGerant;
import InterfaceServeur.InterfaceServeur;


//import baseDeDonneesApachePOI.BaseDeDonneesApachePOI;


import java.awt.Font;

public class Authentification extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel identifiant = null;
	private JLabel motDePasse = null;
	private JTextField entreeIdentifiant = null;
	private JTextField entreeMotDePasse = null;
	private JButton connexion = null;
	private JLabel erreurAuthentification = null;
	public String identifiantvalide;
	/**
	 * This method initializes entreeIdentifiant	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEntreeIdentifiant() {
		if (entreeIdentifiant == null) {
			entreeIdentifiant = new JTextField();
			entreeIdentifiant.setSize(new Dimension(120, 30));
			entreeIdentifiant.setForeground(Color.gray);
			entreeIdentifiant.setText("entrer identifiant");
			entreeIdentifiant.setEditable(true);
			entreeIdentifiant.setLocation(new Point(120, 20));
			entreeIdentifiant.setFont(new Font("Dialog", Font.ITALIC, 12));
			entreeIdentifiant.setVisible(true);
			entreeIdentifiant.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mousePressed(java.awt.event.MouseEvent e) {    
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
					entreeIdentifiant.setText("");
					entreeIdentifiant.setForeground(Color.black);
				}

			});
		}
		return entreeIdentifiant;
	}

	/**
	 * This method initializes entreeMotDePasse	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getEntreeMotDePasse() {
		if (entreeMotDePasse == null) {
			entreeMotDePasse = new JTextField();
			entreeMotDePasse.setSize(new Dimension(120, 30));
			entreeMotDePasse.setForeground(Color.gray);
			entreeMotDePasse.setText("entrer mot de passe");
			entreeMotDePasse.setEnabled(true);
			entreeMotDePasse.setEditable(true);
			entreeMotDePasse.setFont(new Font("Dialog", Font.ITALIC, 12));
			entreeMotDePasse.setLocation(new Point(120, 60));
			entreeMotDePasse.addMouseListener(new java.awt.event.MouseAdapter() {   
				public void mousePressed(java.awt.event.MouseEvent e) {    
					System.out.println("mousePressed()"); // TODO Auto-generated Event stub mousePressed()
					entreeMotDePasse.setText("");
					entreeMotDePasse.setForeground(Color.black);
				}

			});
		}
		return entreeMotDePasse;
	}

	/**
	 * This method initializes connexion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getConnexion() {
		if (connexion == null) {
			connexion = new JButton();
			connexion.setText("Connexion");
			connexion.setLocation(new Point(90, 120));
			connexion.setSize(new Dimension(100, 20));
			connexion.setActionCommand("Connexion");
			connexion.setName("Connexion");
			connexion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					if((entreeIdentifiant.getText().equals("entrer identifiant")||(entreeMotDePasse.getText().equals("entrer mot de passe"))||(entreeIdentifiant.getText().equals(""))||(entreeMotDePasse.getText().equals(""))))
					{
						erreurAuthentification.setForeground(Color.RED);
						erreurAuthentification.setText("Veuillez entrer votre identifiant et/ou Mot de passe");
						
						System.out.println("Identifiant Entree : "+entreeIdentifiant.getText());
						System.out.println("Mot de Passe Entree : "+entreeMotDePasse.getText());
					}
					else
					{
						testAuthentification(entreeIdentifiant.getText(), entreeMotDePasse.getText());
					}
					entreeIdentifiant.setText("");
					entreeMotDePasse.setText("");
					
				}

				private void testAuthentification(String entreeIdentifiant, String entreeMotDePasse) {
					// TODO Auto-generated method stub
//					BaseDeDonneesApachePOI dataBase = new BaseDeDonneesApachePOI();
					boolean identifiantConnecte = false;
					if(entreeIdentifiant.equals("gerant"/*dataBase.getValueCellule("baseDeDonnees", "login", 1, 1)*/))
					{
						if(entreeMotDePasse.equals("gerant"))
						{
							System.out.println("Connexion pour l'utilisateur : "+entreeIdentifiant);
							identifiantvalide = entreeIdentifiant;
							erreurAuthentification.setText("");
							InterfaceGerant interfaceGerant = new InterfaceGerant(entreeIdentifiant);
							interfaceGerant.initialize();
							interfaceGerant.setLocationRelativeTo(null);
							interfaceGerant.setVisible(true);
							identifiantConnecte = true; //Permet de ne pas rentrer dans les autres else
						}
					}
					else
					{
						if((identifiantConnecte == false))
						{
							erreurAuthentification.setForeground(Color.RED);
							erreurAuthentification.setText("Votre identifiant et/ou Mot de passe sont incorrects");
						}
					}
					
					if(entreeIdentifiant.equals("serveur"/*dataBase.getValueCellule("baseDeDonnees", "login", 1, 1)*/))
					{
						if(entreeMotDePasse.equals("serveur"))
						{
							System.out.println("Connexion pour l'utilisateur : "+entreeIdentifiant);
							identifiantvalide = entreeIdentifiant;
							erreurAuthentification.setText("");
							InterfaceServeur interfaceServeur = new InterfaceServeur(entreeIdentifiant);
							interfaceServeur.initialize();
							interfaceServeur.setLocationRelativeTo(null);
							interfaceServeur.setVisible(true);
							identifiantConnecte = true; //Permet de ne pas rentrer dans les autres else
						}
					}
					else
					{
						if((identifiantConnecte == false))
						{
							erreurAuthentification.setForeground(Color.RED);
							erreurAuthentification.setText("Votre identifiant et/ou Mot de passe sont incorrects");
						}
					}
					
					if(entreeIdentifiant.equals("cuisinier"/*dataBase.getValueCellule("baseDeDonnees", "login", 1, 1)*/))
					{
						if(entreeMotDePasse.equals("cuisinier"))
						{
							System.out.println("Connexion pour l'utilisateur : "+entreeIdentifiant);
							identifiantvalide = entreeIdentifiant;
							erreurAuthentification.setText("");
							InterfaceCuisinier interfaceCuisinier = new InterfaceCuisinier(entreeIdentifiant);
							interfaceCuisinier.initialize();
							interfaceCuisinier.setLocationRelativeTo(null);
							interfaceCuisinier.setVisible(true);
							identifiantConnecte = true; //Permet de ne pas rentrer dans les autres else
						}
					}
					else
					{
						if((identifiantConnecte == false))
						{
							erreurAuthentification.setForeground(Color.RED);
							erreurAuthentification.setText("Votre identifiant et/ou Mot de passe sont incorrects");
						}
					}
					
				}
			});
		}
		return connexion;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Authentification thisClass = new Authentification();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Authentification() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setName("authentification");
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("Authentification");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			erreurAuthentification = new JLabel();
			erreurAuthentification.setText("");
			erreurAuthentification.setLocation(new Point(28, 100));
			erreurAuthentification.setSize(new Dimension(215, 15));
			erreurAuthentification.setFont(new Font("Dialog", Font.ITALIC, 9));
			erreurAuthentification.setVisible(true);
			motDePasse = new JLabel();
			motDePasse.setText("Mot de Passe");
			motDePasse.setLocation(new Point(30, 60));
			motDePasse.setFont(new Font("Dialog", Font.BOLD, 12));
			motDePasse.setSize(new Dimension(80, 30));
			identifiant = new JLabel();
			identifiant.setText("Identifiant");
			identifiant.setLocation(new Point(30, 20));
			identifiant.setPreferredSize(new Dimension(50, 20));
			identifiant.setSize(new Dimension(80, 30));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(identifiant, null);
			jContentPane.add(motDePasse, null);
			jContentPane.add(getEntreeIdentifiant(), null);
			jContentPane.add(getEntreeMotDePasse(), null);
			jContentPane.add(getConnexion(), null);
			jContentPane.add(erreurAuthentification, null);
		}
		return jContentPane;
	}

}
