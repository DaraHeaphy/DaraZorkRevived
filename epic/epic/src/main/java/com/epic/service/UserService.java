package com.epic.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epic.Player;
import com.epic.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(String userID, String password) {
		
		Player user = new Player(userID, password);
		
		userRepository.save(user);
	}

	public List<Player> getUsers() {
		
		return userRepository.findAll();	
	}

	// Gets all the userIDs and passwords from the users list and checks to see if
	// the given userID and password match.
	public boolean doesUserExist(String userID, String password) {
		
		return userRepository.findAllByUserIDAndPassword(userID, password).size() == 1;
	}
}
