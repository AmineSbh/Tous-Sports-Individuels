package test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Inscription;

public class TestReadData {

	public static void main(String[] args) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		Inscription inscription= null;
		String id="weezy";
		
		inscription= (Inscription) session.get(Inscription.class, id);
		session.save(inscription);

		readTransaction.commit();
		
		System.out.println("Employee ID= "+inscription.getMail());
		session.close();

	}

}
