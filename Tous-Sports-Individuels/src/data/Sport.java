package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;

@MappedSuperclass
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "Name","UserName" }) })
public abstract class Sport {
	
	@Id
	private String Name;
	
	 @Id
	 @ManyToOne
	    @JoinColumn(name="Username", nullable=false)
	    private User User;

	private Date date;
	
	public Sport(User user, Date date) {
		this.User=user;
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

}
