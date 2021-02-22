package test.unit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Inscription;
import data.Sport;
import data.User;

public class SportManagerTest {
	public static void main(String[] args){
	Session session = DBConnection.getSession();
	Transaction readTransaction = session.beginTransaction();

	User user= new User("a","a","a","a","a");
	Date date= new Date();
	Sport course= new Course(user,date, 5.0, 10.0, 10.0);
	
	session.save(course);

	readTransaction.commit();
	session.close();
	}
}
