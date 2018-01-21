package gr.hua.dit.models;

import java.io.Serializable;

public class User implements Serializable {
	
	//this class is used for managing users
	private static final long serialVersionUID = -1355807851822025659L;
	
	private String UserID;
	private String Name;
	private String Password;
	
	public User(String userID, String name, String password) {
		super();
		UserID = userID;
		Name = name;
		Password = password;
	}
	
	public User() {
		super();
	}

	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	

}
