package process;

import data.Sport;

public class SportManager {
	
	private Sport sport;
	private AddDataVisitor visitor;
	
	public SportManager(Sport sport) {
		this.setSport(sport);
		this.visitor=new AddDataVisitor();
	}
	
	public void addData() {
		this.sport.accept(visitor);
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	

}
