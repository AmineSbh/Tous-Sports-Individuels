import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class InscriptionIHM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(114, 11, 241, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(22, 96, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mail :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(22, 130, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Identifiant :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(22, 155, 94, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mot de passe :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(22, 183, 94, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Confirmation mot de passe :");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(22, 211, 177, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(98, 152, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(193, 208, 136, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(126, 180, 136, 20);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 60, 134, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 93, 134, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(98, 124, 134, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setBounds(345, 253, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.setBounds(22, 253, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Veuillez remplir ce formulaire pour s'inscrire et acc\u00E9der \u00E0 l'application");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(47, 38, 376, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nom :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(22, 63, 66, 14);
		contentPane.add(lblNewLabel_2_1);
	}

}
