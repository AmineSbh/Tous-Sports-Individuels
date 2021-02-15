package process;

import data.Course;
import data.Cyclisme;
import data.Football;
import data.Natation;
import data.Tennis;

public interface SportVisitor<T> {
	T visit(Course sport);

	T visit(Cyclisme sport);
	
	T visit(Football sport);

	T visit(Natation sport);
	
	T visit(Tennis sport);

}