package com.epic;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.epic.service.UserScoreService;

import java.util.ArrayList;
import java.util.Collections;

public class CO_RD {
	
	@Autowired
	private UserScoreService userScoreService;
	
	public void run () {
       
		int score = 0;
        String[][] answers = { { "16", "32", "64", "128" },
                { "The price of computer hardware is halved every two years",
                        "The doubling of computer software capabilities every two years",
                        "The number of transistors will double every two years",
                        "Computer processors will quadruple every five years", },
                { "11,329^10", "9,326^10", "13,213^10", "10,315^10" },
                { "Millions of Instructions Per Second", "Modular Integrated Processing System",
                        "Minimal Instruction-Set Processor", "Multi-Instruction Processing System" },
                { "10000010^2", "11010^2", "101010^2", "1000001^2" }, { "101.1^2", "110^2", "100.1^2", "111.1^2" } };

        String[] correctAnswer = { "64", "The number of transistors will double every two years", "10,315^10",
                "Millions of Instructions Per Second", "11010^2", "101.1^2" };

        String[] questions = { "Novice: What is the maximum amount of registers at the Digital Logic Level?",
                "Novice: What does Moore's Law state", "Intermediate: Convert 284B to deccimal",
                "Intermediate: What does MIPS stand for. ", "Expert: Multiply 0010^2 * 1101^2",
                "Expert: Divide 101102 / 1002" };

        String[] choice = { "Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                "Computer Organization Increasing Difficulty", "Computer Science Increasing Difficulty",
                "Computer Science Random", "Who Wants to be a Millionare!" };

        ArrayList<Integer> questionIndices = new ArrayList<>();
        //makes questions into an array list to allow for shuffling
        for (int i = 0; i < questions.length; i++) {
        	//prints next question
            questionIndices.add(i);
        }
        Collections.shuffle(questionIndices);
        //randomizes questions

        JOptionPane.showMessageDialog(null, "Welcome to the Computer Organisation Quiz", "Welcome",
                JOptionPane.PLAIN_MESSAGE);

        for (int i : questionIndices) {
            String userAnswer = JOptionPane.showInputDialog(null, questions[i], "Question " + (i),
                    JOptionPane.PLAIN_MESSAGE, null, answers[i], null).toString();

            if (userAnswer.equals(correctAnswer[i])) {
                score += 1;
            }
        }
        JOptionPane.showMessageDialog(null, "Congratulations! You scored  " + score + " out of 6", null,
                JOptionPane.PLAIN_MESSAGE);
        userScoreService.addScore(UserScoreService.RandOrder, score);
        String next = JOptionPane.showInputDialog(null, null, "Would you like to Play the next Quiz",
                JOptionPane.PLAIN_MESSAGE, null, choice, null).toString();
        if (next.equals(choice[0])) {
            DM_ID dmIdQuiz = new DM_ID();
            dmIdQuiz.run();
        } else if (next.equals(choice[1])) {
            CO_ID coIdQuiz = new CO_ID();
            coIdQuiz.run();
        } else if (next.equals(choice[2])) {
            CO_RD coRdQuiz = new CO_RD();
            coRdQuiz.run();
        } else if (next.equals(choice[3])) {
            CS_ID csIdQuiz = new CS_ID();
            csIdQuiz.run();
        } else if (next.equals(choice[4])) {
            CS_RD csRdQuiz = new CS_RD();
            csRdQuiz.run();
        } else if (next.equals(choice[5])) {
            QUIZTHREE millionaireQuiz = new QUIZTHREE();
            millionaireQuiz.run();
        }
    }
}