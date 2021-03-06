package process;

import org.hibernate.Session;
import org.hibernate.Transaction;
import data.Course;
import data.Cyclisme;
import data.DBConnection;
import data.Football;
import data.Friend;
import data.Natation;
import data.Tennis;
import data.User;

public class AddDataVisitor implements SportVisitor<Void>{

	@Override
	public Void visit(Course sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Cyclisme sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Football sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Natation sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Tennis sport) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(sport);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(User user) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(user);
		readTransaction.commit();
		session.close();
		return null;
	}

	@Override
	public Void visit(Friend friend) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		session.save(friend);
		readTransaction.commit();
		session.close();
		return null;
	}

}
