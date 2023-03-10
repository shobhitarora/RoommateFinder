package com.group8.roommatefinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.RoomMateFinder;
import com.group8.roommatefinder.model.UserProfile;
import com.group8.roommatefinder.persistence.IPostRepository;
import com.group8.roommatefinder.persistence.IUserProfileRepository;

class RoomMateFinderTest 
{

	private static RoomMateFinder roomMate;

	@MockBean
	private static IUserProfileRepository userProfileRepo;

	@MockBean
	private static IPostRepository postRepository;

	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		userProfileRepo = Mockito.mock(IUserProfileRepository.class);
		postRepository = Mockito.mock(IPostRepository.class);
		roomMate = new RoomMateFinder(userProfileRepo, postRepository);
	}

	@Test
	public void getCurrentUserSucessfullTest() 
	{
		String emailId = "h1@gmail.com";
		UserProfile profile = new UserProfile("h1@gmail.com", "addressTest", "food_preferencetest", "raghuTest",
				"maleTest", 700, "3bhktest");
		when(userProfileRepo.getProfileById(emailId)).thenReturn(profile);
		UserProfile user = roomMate.getCurrentUserProfile(emailId);

		assertEquals(emailId, user.getEmailId());

	}

	@Test
	public void getCurrentUserUnSucessfullTest() 
	{
		String emailId = "h2@gmail.com";
		UserProfile profile = new UserProfile("h1@gmail.com", "addressTest", "food_preferencetest", "raghuTest",
				"maleTest", 700, "3bhktest");
		when(userProfileRepo.getProfileById(emailId)).thenReturn(profile);
		UserProfile user = roomMate.getCurrentUserProfile(emailId);

		assertNotEquals(emailId, user.getEmailId());

	}

	@Test
	public void getSucessfulRoomMateSuggestion() 
	{
		UserProfile profile = new UserProfile("h1@gmail.com", "addressTest", "food_preferencetest", "raghuTest",
				"maleTest", 700, "3bhktest");

		List<Post> postList = new ArrayList<Post>();
		Post post = new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");

		Post post1 = new Post();
		post.setEmailId("h2@gmail.com");
		post.setFoodpreference("nonveg");
		post.setPostid(2);
		post.setPrice("300");
		post.setRoomtype("2bhk");
		post.setTitle("2bhk flat for sale");

		postList.add(post1);
		postList.add(post);

		when(postRepository.getPostSuggestion(profile)).thenReturn(postList);
		assertEquals(postList, roomMate.getRoomMate(profile));
	}
	
	@Test
	public void getUnSucessfulRoomMateSuggestion() 
	{
		UserProfile profile = new UserProfile("h1@gmail.com", "addressTest", "food_preferencetest", "raghuTest",
				"maleTest", 700, "3bhktest");

		List<Post> postList = new ArrayList<Post>();
		List<Post> outputList = new ArrayList<Post>();
		Post post = new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");

		Post post1 = new Post();
		post.setEmailId("h2@gmail.com");
		post.setFoodpreference("nonveg");
		post.setPostid(2);
		post.setPrice("300");
		post.setRoomtype("2bhk");
		post.setTitle("2bhk flat for sale");

		outputList.add(post1);
		postList.add(post1);
		postList.add(post);

		when(postRepository.getPostSuggestion(profile)).thenReturn(postList);
		assertNotEquals(outputList, roomMate.getRoomMate(profile));
	}

}
