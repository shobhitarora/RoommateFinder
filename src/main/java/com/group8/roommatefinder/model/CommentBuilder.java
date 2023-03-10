package com.group8.roommatefinder.model;

public class CommentBuilder implements ICommentBuilder 
{
	
	private int commentId;
	private int postId;
	private String content;
	private String emailId;

	public Comment build() 
	{
		return ModelFactory.instance().createCommentBuilder(this);
	}

	public int getPostId() 
	{
		return postId;
	}

	public ICommentBuilder addPostId(int postId) 
	{
		this.postId = postId;
		return this;
	}

	public int getCommentId() 
	{
		return commentId;
	}

	public ICommentBuilder addCommentId(int commentId) 
	{
		this.commentId = commentId;
		return this;
	}

	public String getContent() 
	{
		return content;
	}

	public ICommentBuilder addContent(String content) 
	{
		this.content = content;
		return this;
	}

	public String getEmailId() 
	{
        return emailId;
    }
	
    public ICommentBuilder addEmailId(String emailId) 
    {
        this.emailId = emailId;
        return this;
    }


}
