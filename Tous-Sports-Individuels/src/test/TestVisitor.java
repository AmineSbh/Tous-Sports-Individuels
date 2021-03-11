package test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Course;
import data.DBConnection;
import data.Friend;
import data.FriendStatus;
import data.Sport;
import data.User;
import process.AddDataVisitor;
import process.SocialNetworkManager;
import process.SportManager;

public class TestVisitor {

	public static void main(String[] args) {
		
		/*Session session = DBConnection.getSession();
		//Transaction readTransaction = session.beginTransaction();
		Query query = session.createQuery("from Course where User_Username = 'weezy'");
		List<Sport> s= query.list();
		for(Sport sport : s){
			System.out.println(sport.getName()+" le nom: "+sport.getUser().getFirstName());
		}
		
		SportManager sm= new SportManager();
		List<Sport> s = sm.getSportByUser("weezy", "Course");
		
		for(Sport sport : s){
			System.out.println(sport.getName()+" le nom: "+sport.getUser().getFirstName());
		}
		
		
		
		User user= new User("weezy95","aaaaaa" ,"aaaaaa", "aaaaaa", "aaaaaa");
		SocialNetworkManager snm= new SocialNetworkManager();
		List<Friend> f = snm.getFriendsByUser(user);
		
		for(Friend friend : f){
			if(friend.getUser1()==user) {
				System.out.println("\n\n RELATION 1"+friend.getUser1().getUserName());
			}else {
				System.out.println("\n\n RELATION "+friend.getUser2().getUserName());
			}
			
		}*/
		String id="amine1";
		String id2="amine";
		
		String query="UPDATE Friend SET state="+"'"+FriendStatus.CONFIRM+"'"
				+" where (UserName1="+"'"+id+"' AND UserName2="+"'"+id2+"') "
						+ "OR (UserName1="+"'"+id2+"' AND UserName2="+"'"+id+"')"
						+ " AND state ="+"'"+FriendStatus.PENDING+"'";
		
		System.out.println(query);

	}

}
