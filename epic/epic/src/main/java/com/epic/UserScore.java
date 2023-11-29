// This class is used to store the user information that we read in from the CSV file.
package com.epic;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class UserScore {
	
	public UserScore() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userID;
	private String gameType;
	private int score;
	
	// This constructor is used when we create a new user. We default the score to 0.
	public UserScore(String userID, String gameType, int score) {
		
		this.userID = userID;
		this.gameType = gameType;
		this.score = score;
	}
	
	// The functions below this are the getters and setters for the user information e.g userID, password and score.
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}