package data;

import java.sql.Date;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public class Tennis extends Sport{
	private int NumberSuccessfulShot;
	private int MaxSpeedService;

	public Tennis(User user,Date date, int numberSuccessfulShot, int maxSpeedService) {
		super(user,date);
		this.NumberSuccessfulShot=numberSuccessfulShot;
		this.MaxSpeedService=maxSpeedService;
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
}
