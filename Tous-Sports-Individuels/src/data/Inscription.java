package data;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public class Inscription {
	
	@Id
	private String Id;
	private String Nom;
	private String Prenom;
	private String Mail;
	private String Mdp;
	
	public Inscription(String id, String nom,String prenom, String mail,String mdp) {
		this.Id=id;
		this.Nom=nom;
		this.Prenom=prenom;
		this.Mail=mail;
		this.Mdp=mdp;
	}
	
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMdp() {
		return Mdp;
	}
	public void setMdp(String mdp) {
		Mdp = mdp;
	}

}
