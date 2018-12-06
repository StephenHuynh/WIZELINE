package test.testdata;
import models.NoteModel;
import utils.CommonFunctions;

public class TD_AddNote {
	private NoteModel noteModel;

	public TD_AddNote() {
		super();
		String random = CommonFunctions.randomString();		
		this.noteModel = new NoteModel(String.format("Title: %s", random), String.format("Description: %s", random));
	}
	
	public NoteModel getNoteModel() {
		return noteModel;
	}

	public void setNoteModel(NoteModel noteModel) {
		this.noteModel = noteModel;
	}

}
