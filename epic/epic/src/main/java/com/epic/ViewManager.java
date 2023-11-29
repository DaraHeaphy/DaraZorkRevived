package com.epic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewManager {
	@Autowired
	private LoginPage loginPage;
	
	@Autowired
	private SignUp signUp;
	
	public void showLoginPage() {
		loginPage.frame.setVisible(true);
	}
	
	public void showSignUpPage() {
		signUp.frame.setVisible(true);
	}

}
