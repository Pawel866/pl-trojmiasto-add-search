package wyszukiwarka;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.easetech.easytest.loader.LoaderType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "SearchTest.xml", loaderType = LoaderType.XML)

public class SearchTest {

	private WebDriver driver;
	private PageObjectManager manager;
	private String url = "http://ogloszenia.trojmiasto.pl/motoryzacja-sprzedam/";

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		manager = new PageObjectManager(driver);
		driver.get(url);
	}

	@Test
	public void audiSearchTest(@Param(name = "brand") String brand, @Param(name = "model") String model,
			@Param(name = "engine") String engineType, @Param(name = "airCon") String airCond,
			@Param(name = "year") String yearGrTh, @Param(name = "city") String scopeCity) {
		manager.getcarAdvertisingPage().getBrand(brand);
		manager.getcarAdvertisingPage().getModel(model);
		manager.getcarAdvertisingPage().getPickAirCondition();
		manager.getcarAdvertisingPage().getEngine(engineType);
		manager.getcarAdvertisingPage().getProductionYearGreaterThenInput(yearGrTh);
		manager.getcarAdvertisingPage().getMap(scopeCity);
		manager.getcarAdvertisingPage().getSearchButton();
		manager.getsearchResultsPage().getsearchResultsCarList();

		assertTrue("SearchTest: The expected value for the SearchTest differs from the actual test result.",
				manager.getsellCarPage().isAllDataWalid(brand, model, yearGrTh, engineType, airCond, scopeCity));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}