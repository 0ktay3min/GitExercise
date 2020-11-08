package com.bonsaiui.stepdefinitions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class windowHandles {

	@When("User is on page")
	public void user_is_on_page() {
		BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("windowhandleurl"));
	}

	@When("User get current window handle and print it")
	public void user_get_current_window_handle_and_print_it() {
		String parentWindow = BonsaiDrivers.getDriverReference().getWindowHandle();
		System.out.println(parentWindow);
	}

	@When("User opens a new window and switches to new window")
	public void user_opens_a_new_window_and_switches_to_new_window() {
		String currentWindow = BonsaiDrivers.getDriverReference().getWindowHandle();
		WebElement newBrowserButton = BonsaiDrivers.getDriverReference().findElement(By.id("win1"));
		newBrowserButton.click();
		Set<String> allWindows = BonsaiDrivers.getDriverReference().getWindowHandles();
		
		for(String handle : allWindows) {
			if (!handle.equals(currentWindow)) {
				BonsaiDrivers.getDriverReference().switchTo().window(handle);
				System.out.println(BonsaiDrivers.getDriverReference().getTitle());
				BonsaiDrivers.closeDriver();
			}
		}
	}

	@Then("User get backs to parent window")
	public void user_get_backs_to_parent_window() {
		String currentWindow = BonsaiDrivers.getDriverReference().getWindowHandle();
	//	BonsaiDrivers.getDriverReference().switchTo(currentWindow);

	}

}
