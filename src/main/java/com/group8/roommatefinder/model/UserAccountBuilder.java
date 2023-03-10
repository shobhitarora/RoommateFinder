package com.group8.roommatefinder.model;

public class UserAccountBuilder implements IUserAccountBuilder 
{

	private String emailId;
	private String password;

	@Override
	public UserAccount build() 
	{
		
		return ModelFactory.instance().createUserAccountUsingBuilder(this);
	}

	@Override
	public String getEmailId() 
	{
		return emailId;
	}

	@Override
	public IUserAccountBuilder setEmailId(String emailId) 
	{
		this.emailId=emailId;
		return this;
	}

	@Override
	public String getPassword() 
	{
		return password;
	}

	@Override
	public IUserAccountBuilder setPassword(String password) 
	{
		this.password=password;
		return this;
	}
	
}
