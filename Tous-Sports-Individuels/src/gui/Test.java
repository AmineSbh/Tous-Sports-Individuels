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

import gui.dashboard.DashboardAnalyse;
import test.manual.SportValue;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;

public class Test extends JFrame{

	private JPanel contentPane;
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(500, 500);
	public static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(700,293);

	private DashboardAnalyse dashboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		setTitle("Page Analyse");
		setBounds(100, 100, 1004, 685);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(48, 166, 159, 26);
		comboBox_1.addItem(comboBox_1.getSelectedItem());
		contentPane.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(302, 166, 159, 26);
		contentPane.add(comboBox);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
		btnRetour_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagePrincipale_IHM page = new PagePrincipale_IHM();
				page.setVisible(true);
				dispose();
			}
		});
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(25, 555, 161, 38);
		contentPane.add(btnRetour_Menu);
		
		JLabel label_1 = new JLabel("Tous Sport, le sport pour tous");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		label_1.setBounds(66, 23, 363, 28);
		contentPane.add(label_1);
		
		JLabel lblAnalyseDeVos = new JLabel("Analyse de vos statistiques");
		lblAnalyseDeVos.setForeground(Color.WHITE);
		lblAnalyseDeVos.setBounds(64, 67, 260, 23);
		contentPane.add(lblAnalyseDeVos);
		lblAnalyseDeVos.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblChoixDuSport = new JLabel("Choix du sport \u00E0 analyser");
		lblChoixDuSport.setForeground(Color.WHITE);
		lblChoixDuSport.setBounds(48, 130, 180, 20);
		contentPane.add(lblChoixDuSport);
		lblChoixDuSport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblChoixDunAmi = new JLabel("Choix d'un ami pour comparaison");
		lblChoixDunAmi.setForeground(Color.WHITE);
		lblChoixDunAmi.setBounds(292, 130, 239, 20);
		contentPane.add(lblChoixDunAmi);
		lblChoixDunAmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		dashboard = new DashboardAnalyse();
		dashboard.setBounds(48, 227,IDEAL_DASHBOARD_DIMENSION.width,
				IDEAL_DASHBOARD_DIMENSION.height);
		contentPane.add(dashboard);
		
		JButton btn_Analyse = new JButton("Lancer Analyse");
		btn_Analyse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dashboard.setEmpty();
				dashboard.setData(SportValue.CourseKilometer);
				dashboard.setSport("Course");
				dashboard.revalidate();
				dashboard.repaint();
			}
		});
		btn_Analyse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_Analyse.setBounds(784, 162, 161, 38);
		contentPane.add(btn_Analyse);
		
		
	}
}
