package com.group8.roommatefinder.model;

public class UserAccount {

	public UserAccount(String emailId, String password) 
	{
		super();
		this.emailId = emailId;
		this.password = password;
	}
	
	public UserAccount() 
	{
		super();
	}
	
	public UserAccount(IUserAccountBuilder builder) 
	{
		this.emailId=builder.getEmailId();
		this.password=builder.getPassword();
	}

	private String emailId;
	private String password;

	public String getEmailId() 
	{
		return emailId;
	}

	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public boolean checkUserIsNull(UserAccount user) 
	{
		if (user == null) 
		{
			return true;
		}
		return false;
	}
	

}
