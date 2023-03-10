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

import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.PostAdvert;
import com.group8.roommatefinder.persistence.IPostRepository;


class PostAdvertTest {

	private static PostAdvert postAdvert;
	
	@MockBean
	private static IPostRepository postRepository;
	
	@BeforeAll
	public static void setup() {

		postRepository = Mockito.mock(IPostRepository.class);
		postAdvert = new PostAdvert(postRepository);
	}
	
	@Test
	public void getAllPostSuccessTest() {
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
		
		when(postRepository.getAllPost()).thenReturn(repositoryList);
		assertEquals(repositoryList,postAdvert.getAllpost());
		
		
	}
	
	@Test
	public void getAllPostUnSuccessTest() {
		List<Post> repositoryList= new ArrayList<Post>();
		List<Post> parameterList= new ArrayList<Post>();
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
		parameterList.add(post1);
		
		when(postRepository.getAllPost()).thenReturn(repositoryList);
		assertNotEquals(parameterList,postAdvert.getAllpost());
		
		
	}
	
	@Test
	public void filterSucessTest() 
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
		
		when(postRepository.getFilteredPost(post)).thenReturn(repositoryList);
		assertEquals(repositoryList,postAdvert.Filter(post));
	}
	
	
	@Test
	public void filterUnSucessTest() 
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
		
		when(postRepository.getFilteredPost(post)).thenReturn(repositoryList);
		assertNotEquals(repositoryList,postAdvert.Filter(post1));
	}
	
	@Test
	public void postAddSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.savePost(post)).thenReturn(true);
		assertEquals(true, postAdvert.postAdd(post));
		
	}
	
	@Test
	public void postAddUnSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.savePost(post)).thenReturn(false);
		assertNotEquals(true, postAdvert.postAdd(post));
		
	}
	
	@Test
	public void updatePostSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.updatePost(post)).thenReturn(true);
		assertEquals(true, postAdvert.postUpdate(post));
		
	}
	
	@Test
	public void updatePostUnSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.updatePost(post)).thenReturn(false);
		assertNotEquals(true, postAdvert.postUpdate(post));
		
	}
	
	@Test
	public void deletePostSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.deletePost(post)).thenReturn(true);
		assertEquals(true, postAdvert.deletePost(post));
		
	}
	
	@Test
	public void deletePostUnSuccessTest() 
	{
		Post post= new Post();
		post.setEmailId("h1@gmail.com");
		post.setFoodpreference("vegan");
		post.setPostid(1);
		post.setPrice("200");
		post.setRoomtype("1bhk");
		post.setTitle("1bhk flat for sale");
		
		when(postRepository.deletePost(post)).thenReturn(false);
		assertNotEquals(true, postAdvert.deletePost(post));
		
	}
	
	

}
