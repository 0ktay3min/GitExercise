package com.bonsaiui.stepdefinitions;

import java.util.List;

import com.bonsaiui.pages.BonsaiLogInPage;
import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;

import io.cucumber.java.en.Given;

public class BonsaiSecondTest {
	
	@Given("User opens bonsai application")
	public void user_opens_bonsai_application() {
		 BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("url"));
		
	}

	@Given("User logins with following credentials")
	public void user_logins_with_following_credentials(io.cucumber.datatable.DataTable dataTable) {
	   
		//This will create a list for username and password
		List<String> list = dataTable.asList(String.class);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		
		BonsaiLogInPage bsn = new BonsaiLogInPage();
		bsn.loginBonsai(list.get(0), list.get(1));
	}
}
