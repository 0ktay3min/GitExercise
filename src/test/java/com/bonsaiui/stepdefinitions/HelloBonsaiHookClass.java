package com.bonsaiui.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.bonsaiui.utilities.BonsaiDrivers;
import com.bonsaiui.utilities.BonsaiUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HelloBonsaiHookClass {
	
	ExtentTest test;

	// To control the flow of application before scenarios and after scenarios
	// TestNG we call this as base class
	@Before
	public void setupBonsaiAppication() {
		//Setup driver and chose from properties(Java), and also works with K, V pair (Map, such as in parameters TestNG)
		BonsaiDrivers.chooseDriver();
		BonsaiUtils.endExtentReport();
		BonsaiDrivers.getDriverReference().manage().window().maximize();
		BonsaiDrivers.getDriverReference().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDownBonsaiApplication(Scenario scenario) {
		 BonsaiUtils.getScreenShot();
	        BonsaiDrivers.closeDriver();
	        BonsaiUtils.endExtentReport();

	    	test.log(LogStatus.PASS, "Iframe scenario Passed");
			test.log(LogStatus.FAIL, "Iframe scenario Failed");
			test.log(LogStatus.SKIP, "Iframe scenario Skipped");
			test.log(LogStatus.INFO, "Jira Ticket and User Story");
		
		//Scenario allows writing text and embedding media into reports, as well as inspection results (in an After block)
		//If any scenario is failed, then take a screenshot.
		if(scenario.isFailed()) {
			
			final byte[] screenshot = ((TakesScreenshot)BonsaiDrivers.getDriverReference()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");			
		}
		BonsaiDrivers.closeDriver();
		
	}
}
