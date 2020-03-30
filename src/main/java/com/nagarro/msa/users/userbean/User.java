package com.nagarro.msa.users.userbean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer userId;
	
	@Size(min = 3)
	private String userName;
	private int userAge;
	private String userEmail;

	public User() {
		super();
	}

	public User(Integer userId, String userName, int userAge, String userEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
		this.userEmail = userEmail;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAge=" + userAge + ", userEmail=" + userEmail
				+ "]";
	}

}
