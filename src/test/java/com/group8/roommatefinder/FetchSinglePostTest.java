package com.group8.roommatefinder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.group8.roommatefinder.model.FetchSinglePost;
import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.persistence.IPostRepository;

class FetchSinglePostTest 
{
	
	private static FetchSinglePost fetchSinglePost;
	
	@MockBean
	private static IPostRepository postRepository;
   
	@BeforeAll
	public static void setup() 
	{
		postRepository = Mockito.mock(IPostRepository.class);
		fetchSinglePost = new FetchSinglePost(postRepository);
	}
    
	@Test
	public void fetchSinglePostByPostIdSucessTest() 
	{
		List<Post> repositoryList= new ArrayList<Post>();
		
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		Post post1= new Post();
		post.setEmailId("h2@gmail.com");
		post.setFoodpreference("nonveg");
		post.setPostid(2);
		post.setPrice("300");
		post.setRoomtype("2bhk");
		post.setTitle("2bhk flat for sale");
		
		repositoryList.add(post1);
		repositoryList.add(post);
		
		when(postRepository.displayPostByPostId(post.getPostid())).thenReturn(repositoryList);
		assertEquals(repositoryList,fetchSinglePost.fetchSinglePostByPostId(post.getPostid()));
	}
	
	@Test
	public void fetchSinglePostByPostIdUnSucessTest() 
	{
		List<Post> repositoryList= new ArrayList<Post>();
		
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		Post post1= new Post();
		post.setEmailId("h2@gmail.com");
		post.setFoodpreference("nonveg");
		post.setPostid(2);
		post.setPrice("300");
		post.setRoomtype("2bhk");
		post.setTitle("2bhk flat for sale");
		
		repositoryList.add(post1);
		repositoryList.add(post);
		
		when(postRepository.displayPostByPostId(post.getPostid())).thenReturn(repositoryList);
		assertNotEquals(repositoryList,fetchSinglePost.fetchSinglePostByPostId(post1.getPostid()));
	}
	
}
