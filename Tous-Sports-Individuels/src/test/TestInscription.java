package test;

import java.util.Date;

import data.Course;
import data.Inscription;
import process.AddDataVisitor;

public class TestInscription {
	
	public static void main(String[] args) {
		AddDataVisitor visitor= new AddDataVisitor();
		Inscription inscription = new Inscription("1","a" ,"a", "a", "a");
		
		inscription.accept(visitor);

	}

}
