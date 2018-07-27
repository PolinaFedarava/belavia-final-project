package tests;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;

public class TestOne {

	private Steps steps;
	private final String FROM_CITY = "Minsk";
	private final String TO_CITY = " Riga";

	@BeforeMethod(description="Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	 
	@Test
	public void checkAvgPricePositive () throws InterruptedException {
		steps.requestFlightDetails(FROM_CITY, TO_CITY);
;
		
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
	}
