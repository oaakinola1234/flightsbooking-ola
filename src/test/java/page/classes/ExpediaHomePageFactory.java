package page.classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExpediaHomePageFactory {
	WebDriver driver;
	static Logger log = Logger.getLogger(ExpediaHomePageFactory.class);
	
	@FindBy(id="header-history")
	WebElement headerHistoryLink;
	
	@FindBy(id="tab-flight-tab")
	WebElement flightsTabLink;
	
	@FindBy(id="flight-origin")
	WebElement originCityTextBox;
	
	@FindBy(id="flight-destination")
	WebElement destinationCityTextBox;
	
	@FindBy(id="flight-departing")
	WebElement departureDateTextBoxDatePicker;
	
	@FindBy(id="flight-returning")
	WebElement returnDateTextBoxDatePicker;
	
	@FindBy(id="flight-adults") //drop down 
	WebElement adultsOnFlightDropDown;
	
	@FindBy(id="flight-children") //drop down 
	WebElement childrenOnFlightDropDown;
	
	@FindBy(id="advanced-options")
	WebElement advancedOptionLink;
	
	@FindBy(id="advanced-flight-nonstop")
	WebElement directFlightCheckBox;
	
	@FindBy(id="flight-add-hotel-checkbox")
	WebElement addHotelCheckBox;
	
	@FindBy(id="flight-add-car-checkbox")
	WebElement addCarCheckBox;
	
	@FindBy(id="advanced-flight-refundable")
	WebElement refundableFlightCheckBox;
	
	@FindBy(id="flight-advanced-preferred-airline") //drop down 
	WebElement preferredAirlineDropDown;
	
	@FindBy(id="flight-advanced-preferred-class") //drop down 
	WebElement preferredClassDropDown;
	
	@FindBy(id="search-button")
	WebElement searchButton;
	
	
	public ExpediaHomePageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void clickFlightsTab(){
		headerHistoryLink.click();
		flightsTabLink.click();
		log.info("headerHistoryLink and flightsTabLink clicked");
	}
	
	public void setOriginCity(String originCityValue){
		originCityTextBox.sendKeys(originCityValue);
		log.info("originCityTextBox value set");
	}
	
	public void setDestinationCity(String destinationCity){
		destinationCityTextBox.sendKeys(destinationCity);
		log.info("destinationCityTextBox value set");
	}
	
	public void setDepartureDate(String departureDate){
		departureDateTextBoxDatePicker.sendKeys(departureDate);
		log.info("departureDateTextBoxDatePicker value set");
	}

	public void setReturnnDate(String returnDate){
		returnDateTextBoxDatePicker.sendKeys(returnDate);
		log.info("returnDateTextBoxDatePicker value set");
	}
	
	public void selectAdultsOnFlight(String numOfAdults){
		Select selAdultsOnFlight = new Select(adultsOnFlightDropDown);
		selAdultsOnFlight.selectByValue(numOfAdults);
		log.info("adultsOnFlightDropDown value selected");
	}
	
	public void clickSearchButton(){
		searchButton.click();
		log.info("searchButton clicked");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
