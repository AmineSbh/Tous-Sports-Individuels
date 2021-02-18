package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Inscription;

public class TestSave {

	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		//Query readQuery = session.createQuery("from Class1");
		//List result = readQuery.list();
		Inscription inscription= new Inscription("a","a","a","a","a");

		session.save(inscription);

		readTransaction.commit();
		session.close();
	}

}
