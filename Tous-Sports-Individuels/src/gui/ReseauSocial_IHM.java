package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Friend;
import data.User;
import data.UserStatic;
import process.SocialNetworkManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class ReseauSocial_IHM extends JFrame {

	private JPanel contentPane;
	private JTextField text_Amis;
	private JTextField text_Supprimer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReseauSocial_IHM frame = new ReseauSocial_IHM();
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
	public ReseauSocial_IHM() {
		SocialNetworkManager snm = new SocialNetworkManager();
		UserStatic user = new UserStatic();
		setTitle("Tous Sport - Reseau Social");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 369);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListeAmis = new JLabel("Liste d'amis");
		lblListeAmis.setForeground(Color.WHITE);
		lblListeAmis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListeAmis.setBounds(40, 91, 104, 25);
		contentPane.add(lblListeAmis);
		
		JComboBox Liste_Amis = new JComboBox();
		Liste_Amis.setBounds(25, 115, 119, 22);
		Liste_Amis.addItem("");
		List<Friend> f = snm.getFriendsByUser(user.getInstance());
		Iterator<Friend> iter = f.iterator();
		while (iter.hasNext()) {
		    Friend elt = iter.next(); 
		    if(user.getInstance().getUserName().contains(elt.getUser1().getUserName())) {
		    	Liste_Amis.addItem(elt.getUser2().getUserName());
		    }else {
		    	Liste_Amis.addItem(elt.getUser1().getUserName());
		    }
		}
		contentPane.add(Liste_Amis);
		
		JLabel lblNewLabel_1 = new JLabel("R\u00E9seau Social Tous Sport");
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(77, 11, 321, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ici vous pouvez g\u00E9rer votre r\u00E9seau de sportif");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(89, 44, 274, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAjoutAmis = new JLabel("Ajouter de nouveaux amis");
		lblAjoutAmis.setForeground(Color.WHITE);
		lblAjoutAmis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAjoutAmis.setBounds(215, 91, 206, 25);
		contentPane.add(lblAjoutAmis);
		
		text_Amis = new JTextField();
		text_Amis.setBounds(214, 116, 184, 20);
		contentPane.add(text_Amis);
		text_Amis.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String usern = new String(text_Amis.getText());
			List<User> username = snm.getUser(usern);
			if(username.isEmpty()) {
				System.out.print("Le nom d'utilisateur est inconnu");
			}else {
				Friend f = new Friend(user.getInstance(), username.get(0));
				snm.Friend_Request(f);
				text_Amis.setText("");
			}
			}
		});
		
		btnAjouter.setBounds(215, 146, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblSupprimerUnAmis = new JLabel("Supprimer un ami");
		lblSupprimerUnAmis.setForeground(Color.WHITE);
		lblSupprimerUnAmis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupprimerUnAmis.setBounds(215, 180, 206, 25);
		contentPane.add(lblSupprimerUnAmis);
		
		text_Supprimer = new JTextField();
		text_Supprimer.setColumns(10);
		text_Supprimer.setBounds(215, 211, 184, 20);
		contentPane.add(text_Supprimer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String userSupp = new String(text_Supprimer.getText());
			List<User> accept1 = snm.getUser(user.getInstance().getUserName());
			List<User> accept2 = snm.getUser(userSupp);
			Friend friend = new Friend(accept1.get(0),accept2.get(0));
			if(snm.Delete_Friend(accept1.get(0),accept2.get(0))) {
				System.out.println("La suppression a marché");
			}else{
				System.out.println("La suppression n'a pas fonctionnée");
			};
			}
		});
		btnSupprimer.setBounds(215, 242, 89, 23);
		contentPane.add(btnSupprimer);
		
		JLabel lblDemandeDamis = new JLabel("Demande d'amis");
		lblDemandeDamis.setForeground(Color.WHITE);
		lblDemandeDamis.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDemandeDamis.setBounds(25, 180, 149, 25);
		contentPane.add(lblDemandeDamis);
		
		List<Friend> f1 = snm.getFriendRequestByUser(user.getInstance());
		JComboBox Demande_Amis = new JComboBox();
		Demande_Amis.setBounds(25, 212, 119, 22);
		Demande_Amis.addItem("");
		Iterator<Friend> iter1 = f1.iterator();
		while (iter1.hasNext()) {
		    Friend elt1 = iter1.next(); 
		    Demande_Amis.addItem(elt1.getUser1().getUserName());
		}
		contentPane.add(Demande_Amis);
		

		JButton btnAccepter = new JButton("Accepter");
		btnAccepter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean a = snm.getAcceptRequest(user.getInstance(), Demande_Amis.getSelectedItem().toString());
				if(a) {
					System.out.print(Demande_Amis.getSelectedItem().toString()+ "Ajout OK");
					Demande_Amis.removeItemAt(Demande_Amis.getSelectedIndex());
				}
			}
		});
		btnAccepter.setBounds(25, 242, 89, 23);
		contentPane.add(btnAccepter);
		
		JButton btnRetour_Menu = new JButton("Retour au menu principal");
		btnRetour_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PagePrincipale_IHM pageprincipale = new PagePrincipale_IHM();
				pageprincipale.setVisible(true);
				dispose();
			}
		});
		btnRetour_Menu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRetour_Menu.setBounds(323, 281, 161, 38);
		contentPane.add(btnRetour_Menu);
	}
}
