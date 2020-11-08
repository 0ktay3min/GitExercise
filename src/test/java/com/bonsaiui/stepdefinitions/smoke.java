package com.bonsaiui.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class smoke {

@When("I am on bonsai web page")
public void i_am_on_bonsai_web_page() {
	WebDriver driver = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	driver.get("https://app.hellobonsai.com/users/sign_in");
}

@When("I use following credentials to creaate a new registry window")
public void i_use_following_credentials_to_creaate_a_new_registry_window(io.cucumber.datatable.DataTable dataTable) {
    
}
	
	

}
