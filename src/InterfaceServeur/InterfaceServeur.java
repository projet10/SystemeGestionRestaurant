package InterfaceServeur;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JButton;


public class InterfaceServeur extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel jContentPane = null;
	public JTextField jTextFieldIdentifiant = null;
	public JLabel jLabel = null;
	public JButton jButtonDeconnexion = null;
	public static String entreeValide;

	/**
	 * @param args
	 */
	//Facilite pour les tests, evite de se logger
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfaceServeur thisClass = new InterfaceServeur(entreeValide);
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
	
	/**
	 * This is the default constructor
	 */
	public InterfaceServeur(String entreeIdentifiant) {
		super();
		entreeValide = entreeIdentifiant;
		System.out.println("Interface Serveur, identifiant : "+entreeValide);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void initialize() {
		this.setSize(800, 600);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	public JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setText("IdConnexion");
			jLabel.setLocation(new Point(420, 20));
			jLabel.setSize(new Dimension(70, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJTextFieldIdentifiant(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(getJButtonDeconnexion(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextFieldIdentifiant	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	public JTextField getJTextFieldIdentifiant() {
		if (jTextFieldIdentifiant == null) {
			jTextFieldIdentifiant = new JTextField();
			jTextFieldIdentifiant.setSize(new Dimension(100, 20));
			jTextFieldIdentifiant.setEditable(false);
			jTextFieldIdentifiant.setLocation(new Point(500, 20));
			jTextFieldIdentifiant.setText(entreeValide);
			System.out.println("Voici l'identifiant connecté : "+entreeValide);
		}
		return jTextFieldIdentifiant;
	}

	/**
	 * This method initializes jButtonDeconnexion	
	 * 	
	 * @return javax.swing.JButton	
	 */
	public JButton getJButtonDeconnexion() {
		if (jButtonDeconnexion == null) {
			jButtonDeconnexion = new JButton();
			jButtonDeconnexion.setText("Deconnexion");
			jButtonDeconnexion.setSize(new Dimension(120, 20));
			jButtonDeconnexion.setLocation(new Point(640, 20));
			jButtonDeconnexion.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Deconnexion de : "+ jTextFieldIdentifiant.getText()); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jButtonDeconnexion;
	}

}
