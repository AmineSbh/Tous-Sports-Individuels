package process;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.DBConnection;
import data.Friend;
import data.FriendStatus;
import data.Sport;
import data.User;
import test.manual.SportValue;

public class SocialNetworkManager {
	
	private AddDataVisitor visitor;
	private DeleteDataVisitor visitor1;
	
	public SocialNetworkManager() {
		visitor = new AddDataVisitor();
		visitor1 = new DeleteDataVisitor();
	}
	
	public Boolean Friend_Request(Friend friend) {
		Boolean a=true;
		try {
			friend.accept(visitor);
		}catch(IllegalArgumentException e){
			System.err.println("add data sport failed.");
			a=false;
		}
		return a;
	}
	
	public List<Friend> getFriendsByUser(User user) {
		List<Friend> friends=null;
		String id =user.getUserName();
		
		String query="from Friend where (UserName1="+"'"+id+"' OR UserName2="+"'"+id+"') "
				+ "AND state ="+"'"+FriendStatus.CONFIRM+"'";
		//get List of Friend object
		if(query!=null) {
			Session session = DBConnection.getSession();
			Query q = session.createQuery(query);
			friends= q.list();
			session.close();
		}
		
		return friends;
	}
	
	public List<User> getUser(String user) {
		List<User> friends=null;
		String id =user;
		String query="from User where (Username="+"'"+id+"')";
		if(query!=null) {
			Session session = DBConnection.getSession();
			Query q = session.createQuery(query);
			friends= q.list();
			session.close();
		}
		return friends;
	}
	
	public Boolean Delete_Friend(User user1, User user2) {
		List<Friend> friend=null;
		Boolean accept=true;
		String id =user1.getUserName();
		String id2 = user2.getUserName();
		String query="from Friend where (UserName1='"+id+"' AND UserName2='"+id2+"') "
					+ "OR (UserName1='"+id2+"' AND UserName2='"+id+"')";
		try {
			Session session = DBConnection.getSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery(query);
			friend= q.list();
			
			int idFriend = friend.get(0).getFriend_id();
			Friend f = (Friend) session.get(Friend.class, idFriend);
			session.delete(f);
			transaction.commit();
			session.close();
		}catch (IllegalArgumentException e){
			System.err.println("accept failed.");
			accept=false;
		}
		
		return accept;
	}
	
	public List<Friend> getFriendRequestByUser(User user) {
		List<Friend> friends=null;
		String id =user.getUserName();
		
		//delete UserName1 
		String query="from Friend where (UserName2="+"'"+id+"') "
				+ "AND state ="+"'"+FriendStatus.PENDING+"'";
		
		//get List of Friend object
		if(query!=null) {
			Session session = DBConnection.getSession();
			Query q = session.createQuery(query);
			friends= q.list();
			session.close();
		}
		
		return friends;
	}
	
	
	public Boolean getAcceptRequest(User user, String user2) {
		List<Friend> friend=null;
		Boolean accept=true;
		String id =user.getUserName();
		String id2 = user2;
		
		String query="from Friend where (UserName1='"+id+"' AND UserName2='"+id2+"') "
					+ "OR (UserName1='"+id2+"' AND UserName2='"+id+"')";
		try {
			Session session = DBConnection.getSession();
			Transaction transaction = session.beginTransaction();
			Query q = session.createQuery(query);
			friend= q.list();
			
			int idFriend = friend.get(0).getFriend_id();
			Friend f = (Friend) session.get(Friend.class, idFriend);
			f.setState(FriendStatus.CONFIRM);
			
			transaction.commit();
			session.close();
		}catch (IllegalArgumentException e){
			System.err.println("accept failed.");
			accept=false;
		}
		
		return accept;
	}

}
