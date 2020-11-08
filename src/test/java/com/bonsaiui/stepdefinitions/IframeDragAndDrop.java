package com.bonsaiui.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IframeDragAndDrop {
	ExtentTest test;
	ExtentReports report;
	
	
	@When("User on jquery")
	public void user_on_jquery() {
	BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("jqueryurl"));
		
	}

	@When("User drags anddrops handling iframe")
	public void user_drags_anddrops_handling_iframe() {
		/*Action Class
		 * 1-Drag and Drop, double click, mousehover, move to element, scroll
		 * 
		 */
		
		Actions act = new Actions(BonsaiDrivers.getDriverReference());
		WebDriverWait wait = new WebDriverWait(BonsaiDrivers.getDriverReference(), 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='demo-frame']")));
		//WebElement iframe = BonsaiDrivers.getDriverReference().findElement(By.tagName("iframe"));
		//BonsaiDrivers.getDriverReference().switchTo().frame(iframe);
		WebElement from = BonsaiDrivers.getDriverReference().findElement(By.id("draggable"));
		WebElement to = BonsaiDrivers.getDriverReference().findElement(By.id("droppable"));
		act.dragAndDrop(from, to).build().perform();
		
		test.log(LogStatus.PASS, "Iframe scenario Passed");
		test.log(LogStatus.FAIL, "Iframe scenario Failed");
		test.log(LogStatus.SKIP, "Iframe scenario Skipped");
		test.log(LogStatus.INFO, "Jira Ticket and User Story");
	}

	@Then("Target item should be dropped")
	public void target_item_should_be_dropped() {
System.out.println("Grag and drop is successful");


	
}
}