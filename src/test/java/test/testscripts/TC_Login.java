package test.testscripts;


import org.testng.annotations.Test;

import models.UserModel;
import objectPages.HomePage;
import objectPages.LoginPage;
import test.utils.BaseTest;

public class TC_Login extends BaseTest{
	LoginPage loginPage;
	HomePage homePage;
	@Test
	public void login(){
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(new UserModel());
		//Verify Login function
		homePage.isHomePageDisplayed();
	}
}
