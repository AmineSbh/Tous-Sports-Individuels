package data;

import java.sql.Date;

import process.SportVisitor;

public class Cyclisme extends Sport{
	private int NumberOfSprint;
	private double UphillDistance;
	private double AverageSpeed;

	public Cyclisme(int id, Date date,int numberofsprint, double uphilldistance, double averagespeed) {
		super(id, date);
		this.NumberOfSprint=numberofsprint;
		this.UphillDistance=uphilldistance;
		this.AverageSpeed=averagespeed;
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
