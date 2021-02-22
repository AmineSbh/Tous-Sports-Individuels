package test.unit;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Sport;
import data.User;
import process.AddDataVisitor;

public class SportManagerTest {
	public static void main(String[] args){
	
	//TODO créer un user deja dans la base de donnée
	//Créer un sport et tester si le visteur marche
		
	//Session session = DBConnection.getSession();
	//Transaction readTransaction = session.beginTransaction();
		
	AddDataVisitor visitor= new AddDataVisitor();
	User user= new User("T","a","a","a","a");
	Date date= new Date();
	Sport course= new Course(user,date, 5.0, 11.0, 10.0);
	course.accept(visitor);
	
	/*session.save(course);

	readTransaction.commit();
	session.close();*/
	}
}
