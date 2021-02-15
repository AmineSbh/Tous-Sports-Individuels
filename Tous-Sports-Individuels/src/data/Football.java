package data;

import java.sql.Date;

import process.SportVisitor;

public class Football extends Sport{
	private int NumberSuccessfulPass;
	private double kilometer;
	private int NumberSuccessfulDribble;
	
	public Football(int id, Date date, int numberpass, double kilometer,int numberdribble) {
		super(id, date);
		this.NumberSuccessfulPass=numberpass;
		this.kilometer=kilometer;
		this.NumberSuccessfulDribble=numberdribble;
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
