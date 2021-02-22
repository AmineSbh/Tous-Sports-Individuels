package data;

import java.sql.Date;
import javax.persistence.*;

import process.SportVisitor;
import test.manual.SportValue;

@Entity
public class Cyclisme extends Sport{
	private int NumberOfSprint;
	private double UphillDistance;
	private double AverageSpeed;

	public Cyclisme(User user,Date date,int numberofsprint, double uphilldistance, double averagespeed) {
		super(user,SportValue.Cyclisme,date);
		this.setNumberOfSprint(numberofsprint);
		this.setUphillDistance(uphilldistance);
		this.setAverageSpeed(averagespeed);
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public int getNumberOfSprint() {
		return NumberOfSprint;
	}

	public void setNumberOfSprint(int numberOfSprint) {
		NumberOfSprint = numberOfSprint;
	}

	public double getUphillDistance() {
		return UphillDistance;
	}

	public void setUphillDistance(double uphillDistance) {
		UphillDistance = uphillDistance;
	}

	public double getAverageSpeed() {
		return AverageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		AverageSpeed = averageSpeed;
	}
}
