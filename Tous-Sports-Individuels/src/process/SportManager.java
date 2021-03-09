package process;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Sport;
import data.User;
import test.manual.SportValue;

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
	
	public List<Sport> getSportByUser(String username, String sport) {
		List<Sport> sports=null;
		String query ="";
		
		switch (sport) {
		case SportValue.Course:
			query="from "+SportValue.Course+" where User_Username="+"'"+username+"'";
			break;

		case SportValue.Cyclisme:
			query="from "+SportValue.Cyclisme+" where User_Username="+"'"+username+"'";
			break;

		case SportValue.Football:
			query="from "+SportValue.Football+" where User_Username="+"'"+username+"'";
			break;

		case SportValue.Natation:
			query="from "+SportValue.Natation+" where User_Username="+"'"+username+"'";
			break;
		
		case SportValue.Tennis:
			query="from "+SportValue.Tennis+" where User_Username="+"'"+username+"'";
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + sport);
		}
		
		//get sport object
		if(query!=null) {
			Session session = DBConnection.getSession();
			Query q = session.createQuery(query);
			sports= q.list();
			session.close();
		}
		
		return sports;
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
