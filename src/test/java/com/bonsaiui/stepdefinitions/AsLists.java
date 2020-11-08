package com.bonsaiui.stepdefinitions;

import java.util.List;

import com.bonsaiui.pages.BonsaiSignUpPage;
import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;

import io.cucumber.java.en.*;

public class AsLists {

	@Given("User is on Bonsai signup page")
	public void user_is_on_Bonsai_signup_page() {
		BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("bonsaisignupurl"));
	}

	@Given("User creates new account with below credentials")
	public void user_creates_new_account_with_below_credentials(io.cucumber.datatable.DataTable dataTable) {
		BonsaiSignUpPage bsnm = new BonsaiSignUpPage();
		List<List<String>> list = dataTable.asLists(String.class);
		
		for (int i = 0; i < list.size(); i++) {
			bsnm.bonsaiSignUp(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2));
			System.out.println(list.get(i).get(0));			
		}
		
	}

}
