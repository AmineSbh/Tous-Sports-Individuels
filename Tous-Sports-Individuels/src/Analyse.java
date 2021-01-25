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

public class Analyse {

	private JFrame frmPageAnalyse;
	private JTextField txtAnalyseDeVos;
	private JTextField txtChoixDuSport;
	private JTextField txtChoixDunAmis;

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
		frmPageAnalyse.setBounds(100, 100, 791, 522);
		frmPageAnalyse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPageAnalyse.getContentPane().setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("");
		comboBox_1.setBounds(499, 76, 159, 26);
		comboBox_1.addItem(comboBox_1.getSelectedItem());
		frmPageAnalyse.getContentPane().add(comboBox_1);
		
		Panel panel = new Panel();
		panel.setBounds(26, 76, 447, 364);
		frmPageAnalyse.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMoyenneParJour = new JLabel("Moyenne \r\n/ jour");
		lblMoyenneParJour.setBounds(330, 34, 122, 37);
		panel.add(lblMoyenneParJour);
		
		JLabel label = new JLabel("Moyenne \r\n/ jour");
		label.setBounds(330, 147, 122, 37);
		panel.add(label);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnValider.setBounds(554, 411, 159, 29);
		frmPageAnalyse.getContentPane().add(btnValider);
		
		txtAnalyseDeVos = new JTextField();
		txtAnalyseDeVos.setText("Analyse de vos statistiques");
		txtAnalyseDeVos.setBounds(26, 16, 291, 44);
		frmPageAnalyse.getContentPane().add(txtAnalyseDeVos);
		txtAnalyseDeVos.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setBounds(499, 246, 159, 26);
		frmPageAnalyse.getContentPane().add(comboBox);
		
		txtChoixDuSport = new JTextField();
		txtChoixDuSport.setText("Choix du sport \u00E0 analyser");
		txtChoixDuSport.setColumns(10);
		txtChoixDuSport.setBounds(499, 33, 208, 37);
		frmPageAnalyse.getContentPane().add(txtChoixDuSport);
		
		txtChoixDunAmis = new JTextField();
		txtChoixDunAmis.setText("Choix d'un amis pour comparaison");
		txtChoixDunAmis.setColumns(10);
		txtChoixDunAmis.setBounds(499, 203, 255, 37);
		frmPageAnalyse.getContentPane().add(txtChoixDunAmis);
	}
}
