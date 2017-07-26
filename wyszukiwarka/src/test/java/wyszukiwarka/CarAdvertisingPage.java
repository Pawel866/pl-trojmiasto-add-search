package wyszukiwarka;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarAdvertisingPage {

	@FindBy(xpath = ".//*[@id='searchbox-form']/div/div[3]/ul/li[1]")
	private WebElement carKindDrop;

	@FindBy(xpath = ".//*[@id='field_rodzaj_auta_chosen']/a/span")
	private WebElement pickCarBrandDisabled;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div/div[3]/ul/li[2]")
	private WebElement pickCarBrandDrop;

	@FindBy(xpath = ".//*[@id='field_marka_chosen']/div/div/input")
	private WebElement insertCarBrandText;

	@FindBy(xpath = ".//*[@id='field_marka_chosen']/div/ul/li")
	private WebElement clickCarBrandField;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div/div[3]/ul/li[3]")
	private WebElement pickCarModelDrop;

	@FindBy(xpath = ".//*[@id='field_model_chosen']/div/div/input")
	private WebElement insertCarModelText;

	@FindBy(xpath = ".//*[@id='field_model_chosen']/div/ul/li")
	private WebElement clickCarModelField;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div[1]/div[3]/ul/li[9]/div/p/span")
	private WebElement pickEnginFuelDrop;

	@FindBy(css = ".opt>label")
	private List<WebElement> pickEnginFuelSelect;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div[1]/div[5]/ul/li[1]/label[14]")
	private WebElement pickAirCondition;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div[1]/div[3]/ul/li[5]/input[1]")
	private WebElement productionYearGreaterThenInput;

	@FindBy(id = "location_map_selector_1")
	private WebElement clickMapLink;

	@FindBy(className = "ui-tabs-anchor")
	private List<WebElement> findAllCity;

	@FindBy(className = "location_select_all")
	private List<WebElement> clickCity;

	@FindBy(xpath = ".//*[@id='location_select_box_1']/div[2]/a")
	private WebElement clickMapSearch;

	@FindBy(xpath = ".//*[@id='searchbox-form']/div[2]/input")
	private WebElement searchButton;

	WebDriverWait element;

	public CarAdvertisingPage(WebDriver driver) {
		element = new WebDriverWait(driver, 20);
	}

	private void sleepTime(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getBrand(String carBrand) {
		getPickCarBrandDrop();
		getInsertCarBrandText(carBrand);
		getClickCarBrandField();
		sleepTime(3000);
	}

	private void getPickCarBrandDrop() {
		element.until(ExpectedConditions.elementToBeClickable(pickCarBrandDrop)).click();
	}

	private void getInsertCarBrandText(String carBrand) {
		element.until(ExpectedConditions.elementToBeClickable(insertCarBrandText)).sendKeys(carBrand);
	}

	private void getClickCarBrandField() {
		element.until(ExpectedConditions.elementToBeClickable(clickCarBrandField)).click();
	}

	public void getModel(String carModel) {
		getPickCarModelDrop();
		getInsertCarModelText(carModel);
		getClickCarModelField();
		sleepTime(3000);
	}

	private void getPickCarModelDrop() {
		element.until(ExpectedConditions.elementToBeClickable(pickCarModelDrop)).click();
	}

	private void getInsertCarModelText(String carModel) {
		element.until(ExpectedConditions.elementToBeClickable(insertCarModelText)).sendKeys(carModel);
	}

	private void getClickCarModelField() {
		element.until(ExpectedConditions.elementToBeClickable(clickCarModelField)).click();
	}

	public void getEngine(String type) {
		getEnginFuelDrop();
		getSelectEngineFuel(type);
		getEnginFuelDrop();
	}

	private void getEnginFuelDrop() {
		element.until(ExpectedConditions.elementToBeClickable(pickEnginFuelDrop)).click();
	}

	private void getSelectEngineFuel(String engType) {
		for (WebElement x : pickEnginFuelSelect)
			if ((x.getText().matches(engType)) == true) {
				x.click();
			}
	}

	public void getPickAirCondition() {
		pickAirCondition.click();
	}

	public void getProductionYearGreaterThenInput(String minProdYear) {
		productionYearGreaterThenInput.sendKeys(minProdYear);
	}

	public void getMap(String searCity) {
		getClickMapLink();
		getFindCity(searCity);
		getClickCity(searCity);
		getClickMapSearch();
	}

	private void getClickMapLink() {
		clickMapLink.click();
	}

	private void getFindCity(String searchCity) {
		for (WebElement x : findAllCity)
			if ((x.getText().matches(searchCity)) == true) {
				x.click();
			}
	}

	private void getClickCity(String searchCity) {
		for (WebElement x : clickCity) {
			if ((x.getText().contains(searchCity)) == true) {
				x.click();
			}
		}
	}

	private void getClickMapSearch() {
		clickMapSearch.click();
	}

	public void getSearchButton() {
		searchButton.click();
	}
}
