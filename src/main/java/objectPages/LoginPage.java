package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import models.UserModel;
import utils.BasePage;

public class LoginPage extends BasePage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//button[@onclick='App.showLoginPage();']")
	private WebElement btnShowLoginPage;
	
	@FindBy(xpath = "//input[@name='login.username']")
	private WebElement txtUserName;
	
	@FindBy(xpath = "//input[@name='login.password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[@onclick='App.login()']")
	private WebElement btnLogin;
	
	public HomePage login(UserModel userModel){
		clickOnWebElement(btnShowLoginPage, "[Show Login Page] button");
		sendKeys(txtUserName, "[User name] textbox", userModel.getUserName());
		sendKeys(txtPassword, "[Password] textbox", userModel.getPasswork());
		clickOnWebElement(btnLogin, "[Login] button");
		return new HomePage(driver);
	}
	
	

}
