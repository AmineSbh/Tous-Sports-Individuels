import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class Mesure {

	private JFrame frmPageAnalyse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesure window = new Mesure();
					window.frmPageAnalyse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mesure() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageAnalyse = new JFrame();
		frmPageAnalyse.setTitle("Page Mesure");
		frmPageAnalyse.setBounds(100, 100, 791, 522);
		frmPageAnalyse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageAnalyse.getContentPane().setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(26, 164, 159, 26);
		comboBox_1.addItem(comboBox_1.getSelectedItem());
		frmPageAnalyse.getContentPane().add(comboBox_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(256, 401, 159, 29);
		frmPageAnalyse.getContentPane().add(btnValider);
		
		TextField textPrenom = new TextField();
		textPrenom.setBounds(256, 164, 140, 27);
		frmPageAnalyse.getContentPane().add(textPrenom);
		
		TextField textField = new TextField();
		textField.setBounds(256, 250, 140, 27);
		frmPageAnalyse.getContentPane().add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(256, 340, 140, 27);
		frmPageAnalyse.getContentPane().add(textField_1);
		
		JLabel lblEntrerVosValeurs = new JLabel("Entrer vos valeurs");
		lblEntrerVosValeurs.setBounds(402, 167, 140, 20);
		frmPageAnalyse.getContentPane().add(lblEntrerVosValeurs);
		
		JLabel label = new JLabel("Entrer vos valeurs");
		label.setBounds(402, 250, 140, 20);
		frmPageAnalyse.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Entrer vos valeurs");
		label_1.setBounds(402, 340, 140, 20);
		frmPageAnalyse.getContentPane().add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(26, 28, 641, 42);
		frmPageAnalyse.getContentPane().add(panel);
		
		JLabel lblIciPourrezEntrer = new JLabel("Ici, pourrez entrer vos donn\u00E9es concernant le sport souhait\u00E9.");
		lblIciPourrezEntrer.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(lblIciPourrezEntrer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(26, 111, 193, 37);
		frmPageAnalyse.getContentPane().add(panel_1);
		
		JLabel lblChoisissezVotreSport = new JLabel("Choisissez votre sport");
		lblChoisissezVotreSport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblChoisissezVotreSport);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(570, 398, 161, 38);
		frmPageAnalyse.getContentPane().add(btnRetour_Menu);
	}
}
