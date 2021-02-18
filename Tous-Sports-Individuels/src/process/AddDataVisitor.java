package process;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import data.Course;
import data.Cyclisme;
import data.Football;
import data.HibernateUtil;
import data.Inscription;
import data.Natation;
import data.Tennis;

public class AddDataVisitor implements SportVisitor<Void>{
	
	private SessionFactory sessionFactory;
	
	public AddDataVisitor() {
		
		try {
			this.setSessionFactory(new Configuration().configure().buildSessionFactory());
		}catch (Throwable ex) {
			System.out.println("echec");
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public Void visit(Course sport) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Cyclisme sport) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Football sport) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Natation sport) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Tennis sport) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(sport);
		session.getTransaction().commit();
		return null;
	}

	@Override
	public Void visit(Inscription inscription) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(inscription);
		session.getTransaction().commit();
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
