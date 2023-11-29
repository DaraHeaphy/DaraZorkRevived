//Importing the necessary imports required for our code to run successfully and as intended.
package com.epic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
//Separate class for the Welcome Page.
@Component
public class WelcomePage implements ActionListener{
	
	@Autowired
	private QuizMenu quizMenu;
	JButton loginButton;
	//Creating a new JFrame for the Welcome Page.
	JFrame frame = new JFrame();
	//Creating a JLabel to display desired text upon opening of the JFrame.
	JLabel welcomeLabel = new JLabel("Hello");
	JButton beginButton = new JButton("Begin Quiz");
	
	
	WelcomePage() {
	
		//Setting bounds of the welcome label text, along with setting the font and text displayed.
	welcomeLabel.setBounds(10, -20, 450, 235);
	welcomeLabel.setFont(new Font(null,Font.BOLD,19));
	welcomeLabel.setText("Hello " +"! Click here to begin your Quiz.");
	
	 // Using JButton to create a button that begins the quiz when clicked.
	
	beginButton.setBounds(75, 150, 250, 125);
	beginButton.addActionListener(this);
	beginButton.setFocusable(false);
	
	
	//Adding all of the components to our frame.
	frame.add(welcomeLabel);
	frame.add(beginButton);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 420);
	frame.setLocationRelativeTo(null);//Centers the GUI into the middle of the screen.
	frame.setLayout(null);
	frame.setResizable(false);//Prevents window from entering full screen similar to the login page.
	ImageIcon image = new ImageIcon("ise.png");//creates image icon for the frame.
	frame.setIconImage(image.getImage());
	frame.getContentPane().setBackground(new Color(255, 150, 150));
	//Setting the frame to be visible so we can see the frame.
	frame.setVisible(false);
	
	}
	
	// Opens up the Quiz Menu when the begin button is clicked.
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==beginButton) {
			frame.dispose();
			quizMenu.menuFrame.setVisible(true);
		}
	}
}