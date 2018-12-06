package test.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected static WebDriver driver;
	protected static WebDriverWait wait;

	@BeforeSuite
	public void before_suite() {

	}

	@AfterSuite
	public void after_suite() {

	}

	@BeforeClass
	public void before_class() {

	}

	@AfterClass
	public void after_class() {

	}

	@BeforeMethod(alwaysRun = true)
	public void before_method() {
		System.setProperty("webdriver.chrome.driver", getChromeDriver());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://testapp.galenframework.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//wait = new WebDriverWait(driver, 60);
	}

	@AfterMethod(alwaysRun = true)
	public void after_method() {
		driver.quit();
	}

	private static String getChromeDriver() {
		return System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe";
	}

}
