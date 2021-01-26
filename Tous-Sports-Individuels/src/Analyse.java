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
		frmPageAnalyse.setTitle("Page Analyse");
		frmPageAnalyse.setBounds(100, 100, 791, 585);
		frmPageAnalyse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageAnalyse.getContentPane().setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(499, 76, 159, 26);
		comboBox_1.addItem(comboBox_1.getSelectedItem());
		frmPageAnalyse.getContentPane().add(comboBox_1);
		
		Panel panel = new Panel();
		panel.setBounds(26, 76, 447, 443);
		frmPageAnalyse.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMoyenneParJour = new JLabel("Moyenne \r\n/ jour");
		lblMoyenneParJour.setBounds(330, 34, 122, 37);
		panel.add(lblMoyenneParJour);
		
		JLabel label = new JLabel("Moyenne \r\n/ jour");
		label.setBounds(330, 161, 122, 37);
		panel.add(label);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(499, 387, 159, 29);
		frmPageAnalyse.getContentPane().add(btnValider);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(499, 246, 159, 26);
		frmPageAnalyse.getContentPane().add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(26, 16, 423, 42);
		frmPageAnalyse.getContentPane().add(panel_1);
		
		JLabel lblAnalyseDeVos = new JLabel("Analyse de vos statistiques");
		lblAnalyseDeVos.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel_1.add(lblAnalyseDeVos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(499, 23, 233, 37);
		frmPageAnalyse.getContentPane().add(panel_2);
		
		JLabel lblChoixDuSport = new JLabel("Choix du sport \u00E0 analyser");
		lblChoixDuSport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblChoixDuSport);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(499, 204, 255, 37);
		frmPageAnalyse.getContentPane().add(panel_3);
		
		JLabel lblChoixDunAmi = new JLabel("Choix d'un ami pour comparaison");
		lblChoixDunAmi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblChoixDunAmi);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(593, 461, 161, 38);
		frmPageAnalyse.getContentPane().add(btnRetour_Menu);
	}
}
