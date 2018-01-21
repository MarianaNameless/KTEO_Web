package gr.hua.dit.dao;

import gr.hua.dit.models.User;

public interface UserDAO {
	
	//Register a new user
	public void register(User user);

	//Check if provided userid already exists
	public int compare(String userid);
	
	//Log in an existing user
	public User login(String userid, String password);
	
	//Get user by id
	public User getById(String userid);
}
