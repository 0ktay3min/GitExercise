package com.bonsaiui.utilities;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BonsaiUtils {
	/*
	 * System.out.println will not return anything in a report. I want to prove what
	 * has been tested for last 2 days. Traceibility: You can mark your test cases,
	 * you won't check it second time. ("Is missing test data") QA manager can see
	 * what has been tested. All features of Sprint is logged (StepDefinitions
	 * belong to Scenario, and it belongs to user story. Log4J, Extend Logger, Excel
	 * (%70), Extent Report, Extend Logger, and Extent Test Extent Report start and
	 * end methods are placed in hook class Flush() extent report to create reports!
	 */
	public static ExtentReports report;
	public static ExtentTest test;


	/*
	 * Screenshot: TakeScreenshot from Selenium Apache Commons, to store those as
	 * file I'll give a target file to create a screenshots, because this file will
	 * be created after test
	 */
	public static String getScreenShot() {
		// Date Format
		String date = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		// To Take Screenshot
		TakesScreenshot ts = (TakesScreenshot) BonsaiDrivers.getDriverReference();
		File src = ts.getScreenshotAs(OutputType.FILE);
		String target = System.getProperty("user.dir") + ("/Test-output/bonsaitscreenshots " + date + ".png");
		File destination = new File(target);

		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return target;
	}

	public static void RestEssured() {
		
	}
	
	public static void extentReportStart(String testCycle) {

		// We are writing Java Date method to grab current date
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		// ExtentReports create .html report
		String targetExtent = System.getProperty("user.dir") + "\\ExtendReportResults" + date + testCycle + ".html";

		// Object creation is done by new word.
		report = new ExtentReports(targetExtent);

		// When extent report is created, it will be named as "Bonsai Version 2.03"
		test = report.startTest("BONSAI VERSION 2.03");
		// This will also be added to the report
		report.addSystemInfo("Bonsai", "Sprint6March2020").addSystemInfo("Regression", "Jenkins")
				.addSystemInfo("Oktay Emin", "oktay.emin@gmail.com");

	}

	public static void endExtentReport() {

		// I need too call this method at @After annotation in Hook.class
		report.endTest(test);
		// Appends the HTML file with all the ended tests. There must be at least 1
		// ended testfor anything to be appended to the report.
		report.flush();
	}

	/*
	 * How to pause Test Executions Q: We use Thread.sleep() -> which is a static
	 * method. Through.sleep trows checked exception.
	 * 
	 * Q:Can we overload Main method? A:Featured snippet from the web Yes, you can
	 * have as many main methods as you like. You can have main methods with
	 * different signatures from main(String[]) which is called overloading, and the
	 * JVM will ignore those main methods. You can have one public static void
	 * main(String[] args) method in each class. Some people use those methods for
	 * testing. Q:Log4j --> keeps log (instead of using also which is not possible,
	 * we have logs
	 */

	public static void pauseTestExecutions(int sec) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

		}
	}

	/*
	 * waitTimes
	 */
	public static void waitWithACondition() {
		Wait wait = new FluentWait<>(BonsaiDrivers.getDriverReference()).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5000)).ignoring(NoSuchElementException.class)
				.ignoring(ElementNotVisibleException.class).ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class).ignoring(WebDriverException.class);
	}

	/*
	 * VerifyAlert Method Implicit Wait = Waiting for WebElements to be visible. It
	 * is equal to PageLoad. All elements might be loaded with implicitwait, bu page
	 * is not totally loaded yet.
	 */
	public boolean verifyAlert() {
		try {
			BonsaiDrivers.getDriverReference().switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			System.out.println(e.getStackTrace());
		}
		return false;

	}

	/*
	 * JavascriptExecuter is being used for AJAX applications which selenium is not
	 * efficient enougth Selenium is not all time efficient in AJAX , angular,
	 * javascript FrameWork node js(mocha, chai ... ) Click, input (sendKeys)
	 * functions not operating well with selenium sendkeys, xpath it is not working.
	 * JAvaScriptExecuter to handle javascriots requests. JavascriptExecuter is an
	 * alternative way of doing sendkeys and click, scrolldown etc.... AJAX is
	 * developer's dream
	 */
	public static void clickWithJAvaScript(WebElement element) {
		// this will click to the element that Selenium can't handle
		((JavascriptExecutor) BonsaiDrivers.getDriverReference()).executeScript("arguments [0].click();", element);
		// this will scroll down the page and which Selenium can't handle
		((JavascriptExecutor) BonsaiDrivers.getDriverReference()).executeScript("arguments [0].scroolIntoView(true);",
				element);
	}

	/*
	 * Extract text (String) from list of WebElements, texts from web elements.
	 * Array VS ArraayList Array is fixed size, meaning once created it the size can
	 * not be changed. ArrayList is sizeable.
	 */
	public List<String> extraText(By locator) {
		List<WebElement> elems = BonsaiDrivers.getDriverReference().findElements(locator);
		List<String> elementTexts = new ArrayList<>();
		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elementTexts.add(el.getText());
			}
		}
		return elementTexts;
	}

	/*
	 * KeyBoard actions we can use Robot class Bank tellers they use mostly keyboard
	 * for any operation, they do not use mouse that much. If your application
	 * depends on keyboard, you are most likely to use Robot class. Register a user
	 * and fill out form. We use Robot class to imitate user actions. Tab, Down, Up,
	 * right, Left, moveTo(40,80)
	 */
	public static void enterWithRobotclass(int vkDown) {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_UP);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
		
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getStackTrace());
		}
	}
	
	
	// This method will press down key 1 time, up key 1 time then enter
	public static void actions() {
		Actions act = new Actions(BonsaiDrivers.getDriverReference());
		act.sendKeys(Keys.chord(Keys.DOWN, Keys.UP, Keys.ENTER)).build().perform();
	}


	/*
	 * Write a method that verifyElementDisplayed If displayed print (visible) if
	 * not print(is not visible)
	 */
	public static void verifyElementIsDisplayed(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println(element.getText() + " is visible on Bonsai Login page");
		} else {
			System.out.println(element.getText() + " is not visible on Bonsai Login Page");
		}

	}

	/*
	 * Verify ElementIsNotVisible (String xpath) All elements and check if they are
	 * not visible.
	 */
	public static void verifyElementIsNotVisible(String xpath) {
		List<WebElement> listOfElems = BonsaiDrivers.getDriverReference().findElements(By.xpath(xpath));
		for (WebElement elmnt : listOfElems) {
			if (elmnt == null) {
				System.out.println("Element is not visible");
			} else {
				System.out.println("Element is visible");
			}
		}
	}

	/*
	 * Method waits for WebElement to be visible on the page WebDriverWait and then
	 * our expected condition is element to be visible (Visibilityofelement)
	 */

	public static WebElement visibilityOfWebElement(WebElement element, int timeOutInSec) {
		WebDriverWait wait = new WebDriverWait(BonsaiDrivers.getDriverReference(), timeOutInSec);

		return wait.until(ExpectedConditions.visibilityOf(element));
		// wait.until(ExpectedConditions.elementToBeClickable(element));
		// wait.until(ExpectedConditions.elementToBeSelected(element));

	}

	/*
	 * MEthod wait for proper/correct pagetitle. PageTitle should be passes as a
	 * parameter to the method. Expected condition equals to pagetitle parameter
	 */
	public static void pageTitleVerification(String title) {
		WebDriverWait wait = new WebDriverWait(BonsaiDrivers.getDriverReference(), 10);

		wait.until(ExpectedConditions.titleIs(title));
		// wait.until(ExpectedConditions.titleContains(title));
	}

	/*
	 * MEthod that take WebElements and convert it to List of Strings List of
	 * String, (List of WebElements) List<String> will convert to ArrayList
	 * ListOfWebElements -> User needs to provide this in test case so we can put it
	 * as a method parameter.
	 */
	public static List<String> getAllStrings(List<WebElement> listOfWebElements) {
		List<String> listOfStrings = new ArrayList<>();

		for (WebElement element : listOfWebElements) {
			String value = element.getText().trim();

			// If there is no Text in WebElements that we are looping, do not add this black
			// text into the list
			if (value.length() > 0) {
				listOfStrings.add(value);
			}
		}
		return listOfStrings;
	}

}
