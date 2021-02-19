package data;

import java.sql.Date;
import javax.persistence.*;

import process.SportVisitor;

@Entity
public class Tennis extends Sport{
	private int NumberSuccessfulShot;
	private int MaxSpeedService;

	public Tennis(Date date) {
		super(date);
		// TODO Auto-generated constructor stub
	}

	public Tennis(Date date, int NbSuccess, int MaxSpeedServ) {
		super(date);
		this.NumberSuccessfulShot = NbSuccess;
		this.MaxSpeedService = MaxSpeedServ;
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
