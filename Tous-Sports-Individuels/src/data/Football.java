package data;

import java.sql.Date;
import javax.persistence.*;

import process.SportVisitor;

public class Football extends Sport{
	private int NumberSuccessfulPass;
	private double kilometer;
	private int NumberSuccessfulDribble;
	
	public Football(Date date, int numberpass, double kilometer,int numberdribble) {
		super(date);
		this.setNumberSuccessfulPass(numberpass);
		this.setKilometer(kilometer);
		this.setNumberSuccessfulDribble(numberdribble);
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public int getNumberSuccessfulPass() {
		return NumberSuccessfulPass;
	}

	public void setNumberSuccessfulPass(int numberSuccessfulPass) {
		NumberSuccessfulPass = numberSuccessfulPass;
	}

	public double getKilometer() {
		return kilometer;
	}

	public void setKilometer(double kilometer) {
		this.kilometer = kilometer;
	}

	public int getNumberSuccessfulDribble() {
		return NumberSuccessfulDribble;
	}

	public void setNumberSuccessfulDribble(int numberSuccessfulDribble) {
		NumberSuccessfulDribble = numberSuccessfulDribble;
	}

}
