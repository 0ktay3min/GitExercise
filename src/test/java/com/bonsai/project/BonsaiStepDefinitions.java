package com.bonsai.project;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bonsaiui.pages.BonsaiLogInPage;
import com.bonsaiui.utilities.BonsaiConfigurationReader;
import com.bonsaiui.utilities.BonsaiDrivers;
import com.bonsaiui.utilities.BonsaiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BonsaiStepDefinitions extends BonsaiUtils {
	BonsaiLogInPage loginPage;

	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
		BonsaiDrivers.chooseDriver();
		// To start Extent Report
		BonsaiUtils.extentReportStart("Exten Report Started");

		// This will initialize BonsaiLoginPage
		loginPage = new BonsaiLogInPage();
	}

	@When("User opens Bonsai URL")
	public void user_opens_Bonsai_URL() {
		BonsaiDrivers.getDriverReference().get(BonsaiConfigurationReader.getProperty("url"));
		
		
	}

	@When("User enters valid login credentials")
	public void user_enters_valid_login_credentials() {
		loginPage.loginBonsai(BonsaiConfigurationReader.getProperty("username"),
				BonsaiConfigurationReader.getProperty("password"));
		loginPage.loginButton();
	}

	@When("User should see Bonsai Dashboard")
	public void user_should_see_Bonsai_Dashboard() {
		BonsaiUtils.pauseTestExecutions(10);

		System.out.println(loginPage.validateLoginPageTitle());
		String title = loginPage.validateLoginPageTitle();
		if (title.contains("My Dashboard - Bonsai")) {
			System.out.println("You are logged in successfully");
		} else {
			BonsaiDrivers.closeDriver();
		}
	}

	@When("User clicks Projects tab")
	public void user_clicks_Projects_tab() {
		loginPage.projectTb();
	}

	@When("User clicks NEW Project tab")
	public void user_clicks_NEW_Project_tab() {
		BonsaiUtils.pauseTestExecutions(5);
		loginPage.newProject();

	}

	@When("User enters new project information and clicks Create Project")
	public void user_enters_new_project_information_and_clicks_Create_Project(
			io.cucumber.datatable.DataTable dataTable) {

		BonsaiUtils.pauseTestExecutions(5);
		loginPage.clickClient();
		BonsaiUtils.enterWithRobotclass(KeyEvent.VK_DOWN);

		BonsaiUtils.actions();
		BonsaiLogInPage clientAdd = new BonsaiLogInPage();
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		clientAdd.clientSelection(list.get(0).get("Client Name"), list.get(0).get("Client Email"),
				list.get(0).get("Project Name"), list.get(0).get("Hourly Rate"));

	}

	@When("User should see newly added Project on the Project List")
	public void user_should_see_newly_added_Project_on_the_Project_List() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (loginPage.clientExist().equals("The new client you are trying to add is already your client.")) {
			BonsaiUtils.getScreenShot();
			BonsaiUtils.endExtentReport();
			BonsaiDrivers.closeDriver();
		} else {
			BonsaiUtils.pageTitleVerification("MAC OSX - Bonsai");
		}

		BonsaiUtils.getScreenShot();
		BonsaiUtils.endExtentReport();
	}

	@Then("User will close browser")
	public void user_will_close_browser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BonsaiDrivers.closeDriver();
	}

}
