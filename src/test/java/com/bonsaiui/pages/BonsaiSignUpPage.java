package com.bonsaiui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bonsaiui.utilities.BonsaiDrivers;
import com.bonsaiui.utilities.BonsaiUtils;

public class BonsaiSignUpPage { 
	public BonsaiSignUpPage() {
		PageFactory.initElements(BonsaiDrivers.getDriverReference(), this);
	}
	
	@FindBy(xpath ="//input[@id='user_email']")
	@CacheLookup
	public WebElement signUpEmail;
	
	@FindBy(xpath ="//input[@id='user_full_name']")
	@CacheLookup
	public WebElement signUpName;
	
	@FindBy(xpath ="//input[@id='user_password']")
	@CacheLookup
	public WebElement signUpPassword;
	
	@FindBy(xpath ="//input[@name='commit']")
	@CacheLookup
	public WebElement signUpGetStartedButton;
	
	
	public void bonsaiSignUp(String email, String name, String password) {
		signUpEmail.sendKeys(email);
		signUpName.sendKeys(name);
		signUpPassword.sendKeys(password);
		BonsaiUtils.clickWithJAvaScript(signUpGetStartedButton);
		
	} 
}
