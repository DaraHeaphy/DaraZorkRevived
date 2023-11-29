package com.epic;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic.service.UserScoreService;

@Component
public class QUIZTHREE {
	
	@Autowired
	private UserScoreService userScoreService;
	
    public void run () {
        int j;
        //money int
        j = 0;
        int money = j * 50000;
        //multiplied to track money
        String[][] answers = {
                { "Binary Numeric Format", "Basic Node Function", "Block Notation Framework", "Backus Naur Form" },
                { "16", "32", "64", "128" },
                { "The study of mathematical structures",
                        "The branch of mathematics that deals with quadratic functions",
                        " The study of mathematics that focuses on continuous data and real numbers",
                        "The branch of mathematics that deals with  integers and sets" },
                { "The price of computer hardware is halved every two years",
                        "The doubling of computer software capabilities every two years",
                        "The number of transistors will double every two years",
                        "Computer processors will quadruple every five years", },
                { "The study of the sounds and pronunciation of words in a language",
                        "The processes a computer follows when executing a program in that specific language",
                        "The arrangement of words and phrases to create well-formed sentences in a language",
                        "The process of analyzing the grammatical structure of a sentence" },
                { "p ^ q", "p∨ ¬q", "p∨ ¬¬q", "¬p^ ¬q" },

                { "¬𝒑 ∨ ¬q", "¬𝒑 ^ ¬q", "p^ ¬q", "p ∨ ¬q" },
                { "The power set of a finite set, ordered by inclusion",
                        "The set of integers under the usual less-than-or-equal relation (≤≤)",
                        "The set of real numbers under the usual less-than-or-equal relation (≤≤)",
                        "The set of positive integers under the usual less-than-or-equal relation (≤≤)" },
                { "11,329^10", "9,326^10", "13,213^10", "10,315^10" },
                { "Millions of Instructions Per Second", "Modular Integrated Processing System",
                        "Minimal Instruction-Set Processor", "Multi-Instruction Processing System" },
                { "∀x¬∃y(x < y < x + 1)", "∀x∀y∃z(x < z < y ∨ y < z < x)", "¬∀x∃y(x < y < x + 1)",
                        "¬∀x∀y¬∃z(x < z < y ∨ y < z < x)" },
                { "x ⊓ y = y ⊓ x", "(x ⊓ y) ⊓ z = x ⊓ (y ⊓ z)", "x ⊔ y = y ⊔ x", "x ⊔ (x ⊓ y) = x" },
                { "an Assembly Based Algorithm", "a Microprogram", "an Arithmetic Logic Unit", "a Memory Map", },

                { "In a linked list, elements are stored contiguously in memory, while in an array, elements are connected by pointers",
                        "In a linked list, elements can be dynamically inserted and deleted, while in an array, resizing is typically more expensive",
                        "In an array, accessing an element by index is generally faster than in a linked list",
                        "In a linked list, elements are accessed using an index, while in an array, elements are accessed through traversal" },
                { "(0,1,0,1,0,0,1,1)", "(1,1,0,0,0,1,1,1)", "(0,0,0,1,0,1,1,1)", "(1,1,0,0,0,1,1,1)" },
                { "P∧Q∨¬RP∧Q∨¬R", "(P∧Q)∨¬R(P∧Q)∨¬R", "P∨Q∧¬RP∨Q∧¬R", "P∧Q∧RP∧Q∧R" },
                { "10000010^2", "11010^2", "101010^2", "1000001^2" },
                { "-2, 4, 7/3, -2/3", "-3, 5, -8, 1/3", "2, 1, -5, 11/3", "-3, 1, 4/3, -1/3" },
                { "101.1^2", "110^2", "100.1^2", "111.1^2" },
                { "If m > n, then the graph is planar", "If m = n - 1, then the graph is a tree",
                        "If m = n + 1, then the graph is bipartite", " If m = n, then the graph contains a cycle" }, };

        String[] questions = { "What is BNF an abbreviation for?",
                "What is the maximum amount of registers at the Digital Logic Level?", "What is discrete mathematics?",
                "What does Moore's Law state?", "What is the definition of semantics?",
                "What is the logical equivalence of ¬¬p ^ q?",

                "Complete the De Morgan’s theorem of ¬(p ^ q)", "Which of these sets is not a lattice?",
                "Convert 284B to decimal", "What does MIPS stand for? ",
                "Which expression translates to 'There is a prime number'?",
                "Which of these matches the law of associativity?",
                "At the microarchitecture level,registers form a circuit called:",

                "Which of the following statements about a linked list and an array is true?",
                "Write the final column for the expression (A∨¬B)⇔((C∧¬A)→ (B^C))",
                "Given the Boolean expression P∧(Q∨¬R)P∧(Q∨¬R), which of the following expressions is equivalent to it?",
                "Multiply 0010^2 * 1101^2", "Matrix A = [1,3,4,9]. Find the inverse of A", "Divide 10110^2 / 100^2",
                "In a connected graph with n vertices and m edges, which of the following statements is true?" };

        String[] correctAnswer = { "Backus Naur Form", "64",
                "The branch of mathematics that deals with  integers and sets",
                "The number of transistors will double every two years",
                "The processes a computer follows when executing a program in that specific language", "p ^ q",

                "¬𝒑 ∨ ¬q", "The set of positive integers under the usual less-than-or-equal relation (≤≤)",
                "10,315^10", "Millions of Instructions Per Second", "∀x∀y∃z(x < z < y ∨ y < z < x)",
                "(x ⊓ y) ⊓ z = x ⊓ (y ⊓ z)", "an Arithmetic Logic Unit",

                "In a linked list, elements can be dynamically inserted and deleted, while in an array, resizing is typically more expensive",
                "(0,0,0,1,0,1,1,1)", "(P∧Q)∨¬R(P∧Q)∨¬R", "11010^2", "-3, 1, 4/3, -1/3", "101.1^2",
                "If m = n - 1, then the graph is a tree" };

        String[] Decision = { "Congratulations! Would you like to walk away, or take a risk." };
        String[] Choice = { "Walk away", "Continue" };

        String[] choice = { "Discrete Maths Increasing Difficulty", "Discrete Maths Random",
                "Computer Organization Increasing Difficulty", "Computer Organization Random",
                "Computer Science Increasing Difficulty", "computer Science Random" };
        
        
        JOptionPane.showMessageDialog(null, "Welcome to Who Wants to be a Milionaire: ISE Edition", "Welcome",
                JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "*There are 20 questions.\n*If you answer all 20 questions, you win $1,000,000!\n*If you get one question wrong however,you lose all the money.\n*After every 5 questions, you have the option to walk away with the money, or  continue.\n*Good Luck!",
                "Rules!", JOptionPane.PLAIN_MESSAGE);
        //explains rules to user

        for (int i = 0; i < questions.length; i++) {
            String userAnswer = JOptionPane.showInputDialog(null, questions[i],
                            "Question " + (i + 1) + ": You have $" + money, JOptionPane.PLAIN_MESSAGE, null, answers[i], null)
                    .toString();
            if (i == 4 || i == 9 || i == 14) {
                String decision = JOptionPane.showInputDialog(null, Decision, "Total winnings: $" + money,
                        JOptionPane.PLAIN_MESSAGE, null, Choice, null).toString();
                //gives user chance to quit or continue quiz
                if (decision.equals(Choice[0])) {
                    JOptionPane.showMessageDialog(null, "Well Done! You won $ " + money + " out of $1,000,000",
                            "Congratulations!", JOptionPane.PLAIN_MESSAGE);
                    //breaks program and relays money won
                    break;
                }
            }

            if (userAnswer.equals(correctAnswer[i])) {
                j++;
                money = j * 50000;
                //method to increase money
            }
            if (!userAnswer.equals(correctAnswer[i])) {
                JOptionPane.showMessageDialog(null, "Incorrect! You lost $ " + money + " out of $1,000,000",
                        "Game Over", JOptionPane.PLAIN_MESSAGE);
                //if answer is incorrect, breaks and user loses all money
                break;
            }
            if (userAnswer.equals(correctAnswer[19])) {
                JOptionPane.showMessageDialog(null,
                        "Congratulations! You won $ " + money
                                + " and have completed Who Wants to be a Millionare: ISE Edition.",
                        "Game Over", JOptionPane.PLAIN_MESSAGE);
                //final victory message

            }
        }
        //links money value to my partners value 
        userScoreService.addScore(UserScoreService.NewGame, money);
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

