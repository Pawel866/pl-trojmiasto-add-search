package wyszukiwarka;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class CustomFluentWait {

	private final WebDriver driver;
	private final int globalTimeoutInSeconds;
	private final int globalPollingInSeconds;

	public CustomFluentWait(WebDriver driver) {
		this.driver = driver;
		this.globalTimeoutInSeconds = 10;
		this.globalPollingInSeconds = 1;
	}

	private FluentWait<WebDriver> getFluentWait(final int timeoutInSeconds, final int pollingInSeconds) {
		return new FluentWait<>(driver).withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingInSeconds, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);
	}

	public void waitForElementDisplayed(final WebElement element) {
		waitForElementDisplayed(element, globalTimeoutInSeconds);
	}

	public void waitForElementDisplayed(final WebElement element, final int timeoutInSeconds) {
		waitForElementDisplayed(element, timeoutInSeconds, globalPollingInSeconds);
	}

	private void waitForElementDisplayed(final WebElement element, final int timeoutInSeconds,
			final int pollingInSeconds) {
		getFluentWait(timeoutInSeconds, pollingInSeconds).until(new Predicate<WebDriver>() {
			@Override
			public boolean apply(WebDriver input) {
				element.isDisplayed();
				return true;
			}
		});
	}

	public boolean isElementPresent(final WebElement element) {
		return isElementPresent(element, globalTimeoutInSeconds);
	}

	public boolean isElementPresent(final WebElement element, final int timeoutInSeconds) {
		try {
			waitForElementDisplayed(element, timeoutInSeconds);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

}
