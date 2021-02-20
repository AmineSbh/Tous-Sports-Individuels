package data;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int Friend_id;
	
	@Id
	 @ManyToOne
	    @JoinColumn(name="Username", nullable=false)
	private User User1;
	
	 @Id
	 @ManyToOne
	    @JoinColumn(name="Username", nullable=false)
	private User User2;
	
	 @Enumerated(EnumType.STRING)
	    @Column(length = 8)
	private FriendStatus state;
	
	private Date Date;
	
	public Friend(User user1, User user2, String state,FriendStatus state1,Date date) {
		this.User1=user1;
		this.User2=user2;
		this.state=state1;
		this.setDate(date);
	}
	
	public int getFriend_id() {
		return Friend_id;
	}
	
	public void setFriend_id(int friend_id) {
		Friend_id = friend_id;
	}
	
	public User getUser1() {
		return User1;
	}

	public void setUser1(User user1) {
		User1 = user1;
	}

	public User getUser2() {
		return User2;
	}

	public void setUser2(User user2) {
		User2 = user2;
	}

	public FriendStatus getState() {
		return state;
	}

	public void setState(FriendStatus state) {
		this.state = state;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

}
