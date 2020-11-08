package com.bonsaiui.stepdefinitions;

import java.util.List;
import java.util.Map;

import com.bonsaiui.pages.BonsaiSignUpPage;
import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;

import io.cucumber.java.en.*;

public class AsMaps {
	
	@When("I am on bonsai")
	public void i_am_on_bonsai() {
		BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("bonsaisignupurl"));
		
	}

	@When("I use following credentials to creaate a new registry")
	public void i_use_following_credentials_to_creaate_a_new_registry(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		BonsaiSignUpPage sgnUpPage = new BonsaiSignUpPage();
	    List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
	    sgnUpPage.bonsaiSignUp(list.get(0).get("email"), list.get(0).get("name"), list.get(0).get("password"));
	    
	}

	
	
}
