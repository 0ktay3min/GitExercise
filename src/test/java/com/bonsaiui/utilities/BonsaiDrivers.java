package com.bonsaiui.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BonsaiDrivers {

	// Singelton pattern is when Constructor and class level variable to be private
	// Constructor
	public BonsaiDrivers() {
	}

	// class level variable
	private static WebDriver driver;

	public static WebDriver getDriverReference() {
		// returning driver instance
		return driver;
	}

	// Static variables can be used by Static Methods.
	// Static Methods will not create object in the memory
	// mostly used ones are Thread.sleep, main method and many more. They help us
	// optimize applications run time.
	// Static methods will not depend on memory since we do not create an object.
	public static WebDriver chooseDriver() {

		if (driver == null) {
			switch (BonsaiConfigurationReader.getProperty("browser")) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}

		driver.manage().window().maximize();
		return driver;
	}
	
	//I will call this method inside after hook class. 
	public static void closeDriver() {
		driver.close();
		driver.quit();
		driver = null; //this will force the driver to be null. When browser is closed, we need to make sure driver is null again for the next case.
		
	}

}
