package wyszukiwarka;

import wyszukiwarka.CustomFluentWait;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	private final CustomFluentWait customFluentWait;
	private static final int DEFAULT_TIMEOUT = 20;

	public CarAdvertisingPage(WebDriver driver) {
		customFluentWait = new CustomFluentWait(driver);
	}

	private void sleep(int time) {
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
		sleep(5000);
	}

	private void getPickCarBrandDrop() {
		customFluentWait.waitForElementDisplayed(pickCarBrandDrop, DEFAULT_TIMEOUT);
		pickCarBrandDrop.click();
	}

	private void getInsertCarBrandText(String carBrand) {
		customFluentWait.waitForElementDisplayed(insertCarBrandText, DEFAULT_TIMEOUT);
		insertCarBrandText.sendKeys(carBrand);
	}

	private void getClickCarBrandField() {
		customFluentWait.waitForElementDisplayed(clickCarBrandField, DEFAULT_TIMEOUT);
		clickCarBrandField.click();
	}

	public void getModel(String carModel) {
		getPickCarModelDrop();
		getInsertCarModelText(carModel);
		getClickCarModelField();
		sleep(2000);
	}

	private void getPickCarModelDrop() {
		customFluentWait.waitForElementDisplayed(pickCarModelDrop, DEFAULT_TIMEOUT);
		pickCarModelDrop.click();
	}

	private void getInsertCarModelText(String carModel) {
		customFluentWait.waitForElementDisplayed(insertCarModelText, DEFAULT_TIMEOUT);
		insertCarModelText.sendKeys(carModel);
	}

	private void getClickCarModelField() {
		customFluentWait.waitForElementDisplayed(clickCarModelField, DEFAULT_TIMEOUT);
		clickCarModelField.click();
	}

	public void getEngine(String type) {
		getEnginFuelDrop();
		getSelectEngineFuel(type);
		getEnginFuelDrop();
	}

	private void getEnginFuelDrop() {
		customFluentWait.waitForElementDisplayed(pickEnginFuelDrop, DEFAULT_TIMEOUT);
		pickEnginFuelDrop.click();
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
			customFluentWait.waitForElementDisplayed(x, DEFAULT_TIMEOUT);
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
