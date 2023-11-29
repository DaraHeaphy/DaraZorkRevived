// This class is used to store the user information that we read in from the CSV file.
package com.epic;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userID;
	private String password;
	
	public Player() {
		
	}
	// This constructor is used when we create a new user. We default the score to 0.
	public Player(String userID, String password) {
		
		this.userID = userID;
		this.password = password;
	}
	
	// The functions below this are the getters and setters for the user information e.g userID, password.
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}