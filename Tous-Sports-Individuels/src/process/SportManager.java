package process;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Sport;
import data.User;

public class SportManager {
	
	private Sport sport;
	private AddDataVisitor visitor;
	
	public SportManager() {
		visitor=new AddDataVisitor();
	}
	
	public SportManager(Sport sport) {
		this.setSport(sport);
		this.visitor=new AddDataVisitor();
	}
	
	public Boolean addData(Sport sport) {
		Boolean a=true;
		try {
			sport.accept(visitor);
		}catch(IllegalArgumentException e){
			System.err.println("add data sport failed.");
			a=false;
		}
		return a;
	}
	
	public List<Sport> getAllSport(){
		Session session = DBConnection.getSession();
		List<Sport> sports=null;
		
		//Start the transaction
		Transaction readTransaction = session.beginTransaction();
		
		//get Sport
		/*sports = session.createQuery();
		setUser((User) session.get(User.class, id));
		try {
		session.save(user);

		readTransaction.commit();
		}catch(IllegalArgumentException e){
			e.getMessage();
		}
		
		
		session.close();*/
		return sports;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	

}
