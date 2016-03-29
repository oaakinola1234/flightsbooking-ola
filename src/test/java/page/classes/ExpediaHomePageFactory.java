package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExpediaHomePageFactory {
	WebDriver driver;
	
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
	}
	
	public void selectAdultsOnFlight(WebDriver driver, String numOfAdults){
		Select selAdultsOnFlight = new Select(adultsOnFlightDropDown);
		selAdultsOnFlight.selectByValue(numOfAdults);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
