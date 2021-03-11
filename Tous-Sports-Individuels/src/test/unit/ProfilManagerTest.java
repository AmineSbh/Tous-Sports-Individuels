package test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import data.User;
import process.AddDataVisitor;
import process.ProfilManager;

public class ProfilManagerTest {
	
	@Test
	public void testConnexion() {
		ProfilManager pm= new ProfilManager();
		assertTrue(pm.connexion("weezy","aaaaaa"));
	}
	
	@Test
	public void testInscription() {
		AddDataVisitor visitor= new AddDataVisitor();
		ProfilManager pm= new ProfilManager();
		User user = new User("Amine","amine" ,"sabbahi", "Thauvin", "Mandanda");
		assertTrue(pm.inscription(visitor, user));
	}

}
