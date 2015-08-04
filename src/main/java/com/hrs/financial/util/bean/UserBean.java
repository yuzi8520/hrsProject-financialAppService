package com.hrs.financial.util.bean;

public class UserBean {
	
	
	public UserBean (){}
	
	private Integer id ;
	
	private String userAccount;
	
	private String password;
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString(){
		return "userAccount="+userAccount+",password="+password;
		
	}
	

}
