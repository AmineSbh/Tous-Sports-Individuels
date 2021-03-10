package test.unit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import data.Friend;
import data.FriendStatus;
import data.User;
import process.ProfilManager;
import process.SocialNetworkManager;

public class SocialNetworkManagerTest {

	@Test
	public void testAddFriendRelationship() {
		User user= new User("weezy95","aaaaaa" ,"aaaaaa", "aaaaaa", "aaaaaa");
		User user2= new User("weezy955","aaaaaa" ,"aaaaaa", "aaaaaa", "aaaaaa");
		SocialNetworkManager snm= new SocialNetworkManager();
		Friend friend = new Friend(user,user2);
		
		friend.setState(FriendStatus.CONFIRM);
		
		assertTrue(snm.addData(friend));
	}
	
	@Test
	public void testListofFriendRelationship() {
		User user= new User("weezy95","aaaaaa" ,"aaaaaa", "aaaaaa", "aaaaaa");
		SocialNetworkManager snm= new SocialNetworkManager();
		List<Friend> f = snm.getFriendsByUser(user);
		
		assertEquals("weezy955",f.get(0).getUser2().getUserName());
	}

}
