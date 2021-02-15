package data;

import java.sql.Date;

import process.SportVisitor;

public abstract class Sport {
	
	private int id;
	private Date date;
	
	public Sport(int id,Date date) {
		this.id=id;
		this.date= date;
	}

	public abstract <T> T accept(SportVisitor<T> visitor);

}
