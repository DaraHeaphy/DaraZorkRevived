//Importing the necessary imports required for our code to run successfully and as intended.
package com.epic;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic.service.UserScoreService;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
@Component
public class QuizMenu {
	
	@Autowired
	private UserScoreService userScoreService;
	
	@Autowired
	private Main_GuI mainGUI;
	
	@Autowired
	private Main_GuIRD mainGUIRD;
	
	JFrame menuFrame = new JFrame();//creates a frame
	JLabel label = new JLabel("Please select which game mode you wish to play, or, view the stats of each of our 3 game modes in the CLI!", SwingConstants.CENTER);//Puts our JLabel at the center of the JFrame.
	JButton button = new JButton("Increasing Difficulty");//Creating the button which will initiate the Increasing Difficulty format when clicked.
	JButton button1 = new JButton("Random Draw");//Creating the button which will initiate the Random Draw format when clicked.
	JButton button2 = new JButton("Stats 1");//Creating the button which will initiate the ____________ format when clicked.
	JButton button3 = new JButton("Stats 2");
	JButton button4 = new JButton("Stats 3");
	
	public QuizMenu() {
		
		label.setFont(new Font("SERIF",Font.BOLD,30));
			
		ImageIcon icon = new ImageIcon("button.png");
		ImageIcon icon1 = new ImageIcon("difficullt.png");
		ImageIcon icon2 = new ImageIcon("stats.png");
		
			button.setBounds(100, 100, 400, 200);//Setting the button's x and y co-ordiantes in the JFrame, and also its width and height.
			button.setFocusable(false);//Setting the button to focusable to remove the outline from around the button's text, making it more appealing to the user.
			button.setText("Increasing Difficulty");
			button.setIcon(icon1);
			button.setFont(new Font("Arial",Font.BOLD,35));
			button.setVerticalTextPosition(JButton.BOTTOM);
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setIconTextGap(-35);
			button.setBorder(BorderFactory.createLoweredBevelBorder());
			button.setForeground(Color.white);
			button.setBackground(Color.black);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button) {
						mainGUI.run();
					}
				}
			});
			
			button1.setBounds(950, 100, 400,200);//Setting the button's x and y co-ordiantes in the JFrame, and also its width and height.
			button1.setFocusable(false);//Setting the button to focusable to remove the outline from around the button's text, making it more appealing to the user.
			button1.setIcon(icon);
			button1.setText("Random Draw");
			button1.setFont(new Font("Comic Sans",Font.BOLD,45));
			button1.setVerticalTextPosition(JButton.BOTTOM);
			button1.setHorizontalTextPosition(JButton.CENTER);
			button1.setIconTextGap(-20);
			button1.setBorder(BorderFactory.createLoweredBevelBorder());
			button1.setBackground(Color.white);
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button1) {
						mainGUIRD.run();
					}
				}
			});
			
			button2.setBounds(255, 600, 260, 200);//Setting the button's x and y co-ordiantes in the JFrame, and also its width and height.
			button2.setFocusable(false);//Setting the button to focusable to remove the outline from around the button's text, making it more appealing to the user.
			button2.setIcon(icon2);
			button2.setText("IncDif Stats");
			button2.setFont(new Font("Comic Sans",Font.BOLD,35));
			button2.setVerticalTextPosition(JButton.BOTTOM);
			button2.setHorizontalTextPosition(JButton.CENTER);
			button2.setIconTextGap(-40);
			button2.setForeground(Color.black);
			button2.setBorder(BorderFactory.createLoweredBevelBorder());
			button2.setBackground(Color.white);
			button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button2) {
						menuFrame.dispose();
						System.out.println("Overall Increasing Difficulty Stats:");
				        System.out.println("The overall 'Increasing Difficulty' mean value is: " + userScoreService.getIncDifMean());
						System.out.println("The overall 'Increasing Difficulty' median value is: " + userScoreService.getIncDifMedian());
						System.out.println("The overall 'Increasing Difficulty' standard deviation is : " + userScoreService.getOverallIncDifStDev());
						System.out.println("User's Increasing Difficulty Stats:");
						System.out.println("The user's 'Increasing Difficulty' score's mean value is: " + userScoreService.getIncDifMeanForLoggedInUser());
						System.out.println("The user's 'Increasing Difficulty' score's median value is: " + userScoreService.getIncDifMedianForLoggedInUser());
					}
				}
			});
			
			button3.setBounds(605, 600, 260, 200);//Setting the button's x and y co-ordiantes in the JFrame, and also its width and height.
			button3.setFocusable(false);//Setting the button to focusable to remove the outline from around the button's text, making it more appealing to the user.
			button3.setIcon(icon2);
			button3.setText("RD Order Stats");
			button3.setFont(new Font("Comic Sans",Font.BOLD,28));
			button3.setVerticalTextPosition(JButton.BOTTOM);
			button3.setHorizontalTextPosition(JButton.CENTER);
			button3.setIconTextGap(-20);
			button3.setForeground(Color.black);
			button3.setBorder(BorderFactory.createLoweredBevelBorder());
			button3.setBackground(Color.white);
			button3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button3) {
						menuFrame.dispose();
						System.out.println("Overall Random Order Stats:");
				        System.out.println("The overall 'Random Order' mean value is: " + userScoreService.getRandOrderMean());
						System.out.println("The overall 'Random Order' median value is: " + userScoreService.getRandOrderMedian());
						System.out.println("The overall 'Random Order' standard deviation is : " + userScoreService.getOverallRandOrderStDev());
						System.out.println("User's Random Order Stats:");
						System.out.println("The user's 'Random Order' score's mean value is: " + userScoreService.getRandOrderMeanForLoggedInUser());
						System.out.println("The user's 'Random Order' score's median value is: " + userScoreService.getRandOrderMedianForLoggedInUser());
					}
				}
			});
			
			button4.setBounds(955, 600, 260, 200);//Setting the button's x and y co-ordiantes in the JFrame, and also its width and height.
			button4.setFocusable(false);//Setting the button to focusable to remove the outline from around the button's text, making it more appealing to the user.
			button4.setIcon(icon2);
			button4.setText("GameShow Stats");
			button4.setFont(new Font("Comic Sans",Font.BOLD,21));
			button4.setVerticalTextPosition(JButton.BOTTOM);
			button4.setHorizontalTextPosition(JButton.CENTER);
			button4.setIconTextGap(-20);
			button4.setForeground(Color.black);
			button4.setBorder(BorderFactory.createLoweredBevelBorder());
			button4.setBackground(Color.white);
			button4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button4) {
						menuFrame.dispose();
						System.out.println("Overall Who wants to be a Millionaire Stats:");
				        System.out.println("The overall 'Who wants to be a Millionaire' mean value is: " + userScoreService.getNewGameMean());
						System.out.println("The overall 'Who wants to be a Millionaire' median value is: " + userScoreService.getNewGameMedian());
						System.out.println("The overall 'Who wants to be a Millionaire' standard deviation is : " + userScoreService.getOverallNewGameStDev());
						System.out.println("User's Who wants to be a Millionaire Stats:");
						System.out.println("The user's 'Who wants to be a Millionaire' score's mean value is: " + userScoreService.getNewGameMeanForLoggedInUser());
						System.out.println("The user's 'Who wants to be a Millionaire' score's median value is: " + userScoreService.getNewGameMedianForLoggedInUser());
					}
				}
			});
			
			label.setBounds(500, -150, 10000, 1000);//Setting the label's x and y co-ordiantes in the JFrame, and also its width and height.
	
			menuFrame.setSize(420,420);//Setting the JFrame's size.
			menuFrame.add(button);//Adding a button.
			menuFrame.add(button1);//Adding a button.
			menuFrame.add(button2);
			menuFrame.add(button4);
			menuFrame.add(button3);//Adding a button.
			menuFrame.add(label);//Adding a label.
			menuFrame.getContentPane().setBackground(new Color(255, 150, 150));
			menuFrame.setTitle("Quiz Menu");//sets title of frame.
			menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits out of application
			menuFrame.setResizable(false);//Sets the frame to be non resizable.
			menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);//Makes the JFrame full screen upon being opened.
			menuFrame.setLocationRelativeTo(null);			
			ImageIcon image = new ImageIcon("ise.png");//creates an image icon
			menuFrame.setIconImage(image.getImage());//changes icon of frame.
			menuFrame.setVisible(false);//Setting the Frame to be invisible until the "begin" button from the "WelcomePage" class is clicked.
	
			}
}