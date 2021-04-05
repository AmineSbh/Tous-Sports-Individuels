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
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import data.Friend;
import data.User;
import data.UserStatic;
import gui.dashboard.DashboardAnalyse;
import process.SocialNetworkManager;
import test.manual.SportValue;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class Analyse1 extends JFrame{

	private JPanel contentPane;
	
	private static final Dimension IDEAL_MAIN_DIMENSION = new Dimension(500, 500);
	private static final Dimension IDEAL_DASHBOARD_DIMENSION = new Dimension(700, 293);

	private DashboardAnalyse dashboard;
	private String[] sports = new String[] {"", "Course", "Cyclisme", "Tennis", "Football","Natation"};
	
	private JComboBox comboBoxData = new JComboBox();
	private JComboBox comboBoxFriend = new JComboBox();
	private JComboBox<String> comboBox_1 = new JComboBox<String>(sports);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Analyse1 window = new Analyse1();
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
	public Analyse1() {
		SocialNetworkManager snm = new SocialNetworkManager();
		UserStatic user = new UserStatic();
		setTitle("Page Analyse");
		setBounds(100, 100, 1004, 685);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Dashboard
		dashboard = new DashboardAnalyse();
		dashboard.setBounds(48, 227,IDEAL_DASHBOARD_DIMENSION.width,
				IDEAL_DASHBOARD_DIMENSION.height);
		contentPane.add(dashboard);
		
		//Data
		comboBoxData.setToolTipText("");
		comboBoxData.setBounds(563, 166, 159, 26);
		contentPane.add(comboBoxData);

		//Sport
		comboBox_1.setBounds(48, 166, 159, 26);
		comboBox_1.addActionListener(new generateDataSport()); 
		comboBox_1.setEnabled(true);
		contentPane.add(comboBox_1);
		
		//Friend
		comboBoxFriend.setToolTipText("");
		comboBoxFriend.setBounds(302, 166, 159, 26);
		comboBoxFriend.addItem("");
		List<Friend> f = snm.getFriendsByUser(user.getInstance());
		Iterator<Friend> iter = f.iterator();
		while (iter.hasNext()) {
		    Friend elt = iter.next(); 
		    if(user.getInstance().getUserName().contains(elt.getUser1().getUserName())) {
		    	comboBoxFriend.addItem(elt.getUser2().getUserName());
		    }else {
		    	comboBoxFriend.addItem(elt.getUser1().getUserName());
		    }
		}
		contentPane.add(comboBoxFriend);
		
		
		//Button
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
		
		//Generate graphic
		JButton btn_Analyse = new JButton("Lancer Analyse");
		btn_Analyse.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn_Analyse.setBounds(784, 162, 161, 38);
		contentPane.add(btn_Analyse);
		btn_Analyse.addActionListener(new generateGraphic());
		
		
		//Label
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
		lblChoixDunAmi.setBounds(280, 130, 239, 20);
		contentPane.add(lblChoixDunAmi);
		lblChoixDunAmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblChoixDeLa = new JLabel("Choix de la cat\u00E9gorie");
		lblChoixDeLa.setForeground(Color.WHITE);
		lblChoixDeLa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChoixDeLa.setBounds(563, 130, 239, 20);
		contentPane.add(lblChoixDeLa);
	}
	
	class generateGraphic implements ActionListener {
		private SocialNetworkManager snm = new SocialNetworkManager();
		 
		public void actionPerformed(ActionEvent evt) {
			dashboard.setEmpty();
			dashboard.setData(comboBoxData.getSelectedItem().toString());
			
			if(!(comboBoxFriend.getSelectedItem() == "")) {
				String userFriend = comboBoxFriend.getSelectedItem().toString();
				User userF = snm.getUser(userFriend).get(0);
				dashboard.setUser(userF);
			}
			dashboard.setSport(comboBox_1.getSelectedItem().toString());
			dashboard.revalidate();
			dashboard.repaint();
		}
	}
	
	class generateDataSport implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if(comboBox_1.getSelectedIndex() == 1) {
				int item = comboBoxData.getItemCount();
				for(int i=0; i<item ; i++) {
					comboBoxData.removeItemAt(0);
				}
				comboBoxData.addItem(SportValue.CourseKilometer);
				comboBoxData.addItem(SportValue.CourseAverageSpeed);
				comboBoxData.addItem(SportValue.CourseMaxSpeed);
			}
			if(comboBox_1.getSelectedIndex() == 2) {
				int item = comboBoxData.getItemCount();
				for(int i=0; i<item ; i++) {
					comboBoxData.removeItemAt(0);
				}
				comboBoxData.addItem(SportValue.CyclismeUphillDistance);
				comboBoxData.addItem(SportValue.CyclismeNumberOfSprint);
				comboBoxData.addItem(SportValue.CyclismeAverageSpeed);
			}
			if(comboBox_1.getSelectedIndex() == 3) {
				int item = comboBoxData.getItemCount();
				for(int i=0; i<item ; i++) {
					comboBoxData.removeItemAt(0);
				}
				comboBoxData.addItem(SportValue.TennisNumberSuccessfulShot);
				comboBoxData.addItem(SportValue.TennisMaxSpeedService);
				comboBoxData.addItem(SportValue.TennisNumberAces);
			}
			if(comboBox_1.getSelectedIndex() == 4) {
				int item = comboBoxData.getItemCount();
				for(int i=0; i<item ; i++) {
					comboBoxData.removeItemAt(0);
				}
				comboBoxData.addItem(SportValue.FoorballNumberSuccessfulPass);
				comboBoxData.addItem(SportValue.Foorballkilometer);
				comboBoxData.addItem(SportValue.FoorballNumberSuccessfulDribble);
			}
			if(comboBox_1.getSelectedIndex() == 5) {
				int item = comboBoxData.getItemCount();
				for(int i=0; i<item ; i++) {
					comboBoxData.removeItemAt(0);
				}
				comboBoxData.addItem(SportValue.NatationDistanceCouléeDepart);
				comboBoxData.addItem(SportValue.NatationNombreMvtBras);
				comboBoxData.addItem(SportValue.NatationTime);
			}
		}			
	}
	
}
