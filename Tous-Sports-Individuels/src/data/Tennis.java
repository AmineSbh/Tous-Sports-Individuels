package data;

import java.util.Date;
import javax.persistence.*;

import process.SportVisitor;
import test.manual.SportValue;

@Entity
public class Tennis extends Sport{
	private int NumberSuccessfulShot;
	private int MaxSpeedService;
	private int NumberAces;
	
	public Tennis(User user,Date date, int numberSuccessfulShot, int maxSpeedService, int numAces) {
		super(user,SportValue.Tennis,date);
		this.NumberSuccessfulShot=numberSuccessfulShot;
		this.MaxSpeedService=maxSpeedService;
		this.setNumberAces(numAces);
	}
	
	public Tennis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> T accept(SportVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public int getNumberSuccessfulShot() {
		return NumberSuccessfulShot;
	}

	public void setNumberSuccessfulShot(int numberSuccessfulShot) {
		NumberSuccessfulShot = numberSuccessfulShot;
	}

	public int getMaxSpeedService() {
		return MaxSpeedService;
	}

	public void setMaxSpeedService(int maxSpeedService) {
		MaxSpeedService = maxSpeedService;
	}

	public int getNumberAces() {
		return NumberAces;
	}

	public void setNumberAces(int numberAces) {
		NumberAces = numberAces;
	}
}
