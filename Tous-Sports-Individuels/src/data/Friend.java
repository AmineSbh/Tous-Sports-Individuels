package data;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY )
	private int Friend_id;
	
	 @ManyToOne
	@JoinColumn(name="UserName1", referencedColumnName="UserName")
	private User UserName1;
	
	 @ManyToOne
	 @JoinColumn(name="UserName2", referencedColumnName="UserName")
	private User UserName2;
	
	 @Enumerated(EnumType.STRING)
	    @Column(length = 8)
	private FriendStatus state;
	
	private Date Date;
	
	public Friend(User user1, User user2, String state,FriendStatus state1,Date date) {
		this.UserName1=user1;
		this.UserName2=user2;
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
		return UserName1;
	}

	public void setUser1(User user1) {
		UserName1 = user1;
	}

	public User getUser2() {
		return UserName2;
	}

	public void setUser2(User user2) {
		UserName2 = user2;
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
