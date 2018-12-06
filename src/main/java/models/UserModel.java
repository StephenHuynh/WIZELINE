package models;

public class UserModel {
	private String userName;
	private String passwork;
	
	public UserModel() {
		super();
		this.userName = "testuser@example.com";
		this.passwork = "test123";
	}

	public UserModel(String userName, String passwork) {
		super();
		this.userName = userName;
		this.passwork = passwork;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswork() {
		return passwork;
	}

	public void setPasswork(String passwork) {
		this.passwork = passwork;
	}


}
