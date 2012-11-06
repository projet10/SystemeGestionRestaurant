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
import java.awt.Font;
import javax.swing.WindowConstants;

public class Authentification extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel identifiant = null;
	private JLabel motDePasse = null;
	private JTextField entreeIdentifiant = null;
	private JTextField entreeMotDePasse = null;
	private JButton valider = null;
	private JLabel erreurAuthentification = null;
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
			entreeIdentifiant.setVisible(true);
			entreeIdentifiant.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
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
			entreeMotDePasse.setLocation(new Point(120, 60));
			entreeMotDePasse.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					entreeMotDePasse.setText("");
					entreeMotDePasse.setForeground(Color.black);
				}
			});
		}
		return entreeMotDePasse;
	}

	/**
	 * This method initializes valider	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getValider() {
		if (valider == null) {
			valider = new JButton();
			valider.setText("Valider");
			valider.setLocation(new Point(90, 120));
			valider.setSize(new Dimension(100, 20));
			valider.setName("Valider");
			valider.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					erreurAuthentification.setText("");
					if((entreeIdentifiant.getText().equals("entrer identifiant")||(entreeMotDePasse.getText().equals("entrer mot de passe"))||(entreeIdentifiant.getText().equals(""))||(entreeMotDePasse.getText().equals(""))))
					{
						erreurAuthentification.setForeground(Color.RED);
						erreurAuthentification.setText("Veuillez entrer votre identifiant et/ou Mot de passe");
						
						System.out.println("Identifiant Entree : "+entreeIdentifiant.getText());
						System.out.println("Mot de Passe Entree : "+entreeMotDePasse.getText());
					}
				}
			});
		}
		return valider;
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
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setName("authentification");
		this.setEnabled(true);
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
			erreurAuthentification.setLocation(new Point(30, 100));
			erreurAuthentification.setSize(new Dimension(210, 15));
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
			jContentPane.add(getValider(), null);
			jContentPane.add(erreurAuthentification, null);
		}
		return jContentPane;
	}

}
