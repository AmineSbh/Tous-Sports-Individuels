package process;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.DBConnection;
import data.Friend;
import data.Sport;
import data.User;
import test.manual.SportValue;

public class SocialNetworkManager {
	
	private AddDataVisitor visitor;
	
	public SocialNetworkManager() {
		visitor=new AddDataVisitor();
	}
	
	public Boolean addData(Friend friend) {
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
				+ "AND state = 'CONFIRM'";
		
		//get List of Friend object
		if(query!=null) {
			Session session = DBConnection.getSession();
			Query q = session.createQuery(query);
			friends= q.list();
			session.close();
		}
		
		return friends;
	}

}
