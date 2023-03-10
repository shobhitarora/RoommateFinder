package com.group8.roommatefinder.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.exception.BadRequestException;
import com.group8.roommatefinder.persistence.IUserAccountRepository;

@Service
public class UserRegistration implements IUserRegistration 
{

	@Autowired
	IUserAccountRepository repo;

	public UserRegistration(IUserAccountRepository repo) 
	{
		this.repo = repo;
	}

	public UserRegistration() 
	{
		super();
	}

	public boolean userSignup(UserAccount userAccount) 
	{
		boolean status;
		UserAccount user = repo.getUserById(userAccount.getEmailId());

		try {

			if (userAccount.checkUserIsNull(user)) 
			{
				repo.saveUser(userAccount);
				status = true;
				return status;

			}
			else 
			{
				throw new BadRequestException("Email " + userAccount.getEmailId() + " taken ");
			}
		} 
		catch (BadRequestException e)
		{
			status = false;
			return status;
		}

	}

	public boolean userLogin(UserAccount userAccount) 
	{

		boolean status;
		UserAccount user = repo.getUserById(userAccount.getEmailId());
		try {
			if (user.checkUserIsNull(user)) 
			{

				status = false;
				return status;
			} 
			else 
			{

				if (user.getPassword().equals(userAccount.getPassword())) 
				{
					status = true;
					return status;
				}

				else 
				{
					throw new BadRequestException("Incorrect Email/Password");

				}
			}
		} 
		catch (BadRequestException e) 
		{
			status = false;
			return status;

		}

	}
}