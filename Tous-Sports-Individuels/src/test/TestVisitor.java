package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Inscription;
import process.AddDataVisitor;
import process.ReadDataVisitor;

public class TestVisitor {

	public static void main(String[] args) {
		AddDataVisitor visitor= new AddDataVisitor();
		Inscription inscription= new Inscription("a","b","c","e","b");
		//inscription.accept(visitor);
		
		ReadDataVisitor visitor2= new ReadDataVisitor("a","b");
		inscription.accept(visitor2);
		

	}

}
