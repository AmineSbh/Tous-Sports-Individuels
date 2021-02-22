package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long Sport_id;
	
	@ManyToOne
	private User User;
	
	private String Name;

	private Date date;
	
	public Sport(User user,String name, Date date) {
		this.User=user;
		this.Name=name;
		this.setDate(date);
	}

	public abstract <T> T accept(SportVisitor<T> visitor);

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return User;
	}

	public void setUser(User user) {
		User = user;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

}
