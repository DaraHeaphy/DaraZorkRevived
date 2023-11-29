package com.epic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic.Player;

@Repository
public interface UserRepository extends JpaRepository<Player, Long>{
	
	public List<Player> findAllByUserIDAndPassword(String userID, String password);
}
