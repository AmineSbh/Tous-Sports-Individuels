package process;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import data.Course;
import data.Cyclisme;
import data.DBConnection;
import data.Football;
import data.Friend;
import data.FriendStatus;
import data.Natation;
import data.Tennis;
import data.User;

public class DeleteDataVisitor implements SportVisitor<Void>{

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
		Transaction deleteTransaction = session.beginTransaction();
		//String query="from Friend where (UserName1="+"'"+id+"' OR UserName2="+"'"+id+"') ";
		//Query q = session.createQuery(query);
		session.delete(friend);
		deleteTransaction.commit();
		session.close();
		return null;
	}

}
