package TestCases;

import org.testng.annotations.Test;

import page.classes.ExpediaHomePageFactory;
import utilities.Constants;
import utilities.ExcelUtility;
import utilities.Screenshot;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selectFlights {
	
	private WebDriver driver;
	private Screenshot screenshot;
	private String baseURL;
	ExpediaHomePageFactory expediaHomePage;
	static Logger log = Logger.getLogger(selectFlights.class);
	
	@BeforeClass
	public void beforeClass() throws Exception{
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
	public void beforeMethod(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException{
		driver.get(Constants.URL);
		
	}
	
	@DataProvider(name = "searchFlightsData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("searchFlightsDataExcel");
		return testData;
	}
	
	@Test(dataProvider="searchFlightsData")
	public void simpleFlightTest(String originCity, String destinationCity, String departureDate, String returnDate, String numOfAdults) throws Exception{
		expediaHomePage.clickFlightsTab();
		expediaHomePage.setOriginCity(originCity);
		expediaHomePage.setDestinationCity(destinationCity);
		expediaHomePage.setDepartureDate(departureDate);
		expediaHomePage.setReturnnDate(returnDate);
		expediaHomePage.selectAdultsOnFlight(numOfAdults);
		expediaHomePage.clickSearchButton();
		boolean isPresent = driver.findElements(By.xpath("//*[@id='acol-interstitial']/h3")).size() > 0;
		if(isPresent){
		System.out.println("Finding the cities");
	}else{
		System.out.println("Something went wrong");
		screenshot = new Screenshot(driver, "C:\\Users\\OlaA\\workspace\\flightsbooking-ola\\");
	}		
		/*{
		System.out.println("Something went wrong");
		String fileName = getRandomString(10) + ".png";
		String directory = "C:\\Users\\OlaA\\workspace\\flightsbooking-ola\\";
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}*/
	}
	
	@Test
	public void firstTestMethod(){
		System.out.println("First test method");
	}
	
	@Test
	public void secondTestMethod(){
		System.out.println("Second test method");
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
