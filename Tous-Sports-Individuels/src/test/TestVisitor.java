package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import data.Course;
import process.AddDataVisitor;

public class TestVisitor {

	public static void main(String[] args) {
		AddDataVisitor visitor= new AddDataVisitor();
		
		Date date = new Date();
		
		Course course= new Course(date,7.2,15.1,11.1);
		
		course.accept(visitor);

	}

}
