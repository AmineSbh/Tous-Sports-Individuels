package data;

public class UserStatic {
	
	private static User instance = new User();
	
	/**
	 * Private constructor ensuring no access from outside of the class.
	 */
	private UserStatic(User user) {
		instance=user;
	}

	public static User getInstance() {
		return instance;
	}

}
