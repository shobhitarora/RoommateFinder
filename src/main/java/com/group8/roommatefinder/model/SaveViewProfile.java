package com.group8.roommatefinder.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.persistence.IUserProfileRepository;

@Service
public class SaveViewProfile implements ISaveViewUserProfile 
{

	@Autowired
	IUserProfileRepository repo;

	public SaveViewProfile(IUserProfileRepository repo) 
	{
		this.repo = repo;
	}

	@Override
	public UserProfile dipslayProfile(UserProfile userProfile) 
	{
		UserProfile user = repo.getProfileById(userProfile.getEmailId());
		return user;

	}

	@Override
	public void saveProfile(UserProfile userProfile)
	{
		repo.saveProfile(userProfile);
	}

	@Override
	public boolean updateProfile(UserProfile userProfile) 
	{
		return repo.updateProfile(userProfile);
	}

	@Override
	public boolean resetPasword(UserAccount userAccount, String email) 
	{
		userAccount.setEmailId(email);
		return repo.resetPassword(userAccount);
	}

}
