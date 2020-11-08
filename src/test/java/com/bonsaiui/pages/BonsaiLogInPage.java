package com.bonsaiui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.bonsaiui.utilities.BonsaiDrivers;

public class BonsaiLogInPage {

	// POM (Page Object Modeling) is a Java Library
	// Page Factory, and keep each feature as a class and keep necessary action in
	// it. We get this from Selenium.
	// We separate code and web elements and variables in java.
	// Re-usability and maintenance.
	// Headless browser, @cacheLookup will make the test run faster

	public BonsaiLogInPage() {
		PageFactory.initElements(BonsaiDrivers.getDriverReference(), this);
	}

	@FindBy(xpath = "//input[@id='login-user-email']")
	@CacheLookup
	WebElement loginEmail;

	@FindBy(xpath = "//input[@id='login-user-password']")
	@CacheLookup
	WebElement loginPassword;

	@FindBy(name = "commit")
	@CacheLookup
	WebElement loginSignInButton;

	// This will check if LOGO Presents in the WebPage
	@FindBy(xpath = "//img[@class='sidebar-brand-icon']")
	@CacheLookup
	WebElement BonsaiLogo;

	// Client Tab
	@FindBy(linkText = "Clients")
	@CacheLookup
	WebElement clientTab;

	// Add New Client Tab
	@FindBy(id = "new-client-modal-btn")
	@CacheLookup
	WebElement addNewClientButton;

	// Company name
	@FindBy(id = "companies_contact[company_name]")
	@CacheLookup
	WebElement companyName;

	// contact name
	@FindBy(id = "companies_contact[contact_name]")
	@CacheLookup
	WebElement contactName;

	// email
	@FindBy(id = "companies_contact[email]")
	@CacheLookup
	WebElement email;

	// Add Client Button
	@FindBy(name = "commit")
	@CacheLookup
	WebElement addClient;
	
	public void loginBonsai(String userName, String passWord) {
		loginEmail.clear();
		loginEmail.sendKeys(userName);
		loginPassword.clear();
		loginPassword.sendKeys(passWord);
	}

	public void loginButton() {
		loginSignInButton.click();
	}

	// This will get the Page Title
	public String validateLoginPageTitle() {
		return BonsaiDrivers.getDriverReference().getTitle();
	}

	// This will validate Bonsai Logo
	public boolean validateBonsaiLogo() {
		return BonsaiLogo.isDisplayed();
	}

	// Click Clients Tab
	public void clientsTab() {
		clientTab.click();
	}

	// Click Add New Client Button
	public void addNewClient() {
		addNewClientButton.click();
	}

	// Filling Client Data
	public void clientData(String company, String contact, String emailAddress) {
		companyName.clear();
		companyName.sendKeys(company);
		contactName.clear();
		contactName.sendKeys(contact);
		email.clear();
		email.sendKeys(emailAddress);
		//addClient.click();
	}
	
	////////////////////////////////////////////////////////////////////////

	// Project Tab
	@FindBy(linkText = "Projects")
	@CacheLookup
	WebElement projectTab;

	// New Project Button
	@FindBy(xpath = "//a[@class='btn btn-primary hidden-xs top-action-btn']")
	@CacheLookup
	WebElement newProjectButton;

	// Select Client click
	@FindBy(xpath = "//div[@class='modal-body paxl-sm']//div//div[@class='mbxl']//div//div[@class='css-16pqwjk-indicatorContainer Select__indicator Select__dropdown-indicator']//*[local-name()='svg']")
	@CacheLookup
	WebElement clientSelectClick;

	// Select Client
	@FindBy(xpath = "//div[@class='modal-body paxl-sm']//div//div[@class='mbxl']//div//div[@class='css-1hwfws3 Select__value-container']")
	@CacheLookup
	WebElement clientSelect;

	// Click Create Project Button
	@FindBy(xpath = "//a[@class='btn btn-md btn-block btn-primary']")
	@CacheLookup
	WebElement createPro;
	
	// Click Client
	@FindBy (xpath = "/html[1]/body[1]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	@CacheLookup
	WebElement clickClient;

	// Click Client Name
	@FindBy(xpath = "//div[@class='mbxl']//input[@placeholder='Jane Smith']")
	@CacheLookup
	WebElement clkClientName;
	
	
	// Click Client Email
	@FindBy(xpath = "//input[@placeholder='new@email.com']")
	@CacheLookup
	WebElement clkClientEmail;
	
	// Click Project Name
	@FindBy(xpath = "//input[@placeholder='Homepage Redesign']")
	@CacheLookup
	WebElement clkProjectName;

	// Click Hourly Rate
	@FindBy(xpath = "//div[@class='modal-checkbox-label']")
	@CacheLookup
	WebElement clkHrRate;
	
	// Choose Hourly Rate
	@FindBy(xpath = "//input[@placeholder='60.00']")
	@CacheLookup
	WebElement choseHrRate;
	
	//Click Create Project Button
	@FindBy(xpath = "//a[@class='btn btn-md btn-block btn-primary']")
	@CacheLookup
	WebElement clkCreateProjectButton;
	
	//Client Already Exist Message
	@FindBy(xpath = "//*[@id=\"modal-new-project\"]/div/div/div/div[2]/div/form/div[1]")
	@CacheLookup
	String newClientExist = "The new client you are trying to add is already your client.";
	WebElement clientExist;
	

	public void projectTb() {
		projectTab.click();
	}

	public void newProject() {
		newProjectButton.click();
	}
	
	public void clickClient() {
		clickClient.click();
	}

	public void clientSelection(String client, String clientEmail, String prjName, String hourlyRate) {
		clkClientName.clear();
		clkClientName.sendKeys(client);
		clkClientEmail.clear();
		clkClientEmail.sendKeys(clientEmail);
		clkProjectName.clear();
		clkProjectName.sendKeys(prjName);
		clkHrRate.click();
		choseHrRate.clear();
		choseHrRate.sendKeys(hourlyRate);
		clkCreateProjectButton.click();
	}
	
	public String clientExist() {
		return newClientExist;
	}
	
	
	
	
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////

     
}
