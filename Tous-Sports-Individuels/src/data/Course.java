package data;

import java.util.Date;

import process.SportVisitor;

public class Course extends Sport{
	private double kilometer;
	private double MaxSpeed;
	private double AverageSpeed;
	
	public Course(Date date,double kilometer, double maxspeed, double averagespeed) {
		super(date);
		this.setKilometer(kilometer);
		this.setMaxSpeed(maxspeed);
		this.setAverageSpeed(averagespeed);
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}

	public double getMaxSpeed() {
		return MaxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		MaxSpeed = maxSpeed;
	}

	public double getAverageSpeed() {
		return AverageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		AverageSpeed = averageSpeed;
	}

}
