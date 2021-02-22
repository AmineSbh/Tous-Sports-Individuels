package test;

import java.util.Date;

import data.Course;
import data.Sport;
import data.User;
import process.AddDataVisitor;

public class TestVisitor {

	public static void main(String[] args) {
		AddDataVisitor visitor= new AddDataVisitor();
		User user= new User("a","a","a","a","a");
		Date date= new Date();
		Sport course= new Course(user,date, 5.0, 10.0, 10.0);
		course.accept(visitor);

	}

}
