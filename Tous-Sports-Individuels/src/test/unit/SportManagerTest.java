package test.unit;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import data.Course;
import data.DBConnection;
import data.Sport;
import data.User;
import process.AddDataVisitor;
import process.ProfilManager;
import process.SportManager;

public class SportManagerTest {
	
	@Test
	public void testAddDataSport() {
		User user= new User("weezy","a","a","a","aaaaaa");//user existant
		Date date= new Date();
		Sport course= new Course(user,date, 6.0, 10.0, 10.0);
		SportManager sm= new SportManager();
		assertTrue(sm.addData(course));
	}
		
	
}
