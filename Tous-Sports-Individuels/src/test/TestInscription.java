package test;

import java.util.Date;
import java.util.Iterator;

import javax.transaction.Transaction;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import data.Course;
import data.DBConnection;
import data.Inscription;
import process.AddDataVisitor;

public class TestInscription {
	
	public static void main(String[] args) throws Exception {
	    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    

	    sessionFactory.close();
	  }

}
