package process;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Inscription;
import data.User;

public class ProfilManager {
	
	private User user=null;
	
	public ProfilManager() {
		
	}
	
	public ProfilManager(User user) {
		this.setUser(user);
	}
	
	public Boolean inscription() {
		return null;
	}
	
	public Boolean connexion(String id) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		setUser((User) session.get(User.class, id));
		try {
		session.save(user);

		readTransaction.commit();
		System.out.println("le mail est "+user.getMail());
		}catch(IllegalArgumentException e){
			e.getMessage();
		}
		
		
		session.close();
		
		if(user==null) {
			return false;
		}else {
			return true;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
