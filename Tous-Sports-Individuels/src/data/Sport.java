package data;

import java.util.Date;

import javax.persistence.Id;

import process.SportVisitor;

public abstract class Sport {
	
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
