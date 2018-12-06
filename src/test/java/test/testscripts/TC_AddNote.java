package test.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import models.UserModel;
import objectPages.AddNotePage;
import objectPages.HomePage;
import objectPages.LoginPage;
import test.testdata.TD_AddNote;
import test.utils.BaseTest;

public class TC_AddNote extends BaseTest {
	LoginPage loginPage;
	AddNotePage addNotePage;
	HomePage homePage;
	TD_AddNote testdata = new TD_AddNote();

	@BeforeMethod
	public void precondition() {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(new UserModel());
	}

	@Test()
	public void addNote() {
		addNotePage = homePage.gotoAddNotePage();
		homePage = addNotePage.addNote(testdata.getNoteModel());
		homePage.isAddNoteSucceeded(testdata.getNoteModel());
	}

}
