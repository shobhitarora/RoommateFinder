package com.group8.roommatefinder.model;

public interface IUserAccountBuilder 
{
	public UserAccount build();
	public String getEmailId();
	public IUserAccountBuilder setEmailId(String emailId);
	public String getPassword();
	public IUserAccountBuilder setPassword(String password);

}
