package gui;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class Mesure1 extends JFrame {

	private JPanel contentPane;


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
		
		JLabel lblNewLabel = new JLabel("Tous Sport, le sport pour tous");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(96, 11, 363, 28);
		contentPane.add(lblNewLabel);
		
		String[] sports = new String[] {"", "Course", "Cyclisme", "Tennis", "Football","Natation"};
		JComboBox<String> comboBox_1 = new JComboBox<String>(sports);
		comboBox_1.setBounds(26, 164, 159, 26);
		comboBox_1.setEnabled(true);
		contentPane.add(comboBox_1);

		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(256, 401, 159, 29);
		contentPane.add(btnValider);
		
		TextField text_v0 = new TextField();
		text_v0.setBounds(256, 164, 140, 27);
		contentPane.add(text_v0);
		
		TextField text_v1 = new TextField();
		text_v1.setBounds(256, 250, 140, 27);
		contentPane.add(text_v1);
		
		TextField text_v2 = new TextField();
		text_v2.setBounds(256, 340, 140, 27);
		contentPane.add(text_v2);
		
		JLabel label_1 = new JLabel("Entrer valeurs");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(402, 167, 193, 20);
		contentPane.add(label_1);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
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
		
		JLabel lblIciPourrezEntrer = new JLabel("Ici, pourrez entrer vos donn\u00E9es concernant le sport souhait\u00E9.");
		lblIciPourrezEntrer.setForeground(Color.WHITE);
		lblIciPourrezEntrer.setBounds(26, 55, 584, 23);
		contentPane.add(lblIciPourrezEntrer);
		lblIciPourrezEntrer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEntrerValeurs = new JLabel("Entrer valeurs");
		lblEntrerValeurs.setForeground(Color.WHITE);
		lblEntrerValeurs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEntrerValeurs.setBounds(402, 257, 208, 20);
		contentPane.add(lblEntrerValeurs);
		
		JLabel lblEntrerValeurs_1 = new JLabel("Entrer valeurs");
		lblEntrerValeurs_1.setForeground(Color.WHITE);
		lblEntrerValeurs_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEntrerValeurs_1.setBounds(402, 347, 208, 20);
		contentPane.add(lblEntrerValeurs_1);
		
		JLabel lblNewLabel_1 = new JLabel("Choisissez votre sport");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(26, 100, 217, 38);
		contentPane.add(lblNewLabel_1);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getSelectedIndex() == 1) {
					label_1.setText("kilomètres parcourus");
					lblEntrerValeurs.setText("Vitesse maximale");
					lblEntrerValeurs_1.setText("Vitesse Moyenne");
				}
				if(comboBox_1.getSelectedIndex() == 2) {
					label_1.setText("Nombre de sprint");
					lblEntrerValeurs.setText("uphill distance");
					lblEntrerValeurs_1.setText("Vitesse Moyenne");
				}
				if(comboBox_1.getSelectedIndex() == 3) {
					label_1.setText("Nombre de tir réussi");
					lblEntrerValeurs.setText("Vitesse maximum Service");
					lblEntrerValeurs_1.setText("Nombre de Ace");
				}
				if(comboBox_1.getSelectedIndex() == 4) {
					label_1.setText("Nombre de passe réussi");
					lblEntrerValeurs.setText("Kilometre parcouru");
					lblEntrerValeurs_1.setText("Nb de drible réussi");
				}
				if(comboBox_1.getSelectedIndex() == 5) {
					label_1.setText("Distance de coulée départ");
					lblEntrerValeurs.setText("Nombre de mvt de bras");
					lblEntrerValeurs_1.setText("Temps sur 100 m");
				}
			}
		});
		
		AddDataVisitor visitor= new AddDataVisitor();
		UserStatic user = new UserStatic();
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(text_v0 != null & text_v1 != null & text_v2 != null) {
					if(comboBox_1.getSelectedIndex() == 1) {
						Date date= new Date();
						Sport course= new Course(user.getInstance(),date, Integer.valueOf(text_v0.getText()), Integer.valueOf(text_v1.getText()), Integer.valueOf(text_v2.getText()));
						course.accept(visitor);
					}
					if(comboBox_1.getSelectedIndex() == 2) {
						Date date= new Date();
						Sport cyclisme= new Cyclisme(user.getInstance(),date, Integer.valueOf(text_v0.getText()), Integer.valueOf(text_v1.getText()), Integer.valueOf(text_v2.getText()));
						cyclisme.accept(visitor);
					}
					if(comboBox_1.getSelectedIndex() == 3) {
						Date date= new Date();
						Sport tennis= new Tennis(user.getInstance(),date, Integer.valueOf(text_v0.getText()), Integer.valueOf(text_v1.getText()), Integer.valueOf(text_v2.getText()));
						tennis.accept(visitor);
					}
					if(comboBox_1.getSelectedIndex() == 4) {
						Date date= new Date();
						Sport football= new Football(user.getInstance(),date, Integer.valueOf(text_v0.getText()), Integer.valueOf(text_v1.getText()), Integer.valueOf(text_v2.getText()));
						football.accept(visitor);
					}
					if(comboBox_1.getSelectedIndex() == 5) {
						Date date= new Date();
						Sport natation= new Natation(user.getInstance(),date, Integer.valueOf(text_v0.getText()), Integer.valueOf(text_v1.getText()), Integer.valueOf(text_v2.getText()));
						natation.accept(visitor);
					}
				}
				text_v0.setText("");
				text_v1.setText("");
				text_v2.setText("");
			}
		});
		
	}
}
