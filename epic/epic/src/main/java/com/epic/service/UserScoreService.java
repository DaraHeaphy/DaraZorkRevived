package com.epic.service;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epic.LoginPage;
import com.epic.UserScore;
import com.epic.repository.UserScoreRepository;

@Service
public class UserScoreService {
	
	@Autowired
	private UserScoreRepository userScoreRepo;
	
	public static String IncDif = "IncDif";
	public static String RandOrder = "RandOrder";
	public static String NewGame = "NewGame";
	
	public void addScore(String gameType, int score) {
		
		UserScore userScore = new UserScore(LoginPage.LOGGED_IN_USER, gameType, score);
		
		userScoreRepo.save(userScore);
		
	}

	public List<UserScore> getAllUserScores() {
		
		return userScoreRepo.findAll();
	
	}

	public List<UserScore> getAllUserScoresForGameType(String wantedGameType) {
		
		return userScoreRepo.findAllByGameType(wantedGameType);
		
	}

	public List<UserScore> getAllUserScoresForGameTypeForLoggedInUser(String wantedGameType) {
		
		return userScoreRepo.findAllByGameTypeAndUserID(wantedGameType, LoginPage.LOGGED_IN_USER);
		
	}
	public double getIncDifMeanForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(IncDif);
		return getMean(IncDif, userScores);
	}

	public double getRandOrderMeanForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(RandOrder);
		return getMean(RandOrder, userScores);
	}

	public double getNewGameMeanForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(NewGame);
		return getMean(NewGame, userScores);
	}
	public double getIncDifMedianForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(IncDif);
		return getMedian(IncDif, userScores);
	}

	public double getRandOrderMedianForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(RandOrder);
		return getMedian(RandOrder, userScores);
	}

	public double getNewGameMedianForLoggedInUser() {
		List<UserScore> userScores = getAllUserScoresForGameTypeForLoggedInUser(NewGame);
		return getMedian(NewGame, userScores);
	}

	public double getIncDifMean() {
		List<UserScore> userScores = getAllUserScoresForGameType(IncDif);
		return getMean(IncDif, userScores);
	}

	public double getRandOrderMean() {
		List<UserScore> userScores = getAllUserScoresForGameType(RandOrder);
		return getMean(RandOrder, userScores);
	}

	public double getNewGameMean() {
		List<UserScore> userScores = getAllUserScoresForGameType(NewGame);
		return getMean(NewGame, userScores); 
	}

	private double getMean(String gameType, List<UserScore> userScores) {
		double total = 0;
		for (int i = 0; i < userScores.size(); i++) {
			total += userScores.get(i).getScore();
		}
		return total / userScores.size();
	}

	public double getIncDifMedian() {
		List<UserScore> userScores = getAllUserScoresForGameType(IncDif);
		return getMedian(IncDif, userScores);
	}

	public double getRandOrderMedian() {
		List<UserScore> userScores = getAllUserScoresForGameType(RandOrder);
		return getMedian(RandOrder, userScores);
	}

	public double getNewGameMedian() {
		List<UserScore> userScores = getAllUserScoresForGameType(NewGame);
		return getMedian(NewGame, userScores);
	}

	private double getMedian(String gameType, List<UserScore> userScores) {
		int[] scores = new int[userScores.size()];
		for (int i = 0; i < userScores.size(); i++) {
			scores[i] = userScores.get(i).getScore();
		}
		if (scores.length == 0) {
			return 0;
		}
		Arrays.sort(scores);
		double median;
		if (scores.length % 2 == 0) {
			median = ((double) scores[scores.length / 2] + (double) scores[scores.length / 2 - 1]) / 2;
		} else {
			median = (double) scores[scores.length / 2];
		}
		return median;
	}

	public double getOverallIncDifStDev() {
		return getOverallStDev(IncDif);
	}

	public double getOverallRandOrderStDev() {
		return getOverallStDev(RandOrder);
	}

	public double getOverallNewGameStDev() {
		return getOverallStDev(NewGame);
	}

	private double getOverallStDev(String gameType) {
		List<UserScore> userScores = getAllUserScoresForGameType(gameType);
		int[] scores = new int[userScores.size()];
		for (int i = 0; i < userScores.size(); i++) {
			scores[i] = userScores.get(i).getScore();
		}
		// get the sum of array
		double sum = 0.0;
		for (double i : scores) {
			sum += i;
		}

		// get the mean of array
		int length = scores.length;
		double mean = sum / length;

		// calculate the standard deviation
		double standardDeviation = 0.0;
		for (double num : scores) {
			standardDeviation += Math.pow(num - mean, 2);
		}

		return Math.sqrt(standardDeviation / length);
	}
}
