package process;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.User;

public class ProfilManager {
	
	private User user=null;
	private AddDataVisitor visitor;
	
	public ProfilManager() {
		
	}
	
	public ProfilManager(User user) {
		this.setUser(user);
		this.setVisitor(new AddDataVisitor());
	}
	
	public Boolean inscription(AddDataVisitor visitor,User user) {
		
		Boolean a=false;
		int lenghtUserName=user.getUserName().length();
		int lenghtLastName=user.getLastName().length();
		int lenghtFirstName=user.getFirstName().length();
		int lenghtPassword=user.getPassword().length();
		
		if(lenghtUserName>3 && lenghtLastName>2 && lenghtFirstName>2 && lenghtPassword>4) {
			user.accept(visitor);
			a=true;
		}
		return a;
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

	public AddDataVisitor getVisitor() {
		return visitor;
	}

	public void setVisitor(AddDataVisitor visitor) {
		this.visitor = visitor;
	}

}
