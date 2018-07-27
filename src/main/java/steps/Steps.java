package steps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import driverSingleton.DriverSingleton;
import pages.CalendarPage;
import pages.MainPage;

public class Steps {
private WebDriver driver;
	
	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}
	
	public void closeDriver() {
		DriverSingleton.getDriver();
	}
	
	public void requestFlightDetails(String fromCountry, String toCountry) throws InterruptedException {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.populateFromForm(fromCountry);
		mainPage.populateToForm(toCountry);
		mainPage.selectOneWayTripType();
		mainPage.selectCurrentDepartureDate();
		mainPage.searchResults();
		System.out.println("Flight details");
	}

	
	@SuppressWarnings("null")
	public List<Double> getPrices(List<String> fullPricesList){
		
		List<Double> prices  = null;
		Iterator<String> it = fullPricesList.iterator();
		
		while(it.hasNext()) {
			prices.add(Double.parseDouble(it.next().split(" ")[0]));
		}
		
		System.out.println("Prices have been collected!! :)");
		return prices;
	}
	


}
