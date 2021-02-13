package data;

import java.sql.Date;

import process.SportVisitor;

public class Course extends Sport{
	private double kilometer;
	private double MaxSpeed;
	private double AverageSpeed;
	
	public Course(int id, Date date,double kilometer, double maxspeed, double averagespeed) {
		super(id, date);
		this.kilometer=kilometer;
		this.MaxSpeed=maxspeed;
		this.AverageSpeed=averagespeed;
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
