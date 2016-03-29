package TestCases;

import org.testng.annotations.Test;

import page.classes.ExpediaHomePageFactory;
import utilities.Constants;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class selectFlights {
	
	public WebDriver driver;
	ExpediaHomePageFactory expediaHomePage;
	static Logger log = Logger.getLogger(selectFlights.class);
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		driver.get(Constants.URL);
	}
	

}
