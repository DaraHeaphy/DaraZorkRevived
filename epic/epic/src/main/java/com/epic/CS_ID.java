package com.epic;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.epic.service.UserScoreService;

public class CS_ID {
	
	@Autowired
	private UserScoreService userScoreService;
	
	public void run () {
        
		int score = 0;
        String[][] answers = {
                { "Binary Numeric Format", "Basic Node Function", "Block Notation Framework", "Backus Naur Form" },
                { "The study of the sounds and pronunciation of words in a language",
                        "The processes a computer follows when executing a program in that specific language",
                        "The arrangement of words and phrases to create well-formed sentences in a language",
                        "The process of analyzing the grammatical structure of a sentence" },
                { "The power set of a finite set, ordered by inclusion",
                        "The set of integers under the usual less-than-or-equal relation (≤≤)",
                        "The set of real numbers under the usual less-than-or-equal relation (≤≤)",
                        "The set of positive integers under the usual less-than-or-equal relation (≤≤)" },
                { "x ⊓ y = y ⊓ x", "(x ⊓ y) ⊓ z = x ⊓ (y ⊓ z)", "x ⊔ y = y ⊔ x", "x ⊔ (x ⊓ y) = x" },
                { "In a linked list, elements are stored contiguously in memory, while in an array, elements are connected by pointers",
                        "In a linked list, elements can be dynamically inserted and deleted, while in an array, resizing is typically more expensive",
                        "In an array, accessing an element by index is generally faster than in a linked list",
                        "In a linked list, elements are accessed using an index, while in an array, elements are accessed through traversal" },
                { "P∧Q∨¬RP∧Q∨¬R", "(P∧Q)∨¬R(P∧Q)∨¬R", "P∨Q∧¬RP∨Q∧¬R", "P∧Q∧RP∧Q∧R" } };

        String[] correctAnswer = { "Backus Naur Form",
                "The processes a computer follows when executing a program in that specific language",
                "The set of positive integers under the usual less-than-or-equal relation (≤≤)",
                "(x ⊓ y) ⊓ z = x ⊓ (y ⊓ z)",
                "In a linked list, elements can be dynamically inserted and deleted, while in an array, resizing is typically more expensive",
                "(P∧Q)∨¬R(P∧Q)∨¬R" };

        String[] questions = { "What is BNF an abbreviation for?", "What is the definition of semantics?",
                "Which of these sets is not a lattice?", "Which of these matches the law of associativity?",
                "Which of the following statements about a linked list and an array is true?",
                "Given the Boolean expression P∧(Q∨¬R)P∧(Q∨¬R), which of the following expressions is equivalent to it?" };

        String[] choice = { "Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                "Computer Organization Increasing Difficulty", "Computer Organization Random",
                "Computer Science Random", "Who Wants to be a Millionare!" };

        JOptionPane.showMessageDialog(null, "Welcome to the Computer Science Quiz", "Welcome",
                JOptionPane.PLAIN_MESSAGE);

        for (int i = 0; i < questions.length; i++) {
            String userAnswer = JOptionPane.showInputDialog(null, questions[i], "Question " + (i + 1),
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