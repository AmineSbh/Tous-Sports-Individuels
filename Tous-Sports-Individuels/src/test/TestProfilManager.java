package test;

import process.ProfilManager;

public class TestProfilManager {
	
	private static void testConnexion(ProfilManager pm,String id) {
		if(pm.connexion("a")) {
			System.out.println("connexion reussi");
		}
	}

	public static void main(String[] args) {
		int a;
		ProfilManager pm= new ProfilManager();
		testConnexion(pm,"a");

	}

}
