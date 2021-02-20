package data;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public class User {
	
	@Id
	private String Username;
	private String LastName;
	private String FirstName;
	private String Mail;
	private String Password;
	
	@OneToMany( targetEntity=Sport.class, mappedBy="User" )
	private List<Sport> sports= new ArrayList<>();
	
	@OneToMany( targetEntity=Friend.class, mappedBy="Friend_id" )
	private List<Friend> friends= new ArrayList<>();
	
	public User() {
	}
	
	public User(String username, String lastName,String firstName, String mail,String password) {
		this.Username=username;
		this.LastName=lastName;
		this.FirstName=firstName;
		this.Mail=mail;
		this.Password=password;
	}
	
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		Mail = mail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	

}

