package gui;
import process.AddDataVisitor;
import process.ProfilManager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import data.User;
import data.UserStatic;

public class InscriptionIHM extends JFrame {

	private JPanel contentPane;
	private JTextField text_Id;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;
	private JTextField text_Nom;
	private JTextField text_Prenom;
	private JTextField text_Mail;
	private ProfilManager pm=new ProfilManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionIHM frame = new InscriptionIHM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InscriptionIHM() {
		setTitle("Tous Sport - Inscription");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 326);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(114, 11, 241, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_Prenom = new JLabel("Pr\u00E9nom :");
		lbl_Prenom.setForeground(Color.WHITE);
		lbl_Prenom.setBounds(22, 96, 66, 14);
		contentPane.add(lbl_Prenom);
		
		JLabel lbl_Mail = new JLabel("Mail :");
		lbl_Mail.setForeground(Color.WHITE);
		lbl_Mail.setBounds(22, 130, 66, 14);
		contentPane.add(lbl_Mail);
		
		JLabel lbl_Identifiant = new JLabel("Identifiant :");
		lbl_Identifiant.setForeground(Color.WHITE);
		lbl_Identifiant.setBounds(22, 155, 94, 14);
		contentPane.add(lbl_Identifiant);
		
		JLabel lbl_mdp = new JLabel("Mot de passe :");
		lbl_mdp.setForeground(Color.WHITE);
		lbl_mdp.setBounds(22, 183, 94, 14);
		contentPane.add(lbl_mdp);
		
		JLabel lblConfirmation = new JLabel("Confirmation mot de passe :");
		lblConfirmation.setForeground(Color.WHITE);
		lblConfirmation.setBounds(22, 211, 177, 14);
		contentPane.add(lblConfirmation);
		
		text_Id = new JTextField();
		text_Id.setBounds(98, 152, 136, 20);
		contentPane.add(text_Id);
		text_Id.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(193, 208, 136, 20);
		contentPane.add(passwordField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(126, 180, 136, 20);
		contentPane.add(passwordField);
		
		text_Nom = new JTextField();
		text_Nom.setBounds(98, 60, 134, 20);
		contentPane.add(text_Nom);
		text_Nom.setColumns(10);
		
		text_Prenom = new JTextField();
		text_Prenom.setBounds(98, 93, 134, 20);
		contentPane.add(text_Prenom);
		text_Prenom.setColumns(10);
		
		text_Mail = new JTextField();
		text_Mail.setBounds(98, 124, 134, 20);
		contentPane.add(text_Mail);
		text_Mail.setColumns(10);
		
		JButton btnInscription = new JButton("S'inscrire");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddDataVisitor visitor= new AddDataVisitor();
				User user = new User(text_Id.getText(),text_Nom.getText() ,text_Prenom.getText(), text_Mail.getText(), passwordField.getText());
				if(pm.inscription(visitor, user)) {
					if(pm.connexion(text_Id.getText(),passwordField.getText())){
					UserStatic userStatic = new UserStatic(pm.getUser());
					PagePrincipale_IHM pageprincipale = new PagePrincipale_IHM();
					pageprincipale.setVisible(true);
					dispose();
					}
					}else {
					JOptionPane.showMessageDialog (null, "Something went Wrong", "Title", JOptionPane.ERROR_MESSAGE);
					text_Nom.setText("");
					text_Prenom.setText("");
					text_Mail.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
				}
				
			}
		});
		btnInscription.setBounds(345, 253, 111, 23);
		contentPane.add(btnInscription);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnexionIHM connexion = new ConnexionIHM();
				connexion.setVisible(true);
				dispose();
			}
		});
		btnRetour.setBounds(22, 253, 111, 23);
		contentPane.add(btnRetour);
		
		JLabel lblNewLabel_7 = new JLabel("Veuillez remplir ce formulaire pour s'inscrire et acc\u00E9der \u00E0 l'application");
		lblNewLabel_7.setForeground(Color.YELLOW);
		lblNewLabel_7.setBounds(47, 38, 376, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lbl_Nom = new JLabel("Nom :");
		lbl_Nom.setForeground(Color.WHITE);
		lbl_Nom.setBounds(22, 63, 66, 14);
		contentPane.add(lbl_Nom);
	}

}
