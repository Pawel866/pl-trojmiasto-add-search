package wyszukiwarka;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage {
	@FindBy(css = ".ogl-head>h2>a")
	private List<WebElement> searchResultsCarList;

	public void getsearchResultsCarList() {
		for (WebElement x : searchResultsCarList) {
			x.click();
		}
	}
}
