package gui;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.TextArea;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Analyse {

	private JFrame frmPageAnalyse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analyse window = new Analyse();
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
	public Analyse() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageAnalyse = new JFrame();
		frmPageAnalyse.getContentPane().setBackground(Color.DARK_GRAY);
		frmPageAnalyse.setTitle("Page Analyse");
		frmPageAnalyse.setBounds(100, 100, 749, 531);
		frmPageAnalyse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageAnalyse.getContentPane().setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(36, 198, 159, 26);
		comboBox_1.addItem(comboBox_1.getSelectedItem());
		frmPageAnalyse.getContentPane().add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(353, 198, 159, 26);
		frmPageAnalyse.getContentPane().add(comboBox);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(48, 418, 161, 38);
		frmPageAnalyse.getContentPane().add(btnRetour_Menu);
		
		JLabel label_1 = new JLabel("Tous Sport, le sport pour tous");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(66, 23, 363, 28);
		frmPageAnalyse.getContentPane().add(label_1);
		
		JLabel lblAnalyseDeVos = new JLabel("Analyse de vos statistiques");
		lblAnalyseDeVos.setForeground(Color.WHITE);
		lblAnalyseDeVos.setBounds(64, 67, 260, 23);
		frmPageAnalyse.getContentPane().add(lblAnalyseDeVos);
		lblAnalyseDeVos.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblChoixDuSport = new JLabel("Choix du sport \u00E0 analyser");
		lblChoixDuSport.setForeground(Color.WHITE);
		lblChoixDuSport.setBounds(36, 152, 180, 20);
		frmPageAnalyse.getContentPane().add(lblChoixDuSport);
		lblChoixDuSport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblChoixDunAmi = new JLabel("Choix d'un ami pour comparaison");
		lblChoixDunAmi.setForeground(Color.WHITE);
		lblChoixDunAmi.setBounds(353, 152, 239, 20);
		frmPageAnalyse.getContentPane().add(lblChoixDunAmi);
		lblChoixDunAmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnDonnes = new JButton("Donn\u00E9es 1");
		btnDonnes.setBounds(26, 319, 178, 29);
		frmPageAnalyse.getContentPane().add(btnDonnes);
		
		JButton btnDonnes_1 = new JButton("Donn\u00E9es 2");
		btnDonnes_1.setBounds(261, 319, 191, 29);
		frmPageAnalyse.getContentPane().add(btnDonnes_1);
		
		JButton btnDonnes_2 = new JButton("Donn\u00E9es 3");
		btnDonnes_2.setBounds(490, 319, 222, 29);
		frmPageAnalyse.getContentPane().add(btnDonnes_2);
		
		JButton btn_Analyse = new JButton("Lancer Analyse");
		btn_Analyse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_Analyse.setBounds(418, 418, 161, 38);
		frmPageAnalyse.getContentPane().add(btn_Analyse);
	}
}
