package com.group8.roommatefinder.model;

public interface ISaveViewUserProfile {
	
	public UserProfile dipslayProfile(UserProfile userProfile );
	public void saveProfile(UserProfile userProfile );
	public boolean updateProfile(UserProfile userProfile);

	public boolean resetPasword(UserAccount userAccount,String email);
    
	
}
