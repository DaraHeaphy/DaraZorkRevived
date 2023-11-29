package com.epic;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic.service.UserScoreService;


import java.util.ArrayList;
import java.util.Collections;

@Component
public class DM_RD {
	
	@Autowired
	private UserScoreService userScoreService;
	
	public void run () {
        int score = 0;
        String[][] answers = {
                { "The study of mathematical structures",
                        "The branch of mathematics that deals with quadratic functions",
                        " The study of mathematics that focuses on continuous data and real numbers",
                        "The branch of mathematics that deals with  integers and sets" },
                { "p ^ q", "p∨ ¬q", "p∨ ¬ ¬q", "¬p^ ¬q" }, { "¬𝒑 ∨ ¬q", "¬𝒑 ^ ¬q", "p^ ¬q", "p ∨ ¬q" },
                { "∀x¬∃y(x < y < x + 1)", "∀x∀y∃z(x < z < y ∨ y < z < x)", "¬∀x∃y(x < y < x + 1)",
                        "¬∀x∀y¬∃z(x < z < y ∨ y < z < x)" },
                { "(0,1,0,1,0,0,1,1)", "(1,1,0,0,0,1,1,1)", "(0,0,0,1,0,1,1,1)", "(1,1,0,0,0,1,1,1)" },
                { "-2, 4, 7/3, -2/3", "-3, 5, -8, 1/3", "2, 1, -5, 11/3", "-3, 1, 4/3, -1/3" } };

        String[] correctAnswer = { "The branch of mathematics that deals with  integers and sets.", "p ^ q", "¬𝒑 ∨ ¬q",
                "∀x∀y∃z(x < z < y ∨ y < z < x)", "(0,0,0,1,0,1,1,1)", "-3, 1, 4/3, -1/3" };

        String[] questions = { "What is discrete mathematics?", "What is the logical equivalence of ¬¬p ^ q?",
                "Complete the De Morgan’s theorem of ¬(p ^ q)",
                "Which expression translates to 'There is a prime number'",
                "Write the final column for the expression (A∨¬B)⇔((C∧¬A)→ (B^C))",
                "Matrix A = [1,3,4,9]. Find the inverse of A" };

        String[] choice = { "Discrete Maths Increasing Difficulty", "Computer Organization Increasing Difficulty",
                "Computer Organization Random", "Computer Science Increasing Difficulty", "Computer Science Random",
                "Who Wants to be a Millionare!" };

        ArrayList<Integer> questionIndices = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            questionIndices.add(i);
        }
        Collections.shuffle(questionIndices);

        JOptionPane.showMessageDialog(null, "Welcome to the Discrete Maths Quiz", "Welcome", JOptionPane.PLAIN_MESSAGE);

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