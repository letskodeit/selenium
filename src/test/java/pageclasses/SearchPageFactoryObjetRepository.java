package pageclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageFactoryObjetRepository {
	
	@FindBy(id="tab-flight-tab")
	WebElement flightTab;
	
	@FindBy(id="flight-type-roundtrip-label")
	WebElement roundTrip;

	@FindBy(id="flight-type-multi-dest-label")
	WebElement multipleDestination;
	
	public void clickFlightTab() {
		flightTab.click();
	}
	
	public void clickroundTrip() {
		roundTrip.click();
	}
	
	public void clickMultipleDestination() {
		multipleDestination.click();
	}
}
