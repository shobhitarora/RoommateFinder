package com.group8.roommatefinder.model;

public interface ICommentBuilder {
	
	public Comment build();
	public int getPostId();
    public ICommentBuilder addPostId(int commentId);
    public int getCommentId();
    public ICommentBuilder addCommentId(int postId);
    public String getContent();
    public ICommentBuilder addContent(String content);
    public String getEmailId();
    public ICommentBuilder addEmailId(String emailId);
    
}
