//All of the necessary imports required in order for this code to run as intended.
package com.epic;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epic.service.UserService;

@Component
public class LoginPage implements ActionListener {
	@Autowired
	private ViewManager viewManager;
	
	@Autowired
	private UserService userService;
	
	
	
	public static String LOGGED_IN_USER;
		

	// Creating our JFrame along with the login and reset buttons, the userID Field
	// and the Password fields, all with labels to match. All done using JAVA Swing.
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton createButton = new JButton("Sign Up");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField(); 
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("");

	// Setting up the Login Page parameters so that it will accept a Hash Map.
	LoginPage() {

		// Setting bounds for the userIDLabel and userPasswordLabel.
		userIDLabel.setBounds(50, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);

		// Setting bounds and font for the messageLabel.
		messageLabel.setBounds(125, 280, 250, 100);
		messageLabel.setFont(new Font(null, Font.ITALIC, 15));

		// Setting bounds for the userIDField and userPasswordField.
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);

		// Setting bounds for the login button and also adding the Action Listener so
		// that it responds to a user's click.
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this);
		// Using .setFocusable(false) to make our login button more visually appealing
		// by removing a small outline surrounding it.
		loginButton.setFocusable(false);

		// Setting bounds for the reset button and also using .setFocusable(false) to
		// make our reset button more visually appealing.
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this);
		resetButton.setFocusable(false);

		createButton.addActionListener(this);
		createButton.setBounds(125, 240, 200, 25);
		createButton.setFocusable(false);

		// Adding all the different components of our login page to the frame, and
		// setting it's visibility to "true" in order for us to see it.
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(createButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.getContentPane().setBackground(new Color(255, 150, 150));
		frame.setLocationRelativeTo(null);// Centers the GUI into the middle of the screen.
		frame.setResizable(false);// Prevents the login screen from entering full screen mode as it is unnecessary
		// and also it is neater this way.
		frame.setVisible(true);
		ImageIcon image = new ImageIcon("ise.png");// creates image icon for the frame.
		frame.setIconImage(image.getImage());
	}

	// Using the ActionPerformed method to make the use of our login and reset
	// buttons result in desired outcomes.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createButton) {
			frame.dispose();
			viewManager.showSignUpPage();
		}
		// "If" statement used to clear the userIDField and userPasswordField when the
		// reset button is clicked.
		if (e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		// Creating two strings userID and password to store the inputed userID and
		// password to later check if they match with each other.
		if (e.getSource() == loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());

			boolean isValidUser = userService.doesUserExist(userID, password);
			

			// Another "if" statement used to verify that the password matches the userID
			// resulting in the login being successful.
			if (isValidUser) {

				messageLabel.setForeground(Color.green);
				messageLabel.setText("Login Successful");
				// Disposing of the login frame.
				frame.dispose();
				
				LOGGED_IN_USER = userID;
				// Opening of the "Welcome Page" after a successful login.
				WelcomePage welcomePage = new WelcomePage();
				welcomePage.frame.setVisible(true);
				// Using "else" statement to display the words "Password Incorrect" in red
				// writing if the password inputed does not match the inputed userID.
					
			} else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username or Password Invalid.");
			}

		}

	}
}

