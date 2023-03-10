package com.group8.roommatefinder.model;

public class Comment 
{
	private int comment_id;
	private int post_id;
	private String content;
	private String email_id;
	
	public Comment() 
	{
		super();
	}
	
	public Comment(int comment_id, int post_id, String content, String email_id) 
	{
		super();
		this.comment_id = comment_id;
		this.post_id = post_id;
		this.content = content;
		this.email_id = email_id;
	}
	
	public Comment(ICommentBuilder builder) 
	{
		this.comment_id = builder.getCommentId();
		this.post_id = builder.getPostId();
		this.content = builder.getContent();
		this.email_id = builder.getEmailId();
	}

	public int getComment_id() 
	{
		return comment_id;
	}
	
	public void setComment_id(int comment_id) 
	{
		this.comment_id = comment_id;
	}
	
	public int getPost_id() 
	{
		return post_id;
	}
	
	public void setPost_id(int post_id) 
	{
		this.post_id = post_id;
	}
	
	public String getContent() 
	{
		return content;
	}
	
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	public String getEmail_id() 
	{
		return email_id;
	}
	
	public void setEmail_id(String email_id) 
	{
		this.email_id = email_id;
	}
	
}

