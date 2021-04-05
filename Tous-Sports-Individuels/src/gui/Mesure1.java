package gui;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import data.Course;
import data.Cyclisme;
import data.Football;
import data.Natation;
import data.Sport;
import data.Tennis;
import data.User;
import data.UserStatic;
import process.AddDataVisitor;
import process.SocialNetworkManager;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class Mesure1 extends JFrame {

	private JPanel contentPane;
	
	String[] sports = new String[] {"", "Course", "Cyclisme", "Tennis", "Football","Natation"};
	
	//Jlabel
	JLabel labelTitle = new JLabel("Tous Sport, le sport pour tous");
	JLabel value1 = new JLabel("Entrer valeurs");
	JLabel value2 = new JLabel("Entrer valeurs");
	JLabel value3 = new JLabel("Entrer valeurs");
	
	//JComboBox
	JComboBox<String> comboBoxSportList = new JComboBox<String>(sports);
	
	//Jbutton
	JButton btnValidate = new JButton("Valider");
	JButton btnRetour_Menu = new JButton("Retour au menu principal");

	//TextField
	TextField field1 = new TextField();
	TextField field2 = new TextField();
	TextField field3 = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mesure1 frame = new Mesure1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mesure1() {
		setTitle("Page Mesure");
		setBounds(100, 100, 791, 522);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLabel
		labelTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		labelTitle.setForeground(Color.YELLOW);
		labelTitle.setBounds(96, 11, 363, 28);
		contentPane.add(labelTitle);
		
		value3.setForeground(Color.WHITE);
		value3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		value3.setBounds(402, 347, 208, 20);
		contentPane.add(value3);
		
		value2.setForeground(Color.WHITE);
		value2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		value2.setBounds(402, 257, 208, 20);
		contentPane.add(value2);
		
		value1.setForeground(Color.WHITE);
		value1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		value1.setBounds(402, 167, 193, 20);
		contentPane.add(value1);
		
		JLabel lblNewLabel_1 = new JLabel("Choisissez votre sport");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(26, 100, 217, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblIciPourrezEntrer = new JLabel("Ici, pourrez entrer vos donn\u00E9es concernant le sport souhait\u00E9.");
		lblIciPourrezEntrer.setForeground(Color.WHITE);
		lblIciPourrezEntrer.setBounds(26, 55, 584, 23);
		contentPane.add(lblIciPourrezEntrer);
		lblIciPourrezEntrer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		
		//ComboBox
		comboBoxSportList.setBounds(26, 164, 159, 26);
		comboBoxSportList.setEnabled(true);
		contentPane.add(comboBoxSportList);

		//Jbutton
		btnValidate.setBounds(256, 401, 159, 29);
		contentPane.add(btnValidate);
		btnValidate.addActionListener(new addData());
		
		btnRetour_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagePrincipale_IHM page = new PagePrincipale_IHM();
				page.setVisible(true);
				dispose();
			}
		});
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(570, 398, 161, 38);
		contentPane.add(btnRetour_Menu);
		
		
		//TextFields
		field1.setBounds(256, 164, 140, 27);
		/*field1.addKeyListener(new KeyAdapter() {
			@Override 
			public void keyPressed(KeyEvent e) {
				try {
					int i = Integer.parseInt(field1.getText());
					value1.setText("Entrer valeurs");
				} catch (NumberFormatException e1) {
					value1.setText("Mauvais format");
				}
			}
		});*/
		contentPane.add(field1);
		
		field2.setBounds(256, 250, 140, 27);
		contentPane.add(field2);
		
		field3.setBounds(256, 340, 140, 27);
		contentPane.add(field3);		
		
		
		comboBoxSportList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxSportList.getSelectedIndex() == 1) {
					value3.setText("kilomètres parcourus");
					value1.setText("Vitesse maximale");
					value2.setText("Vitesse Moyenne");
				}
				if(comboBoxSportList.getSelectedIndex() == 2) {
					value3.setText("Nombre de sprint");
					value1.setText("uphill distance");
					value2.setText("Vitesse Moyenne");
				}
				if(comboBoxSportList.getSelectedIndex() == 3) {
					value3.setText("Nombre de tir réussi");
					value1.setText("Vitesse maximum Service");
					value2.setText("Nombre de Ace");
				}
				if(comboBoxSportList.getSelectedIndex() == 4) {
					value3.setText("Nombre de passe réussi");
					value1.setText("Kilometre parcouru");
					value2.setText("Nb de drible réussi");
				}
				if(comboBoxSportList.getSelectedIndex() == 5) {
					value3.setText("Distance de coulée départ");
					value1.setText("Nombre de mvt de bras");
					value2.setText("Temps sur 100 m");
				}
			}
		});
		
		
		
		
	}
	
	class addData implements ActionListener {
		private AddDataVisitor visitor= new AddDataVisitor();
		UserStatic user = new UserStatic();
		 
		public void actionPerformed(ActionEvent arg0) {
			if(field1 != null & field2 != null & field3 != null) {
				if(comboBoxSportList.getSelectedIndex() == 1) {
					Date date= new Date();
					Sport course= new Course(user.getInstance(),date, Integer.valueOf(field1.getText()), 
							Integer.valueOf(field2.getText()), Integer.valueOf(field3.getText()));
					course.accept(visitor);
				}
				if(comboBoxSportList.getSelectedIndex() == 2) {
					Date date= new Date();
					Sport cyclisme= new Cyclisme(user.getInstance(),date, Integer.valueOf(field1.getText()), 
							Integer.valueOf(field2.getText()), Integer.valueOf(field3.getText()));
					cyclisme.accept(visitor);
				}
				if(comboBoxSportList.getSelectedIndex() == 3) {
					Date date= new Date();
					Sport tennis= new Tennis(user.getInstance(),date, Integer.valueOf(field1.getText()), 
							Integer.valueOf(field2.getText()), Integer.valueOf(field3.getText()));
					tennis.accept(visitor);
				}
				if(comboBoxSportList.getSelectedIndex() == 4) {
					Date date= new Date();
					Sport football= new Football(user.getInstance(),date, Integer.valueOf(field1.getText()), 
							Integer.valueOf(field2.getText()), Integer.valueOf(field3.getText()));
					football.accept(visitor);
				}
				if(comboBoxSportList.getSelectedIndex() == 5) {
					Date date= new Date();
					Sport natation= new Natation(user.getInstance(),date, Integer.valueOf(field1.getText()), 
							Integer.valueOf(field2.getText()), Integer.valueOf(field3.getText()));
					natation.accept(visitor);
				}
			}
			field1.setText("");
			field2.setText("");
			field3.setText("");
		}
	}
	
	
}
