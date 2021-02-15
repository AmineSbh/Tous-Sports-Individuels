package data;

import java.sql.Date;

import process.SportVisitor;

public class Tennis extends Sport{
	private int NumberSuccessfulShot;
	private int MaxSpeedService;

	public Tennis(int id, Date date) {
		super(id, date);
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
