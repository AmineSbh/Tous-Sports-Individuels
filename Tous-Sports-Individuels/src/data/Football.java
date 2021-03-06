package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;
import test.manual.SportValue;

@Entity
public class Football extends Sport{
	private int NumberSuccessfulPass;
	private double kilometer;
	private int NumberSuccessfulDribble;
	
	public Football(User user,Date date, int numberpass, double kilometer,int numberdribble) {
		super(user,SportValue.Football,date);
		this.setNumberSuccessfulPass(numberpass);
		this.setKilometer(kilometer);
		this.setNumberSuccessfulDribble(numberdribble);
	}

	public Football() {
		// TODO Auto-generated constructor stub
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
