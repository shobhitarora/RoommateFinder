package com.group8.roommatefinder.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.persistence.IPostRepository;
import com.group8.roommatefinder.persistence.IUserProfileRepository;

@Service
public class RoomMateFinder implements IRoomMateFinder
{
	@Autowired
	IUserProfileRepository userProfileRepo;
	
	@Autowired
	IPostRepository postRepository;
	
	public RoomMateFinder(IUserProfileRepository userProfileRepo, IPostRepository postRepository) 
	{
		super();
		this.userProfileRepo = userProfileRepo;
		this.postRepository = postRepository;
	}

	public RoomMateFinder() 
	{
		super();
		
	}

	public UserProfile getCurrentUserProfile(String emailId) 
	{
		UserProfile profile;
		profile=userProfileRepo.getProfileById(emailId);
		return profile;
	}
	
	public List<Post> getRoomMate(UserProfile userProfile)
	{
		List<Post> posts= new ArrayList<>();
		posts=postRepository.getPostSuggestion(userProfile);
		return posts;
	}

}
