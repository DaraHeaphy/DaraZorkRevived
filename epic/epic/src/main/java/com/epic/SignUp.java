package com.epic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

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
public class SignUp {

	@Autowired
	private UserService userService;

	@Autowired
	private ViewManager viewManager;

	JFrame frame = new JFrame();
	JTextField createIDField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton submitButton = new JButton();
	JLabel userIDLabel = new JLabel("Create userID:");
	JLabel userPasswordLabel = new JLabel("Create password:");
	JLabel errorLabel = new JLabel("Invalid Credentials");

	public SignUp() {

		userIDLabel.setBounds(30, 100, 100, 25);
		userPasswordLabel.setBounds(30, 150, 140, 25);

		createIDField.setBounds(140, 100, 250, 25);
		passwordField.setBounds(140, 150, 250, 25);
		submitButton.setBounds(140, 200, 200, 25);

		errorLabel.setBounds(125, 280, 250, 100);
		errorLabel.setFont(new Font(null, Font.ITALIC, 15));
		errorLabel.setVisible(false);

		submitButton.setText("Submit");
		submitButton.setFocusable(false);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				actionHandler(ae);

			}
		});

		frame.setSize(420, 420);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(createIDField);
		frame.add(passwordField);
		frame.add(errorLabel);
		frame.add(submitButton);
		frame.setVisible(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);// Centers the GUI into the middle of the screen.
		frame.setResizable(false);// Prevents the login screen from entering full screen mode as it is unnecessary
									// and also it is neater this way.
		ImageIcon image = new ImageIcon("ise.png");// creates image icon for the frame.
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(new Color(255, 150, 150));

	}

	// Gets the given userID and password from the sign up page and adds them to the
	// CSV File to be stored.
	public void actionHandler(ActionEvent e) {
		if (e.getSource() == submitButton) {
			if (createIDField.getText().isEmpty() && passwordField.getText().isEmpty()) {
				errorLabel.setVisible(true);
				errorLabel.setForeground(Color.red);
				errorLabel.setText("Invalid Credentials");
			} else {
				frame.dispose();
				String userID = createIDField.getText();
				String password = passwordField.getText();
				userService.addUser(userID, password);

				// Reopens the login page after successfully signing up.
				viewManager.showLoginPage();
			}
		}
	}
}