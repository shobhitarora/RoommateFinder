package com.group8.roommatefinder.persistence;

import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserProfile;

public interface IUserProfileRepository 
{
    public void saveProfile(UserProfile userProfile);

    public UserProfile getProfileById(String emailId);

    public boolean updateProfile(UserProfile userProfile);

    public boolean resetPassword(UserAccount userAccount);
}
