package wyszukiwarka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SellCarPage {
	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[3]/div[2]")
	private WebElement getBrandName;

	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[4]/div[2]")
	private WebElement getMarkName;

	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[6]/div[2]")
	private WebElement getYearProd;

	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[11]/div[2]")
	private WebElement getFuelType;

	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[17]/div[2]/ul/li[5]/span")
	private WebElement getAirCondInfo;

	@FindBy(xpath = ".//*[@id='sidebar']/div[1]/div[18]/div[2]")
	private WebElement getCityInfo;

	@FindBy(xpath = ".//*[@id='body']/div[5]/a")
	private WebElement returnToSearchResultsPage;

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isAllDataWalid(String brand, String mark, String year, String fuel, String airCond, String city) {
		boolean isCarOK = false;
		if (isBrandNameValid(brand) == true) {
			if (isCarMarkValid(mark) == true) {
				if (isProductionYearValid(year) == true) {
					if (isFuelValid(fuel) == true) {
						if (isAirCondPresentValid(airCond) == true) {
							if (isCityValid(city) == true) {
								isCarOK = true;
							}
						}
					}
				}
			}
		}
		return isCarOK;

	}

	private final CustomFluentWait customFluentWait;
	private static final int DEFAULT_TIMEOUT = 20;

	public SellCarPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	private boolean isBrandNameValid(String brand) {
		boolean brandValid = false;
		customFluentWait.waitForElementDisplayed(getBrandName, DEFAULT_TIMEOUT);
		String brandName = getBrandName.getText().toLowerCase();
		if (brandName.contains(brand.toLowerCase())) {
			brandValid = true;
		}
		return brandValid;
	}

	private boolean isCarMarkValid(String mark) {
		boolean markValid = false;
		customFluentWait.waitForElementDisplayed(getMarkName, DEFAULT_TIMEOUT);
		String carMark = getMarkName.getText().toLowerCase();
		if (carMark.equals(mark.toLowerCase())) {
			markValid = true;
		}
		return markValid;
	}

	private boolean isProductionYearValid(String year) {
		boolean yearValid = false;
		String yearV = getYearProd.getText().substring(0, 4);
		if ((Integer.parseInt(yearV)) >= (Integer.parseInt(year))) {
			yearValid = true;
		}
		return yearValid;
	}

	private boolean isFuelValid(String fuel) {
		boolean fuealValid = false;
		String fuelV = getFuelType.getText().toLowerCase();
		if (fuelV.contains(fuel.toLowerCase())) {
			fuealValid = true;
		}
		return fuealValid;
	}

	private boolean isAirCondPresentValid(String airCond) {
		boolean airCondValid = false;
		String airV = getAirCondInfo.getText().toLowerCase();
		if (airV.contains(airCond.toLowerCase())) {
			airCondValid = true;
		}
		return airCondValid;
	}

	private boolean isCityValid(String city) {
		boolean cityValid = false;
		String cityV = getCityInfo.getText().toUpperCase();
		if (cityV.contains(city.toUpperCase())) {
			cityValid = true;
		}
		return cityValid;
	}

	public void returnToSearchResultsPage() {
		returnToSearchResultsPage.click();
	}
}
