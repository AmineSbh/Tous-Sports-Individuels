package process;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Inscription;

public class ProfilManager {
	
	private Inscription inscription=null;
	
	public ProfilManager() {
		
	}
	
	public ProfilManager(Inscription inscription) {
		this.setInscription(inscription);
	}
	
	public Boolean inscription() {
		return null;
	}
	
	public Boolean connexion(String id) {
		Session session = DBConnection.getSession();
		Transaction readTransaction = session.beginTransaction();
		
		inscription= (Inscription) session.get(Inscription.class, id);
		try {
		session.save(inscription);

		readTransaction.commit();
		System.out.println("le mail est "+inscription.getMail());
		}catch(IllegalArgumentException e){
			e.getMessage();
		}
		
		
		session.close();
		
		if(inscription==null) {
			return false;
		}else {
			return true;
		}
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

}
