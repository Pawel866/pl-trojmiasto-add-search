package wyszukiwarka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

	private final WebDriver driver;
	private CarAdvertisingPage carAdvertisingPage;
	private SellCarPage sellCarPage;
	private SearchResultsPage searchResultsPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public CarAdvertisingPage getcarAdvertisingPage() {
		if (carAdvertisingPage == null) {
			carAdvertisingPage = PageFactory.initElements(driver, CarAdvertisingPage.class);
		}
		return carAdvertisingPage;
	}

	public SellCarPage getsellCarPage() {
		if (sellCarPage == null) {
			sellCarPage = PageFactory.initElements(driver, SellCarPage.class);
		}
		return sellCarPage;
	}

	public SearchResultsPage getsearchResultsPage() {
		if (searchResultsPage == null) {
			searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
		}
		return searchResultsPage;
	}

}
