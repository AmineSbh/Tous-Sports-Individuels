import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class PagePrincipale_IHM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagePrincipale_IHM frame = new PagePrincipale_IHM();
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
	public PagePrincipale_IHM() {
		setTitle("Tous Sport - Page principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 324);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tous Sport, le sport pour tous");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(96, 11, 363, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mesurer ses");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(25, 84, 107, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Performances");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(20, 109, 107, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnMesurer = new JButton("Mesurer");
		btnMesurer.setBounds(25, 143, 100, 34);
		contentPane.add(btnMesurer);
		
		JLabel lblNewLabel_1_2 = new JLabel("Analyser ses performances");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(142, 95, 196, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnAnalyser = new JButton("Analyser");
		btnAnalyser.setBounds(175, 143, 129, 34);
		contentPane.add(btnAnalyser);
		
		JButton btnReseau = new JButton("R\u00E9seau");
		btnReseau.setBounds(355, 143, 100, 34);
		contentPane.add(btnReseau);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("R\u00E9seau Social");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(355, 95, 146, 34);
		contentPane.add(lblNewLabel_1_2_1);
		
		JButton btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(25, 239, 118, 23);
		contentPane.add(btnDeconnexion);
		
		JLabel lblNewLabel_2 = new JLabel("Choississez votre rubrique");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(128, 42, 363, 31);
		contentPane.add(lblNewLabel_2);
	}

}
