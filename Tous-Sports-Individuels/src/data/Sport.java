package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public abstract class Sport {
	
	@Id
	private Integer id;
	private Date date;
	
	public Sport(Date date) {
		this.setDate(date);
	}

	public abstract <T> T accept(SportVisitor<T> visitor);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
