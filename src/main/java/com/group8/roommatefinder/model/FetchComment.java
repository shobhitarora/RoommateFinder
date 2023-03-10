package com.group8.roommatefinder.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group8.roommatefinder.persistence.CommentRepository;

@Service
public class FetchComment 
{
	@Autowired
	CommentRepository commentRepo;
	
	public FetchComment() 
	{
		
	}
	public FetchComment(CommentRepository commentRepo) 
	{
		this.commentRepo=commentRepo;
	}

	public List<Comment> fetchCommentsByPostId(int post_id) 
	{
		List<Comment> comm = commentRepo.getCommentByPostId(post_id);
		return comm;
	}
}
