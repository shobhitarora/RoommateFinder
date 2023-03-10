package com.group8.roommatefinder.persistence;

import java.util.List;

import com.group8.roommatefinder.model.UserAccount;

public interface IUserAccountRepository
{

	public void saveUser(UserAccount userAccount);

	public List<UserAccount> getAllUsers();

	public UserAccount getUserById(String emailId);

}
