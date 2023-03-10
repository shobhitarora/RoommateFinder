package com.group8.roommatefinder.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.persistence.IPostRepository;


@Service
public class PostAdvert implements IPostAdvert 
{
	
	@Autowired
	IPostRepository repo;
	
	public PostAdvert(IPostRepository repo) 
	{
		this.repo=repo;
	}
	
	public PostAdvert() 
	{
		super();
	}	

	public boolean postAdd(Post post) 
	{
		return repo.savePost(post);
	}
	
	public boolean postUpdate(Post post) 
	{	
		return repo.updatePost(post);
	}

	public List<Post> getAllpost() 
	{
		
		return repo.getAllPost();
	}
	
	public List<Post> Filter(Post post) 
	{
		List<Post> p;
		p=repo.getFilteredPost(post);
		return p;
	}
	
	public boolean deletePost(Post post) 
	{
		return repo.deletePost(post);
	}
}


