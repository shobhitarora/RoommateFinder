package com.group8.roommatefinder.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.persistence.IPostRepository;


@Service
public class FetchSinglePost {
	
	@Autowired
	IPostRepository repo;
	
	public FetchSinglePost(IPostRepository repo) {
		this.repo=repo;
	}
	
	public FetchSinglePost() 
	{
		super();
	}

	public List<Post> fetchSinglePostByPostId(int post_id) {
		List<Post> post = repo.displayPostByPostId(post_id);
		return post;
	}

}
