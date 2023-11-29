package com.epic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epic.UserScore;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Long>{
	
	public List<UserScore> findAllByGameType(String gameType);
	
	public List<UserScore> findAllByGameTypeAndUserID(String gameType, String userID);

	
}
