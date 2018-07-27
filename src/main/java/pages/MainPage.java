package pages;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage {
	
	private static final String BASE_URL = "https://belavia.by/";
	
	private static final String DEPARTURE_COUNTRY_ID = "OriginLocation_Combobox";
	private static final String ARRIVAL_COUNTRY_ID = "DestinationLocation_Combobox";
	private static final String ONE_WAY_TICKET_XPATH = "//label[@for='JourneySpan_Ow']";
	private static final String RETURN_TICKET_XPATH = "//label[@for='JourneySpan_Rt']";
	private static final String DEPARTURE_DATE_INPUT_XPATH = "//input[@id='DepartureDate_Datepicker']/../a";
	private static final String CALENDAR_NEXT_XPATH = "//*[@id='calendar']/div/div[2]/div/a";
	private static final String SUBMIT_BUTTON_XPATH = "//*[@id='step-2']/div[4]/div/button";
	private static final String DATE_XPATH = "//td[@data-month='%d'][@data-year='%d']/a[text()='%d']";
	
	@FindBy(id = DEPARTURE_COUNTRY_ID)
	private WebElement departureCountryCombobox;

	@FindBy(id = ARRIVAL_COUNTRY_ID)
	private WebElement arrivalCountryCombobox;

	@FindBy(xpath = ONE_WAY_TICKET_XPATH)
	private WebElement oneWayTicketRadioButton;

	@FindBy(xpath = RETURN_TICKET_XPATH)
	private WebElement returnTicketRadioButton;

	@FindBy(xpath = DEPARTURE_DATE_INPUT_XPATH)
	private WebElement departureDateInput;

	@FindBy(xpath = CALENDAR_NEXT_XPATH)
	private WebElement calendarNextMonthButton;

	@FindBy(xpath = SUBMIT_BUTTON_XPATH)
	private WebElement submitButton;
	
	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void populateFromForm(String fromCountry) {
		departureCountryCombobox.sendKeys(fromCountry);
		departureCountryCombobox.sendKeys(Keys.RETURN);
		System.out.println("Origin country");
	}
	
	public void populateToForm(String toCountry) {
		arrivalCountryCombobox.sendKeys(toCountry);
		arrivalCountryCombobox.sendKeys(Keys.RETURN);
		System.out.println("Destination country");
	}
	
	public void selectOneWayTripType() {
		oneWayTicketRadioButton.click();
		System.out.println("One way");
	}
	
	public void selectCurrentDepartureDate() throws InterruptedException {
		departureDateInput.click();
		Thread.sleep(2000);
		departureDateInput.click();
		System.out.println("date");
	}
	
	public void searchResults() {
		submitButton.click();
		System.out.println("Submit button");
	}
	
	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}
