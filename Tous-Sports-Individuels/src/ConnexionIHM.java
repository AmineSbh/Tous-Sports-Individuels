import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ConnexionIHM extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionIHM frame = new ConnexionIHM();
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
	public ConnexionIHM() {
		setResizable(false);
		setBackground(SystemColor.activeCaption);
		setTitle("Tous Sport - Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 334);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tous Sport");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setBounds(138, 26, 231, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vos performances, votre analyse !");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 22));
		lblNewLabel_1.setBounds(47, 56, 397, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Inscription");
		btnNewButton.setBounds(39, 247, 114, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Connexion");
		btnNewButton_1.setBounds(330, 247, 114, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(128, 136, 210, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 169, 210, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Identifiant :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(39, 139, 114, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de passe :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(39, 172, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ins\u00E9rez votre identifiant et mot de passe pour vous connecter");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setBounds(65, 111, 384, 14);
		contentPane.add(lblNewLabel_4);
	}
}
