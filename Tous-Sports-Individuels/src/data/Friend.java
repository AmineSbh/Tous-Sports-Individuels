package data;

import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	private int id1;
	private int id2;
	private Boolean state;
	
	public Friend(int id1, int id2, Boolean state) {
		this.id1=id1;
		this.id2=id2;
		this.state=state;
	}

}
