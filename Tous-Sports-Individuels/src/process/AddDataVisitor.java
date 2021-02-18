package process;

import org.hibernate.Session;

import data.Course;
import data.Cyclisme;
import data.Football;
import data.HibernateUtil;
import data.Natation;
import data.Tennis;

public class AddDataVisitor implements SportVisitor<Void>{

	@Override
	public Void visit(Course sport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Cyclisme sport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Football sport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Natation sport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Tennis sport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

}
