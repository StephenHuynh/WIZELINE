package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class BasePage {
	protected static final int TIMEOUT = 60;
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// return ResultModel: Is used for report.

	protected void clickOnWebElement(final WebElement webelement, final String elementName) {
		try {
			waitElementVisible(webelement);
			webelement.click();
			System.out.println(String.format("Successfully clicked on the WebElement %s", elementName));
		} catch (Exception e) {
			System.out.println(
					String.format("Unable to click on the WebElement %s. Error: %s", elementName, e.getMessage()));
		}
	}

	protected void sendKeys(final WebElement element, final String elementName, final String inputValue) {
		try {
			waitElementVisible(element);
			element.clear();
			element.sendKeys(inputValue);
			if (elementName.toUpperCase().contains("PASSWORD")) {
				System.out.println(String.format("Successfully entered the text [Password] into %s.", elementName));
			} else {
				System.out
						.println(String.format("Successfully entered the text [%s] into %s.", inputValue, elementName));
			}
		} catch (Exception e) {
			if (elementName.toUpperCase().contains("PASSWORD")) {
				System.out.println(String.format("Unable to enter the text [Password] into %s. Error: %s", elementName,
						e.getMessage()));
			} else {
				System.out.println(String.format("Unable to enter the text [%s] into %s. Error: %s", inputValue,
						elementName, e.getMessage()));

			}
		}

	}

	public void isWebElementDisplayed(WebElement element, String eleName) {
		try {
			waitElementVisible(element);
			if (element.isDisplayed()) {
				System.out.println(String.format("The web element %s display as expected", eleName));
			}
		} catch (Exception e) {
			System.out.println(String.format("The web element %s does not display which	is not expected. Error: %s",
					eleName, e.getMessage()));
		}
	}

	public void waitElementVisible(WebElement element) {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
			CommonFunctions.highlight(element, driver);
		} catch (Exception ex) {
			System.out.println("Failed to wait the webelement visible. Error: " + ex.getMessage());
		}
	}

	protected WebElement getWebElement(By locator) {
		WebElement element = null;
		for (int i = 0; i < TIMEOUT; i++) {
			try {
				element = driver.findElement(locator);			
				break;
			} catch (Exception e) {
				sleep(1);
			}
		}
		return element;
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
}
