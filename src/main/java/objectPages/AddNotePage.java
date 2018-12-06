package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import models.NoteModel;
import utils.BasePage;

public class AddNotePage extends BasePage {
	private WebDriver driver;

	public AddNotePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//input[@name='note.title']")
	private WebElement txtTitle;
	
	@FindBy(xpath = "//textarea[@name='note.description']")
	private WebElement textareaDescription;
	
	@FindBy(xpath = "//button[@onclick='App.addNote()']")
	private WebElement btnAddNote;
	
	@FindBy(xpath = "//button[@onclick='App.addNote()']")
	private WebElement btnCancel;
	
	public void inputData(NoteModel noteModel){
		sendKeys(txtTitle, "[Title] textbox", noteModel.getTitle());
		sendKeys(textareaDescription, "[Description] textarea", noteModel.getDescription());		
	}
	
	public HomePage addNote(NoteModel noteModel){
		inputData(noteModel);
		clickOnWebElement(btnAddNote, "[Add Note] button");
		return new HomePage(driver);
	}
	
	public HomePage cancelAddNoteProcess(NoteModel noteModel){
		inputData(noteModel);
		clickOnWebElement(btnCancel, "[Cancel] button");
		return new HomePage(driver);
	}
}
