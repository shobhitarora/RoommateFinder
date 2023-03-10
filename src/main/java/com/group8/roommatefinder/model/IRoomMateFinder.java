package com.group8.roommatefinder.model;

import java.util.List;

public interface IRoomMateFinder 
{

	public UserProfile getCurrentUserProfile(String emailId);
	
	public List<Post> getRoomMate(UserProfile userProfile);
	
}
