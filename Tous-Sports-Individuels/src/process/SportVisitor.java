package process;

import data.Course;
import data.Cyclisme;
import data.Football;
import data.Natation;
import data.Tennis;
import data.User;

public interface SportVisitor<T> {
	T visit(Course sport);

	T visit(Cyclisme sport);
	
	T visit(Football sport);

	T visit(Natation sport);
	
	T visit(Tennis sport);

	T visit(User User);

}
