package objectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import models.NoteModel;
import utils.BasePage;

public class HomePage extends BasePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//h2[text()='My Notes']")
	private WebElement lbMyNotes;

	@FindBy(xpath = "//button[@onclick='App.showAddNotePage();']")
	private WebElement btnShowAddNotePage;

	
	
	public void isHomePageDisplayed() {
		isWebElementDisplayed(lbMyNotes, "[My Notes] header");
		isWebElementDisplayed(btnShowAddNotePage, "[Show Add Note Page] button");
	}

	public AddNotePage gotoAddNotePage(){
		clickOnWebElement(btnShowAddNotePage, "[Show Add Note page] button");
		return new AddNotePage(driver);
	}
	
	public void isAddNoteSucceeded(NoteModel noteModel){
		WebElement eleTitle = getWebElement(By.xpath(String.format("//*[text()='%s']", noteModel.getTitle())));
		isWebElementDisplayed(eleTitle, String.format("[%s] title", noteModel.getTitle()));
		WebElement eleDescription = getWebElement(By.xpath(String.format("//*[text()='%s']", noteModel.getDescription())));
		isWebElementDisplayed(eleDescription, String.format("[%s] description", noteModel.getDescription()));		
	}
}
