package TestCases;

import org.testng.annotations.Test;

import page.classes.ExpediaHomePageFactory;
import utilities.Constants;
import utilities.ExcelUtility;
import utilities.Screenshot;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selectFlights {

	private WebDriver driver;
	private String baseURL;
	ExpediaHomePageFactory expediaHomePage;
	static Logger log = Logger.getLogger(selectFlights.class);

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://www.expeida.co.uk";
		expediaHomePage = new ExpediaHomePageFactory(driver);

		driver.manage().window().maximize();
		PropertyConfigurator.configure("log4j.properties");
		driver.get(Constants.URL);
		// Tell the code about the location of Excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "flightsSearch");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		driver.get(Constants.URL);
	}

	@DataProvider(name = "searchFlightsData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("searchFlightsDataExcel");
		return testData;
	}

	@Test(dataProvider = "searchFlightsData")
	public void simpleFlightTest(String originCity, String destinationCity, String departureDate, String returnDate,
			String numOfAdults) throws Exception {
		expediaHomePage.simpleFlight(originCity, destinationCity, departureDate, returnDate, numOfAdults);
	}

	@Test
	public void firstTestMethod() {
		System.out.println("First test method");
	}

	@Test
	public void secondTestMethod() {
		System.out.println("Second test method");
	}

}
