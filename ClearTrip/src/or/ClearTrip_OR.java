package or;

import java.util.List;

import org.apache.log4j.pattern.ClassNamePatternConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearTrip_OR {
	 WebDriver driver;

/****** Clear Trip Locators *********/	
	@FindBy(id="RoundTrip") protected WebElement roundTripRadioBtn;
	@FindBy(id="OneWay") protected WebElement oneWayTripRadioBtn;
	@FindBy(id="MultiCity") protected WebElement mutliCityTripRadioBtn;
	
	@FindBy(id="FromTag") protected WebElement from_City;
	@FindBy(id="ToTag") protected WebElement to_City;
	@FindBy(id="Adults") protected WebElement tickets_Adults;
	@FindBy(id="Childrens") protected WebElement tickets_Childrens;
	@FindBy(id="SearchBtn") protected WebElement searchFlightBtn;
	@FindBy(id="ReturnDate") protected WebElement returnDate;
	@FindBy(id="DepartDate") protected WebElement departDate;
	
	
 }

