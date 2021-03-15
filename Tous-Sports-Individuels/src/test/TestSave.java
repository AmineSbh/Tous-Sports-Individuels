package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Sport;
import data.User;

public class TestSave {

	public static void main(String[] args) {
		/*Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		//Query readQuery = session.createQuery("from Class1");
		//List result = readQuery.list();
		Inscription inscription= new Inscription("a","a","a","a","a");

		session.save(inscription);

		readTransaction.commit();
		session.close();
		
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();

		User user= new User("a","a","a","a","a");
		Date date= new Date();
		Sport course= new Course(user,date, 5.0, 10.0, 10.0);
		
		session.save(course);

		readTransaction.commit();
		session.close();*/
		ArrayList list = new ArrayList<Double>();
		list.add(11.0);
		list.add(12.0);
		Object[] obj = list.toArray();

		double[] values = new double[obj.length];
		for(int i=0; i < values.length; i++) {
		  //Convertir les objets en int
			values[i]=(double) obj[i];
		}
		
		for(int i=0; i < values.length; i++) {
			  //Convertir les objets en int
				System.out.println(values[i]);
			}
	}

}
