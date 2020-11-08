package com.bonsaiui.stepdefinitions;

import com.bonsaiui.pages.BonsaiLogInPage;
import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;

import io.cucumber.java.en.Given;

public class BonsaiFirstTest {
	
	@Given("User open application")
	public void user_open_application() {
		BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("url"));
		
		
		
		
	}

	@Given("User login with credentials {string} and {string}")
	public void user_login_with_credentials_and(String userName, String password) {
	    
		
		BonsaiLogInPage bonsaiLogInPage = new BonsaiLogInPage();
		bonsaiLogInPage.loginBonsai(userName, password);

}
}