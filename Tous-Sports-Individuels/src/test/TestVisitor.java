package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Sport;
import data.User;
import process.AddDataVisitor;
import process.SportManager;

public class TestVisitor {

	public static void main(String[] args) {
		
		/*Session session = DBConnection.getSession();
		//Transaction readTransaction = session.beginTransaction();
		Query query = session.createQuery("from Course where User_Username = 'weezy'");
		List<Sport> s= query.list();
		for(Sport sport : s){
			System.out.println(sport.getName()+" le nom: "+sport.getUser().getFirstName());
		}*/
		
		SportManager sm= new SportManager();
		List<Sport> s = sm.getSportByUser("weezy", "Course");
		
		for(Sport sport : s){
			System.out.println(sport.getName()+" le nom: "+sport.getUser().getFirstName());
		}

	}

}
