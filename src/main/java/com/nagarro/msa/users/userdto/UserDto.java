package com.nagarro.msa.users.userdto;

public class UserDto {

	private String userName;
	private int userAge;
	private String userEmail;

	public UserDto(String userName, int userAge, String userEmail) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
