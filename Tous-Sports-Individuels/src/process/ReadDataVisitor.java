package process;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

import data.Course;
import data.Cyclisme;
import data.DBConnection;
import data.Football;
import data.Inscription;
import data.Natation;
import data.Tennis;

public class ReadDataVisitor implements SportVisitor<Void>{
	private int Id_Sport;
	private String Id_Inscription;
	private String Mdp;
	
	public ReadDataVisitor(int id) {
		this.Id_Sport=id;
	}
	
	public ReadDataVisitor(String id, String mdp) {
		this.Id_Inscription=id;
		this.Mdp=mdp;
	}

	@Override
	public Void visit(Course sport) {
		
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
	public Void visit(Inscription inscription){
		Session session = DBConnection.getSession();
		
		Query query = session.createQuery("from Inscription where id=:id1 AND mdp=:mdp1");
	      query.setString("id1",this.Id_Inscription);
	      query.setString("mdp1",this.Mdp);
	      //Iterator insc = query.iterate();
		List result = query.list();
		Inscription class1 = (Inscription) result.get(0);
		System.out.println(class1.getId());
	      
	      /*if(insc.hasNext()) {
	        //Inscription i= (Inscription) insc.next();
	        System.out.println("Connexion OK = ");
	      }*/

		return null;
	}
}
