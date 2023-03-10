package com.group8.roommatefinder.model;

public class Post 
{

	private int postid;
	private String emailId;
	private String title;
	private String price;
	private String roomtype;
	private String foodpreference;
	
	public Post() 
	{
		super();
	}
	
	public Post(int postid,String emailId, String title, String price, String roomtype, String foodpreference) 
	{

		this.postid=postid;
		this.emailId = emailId;
		this.title = title;
		this.price = price;
		this.roomtype = roomtype;
		this.foodpreference = foodpreference;
	}
	
	
	public Post(IPostBuilder postBuilder) 
	{
		this.postid=postBuilder.getId();
		this.emailId = postBuilder.getEmailId();
		this.title = postBuilder.getTitle();
		this.price = postBuilder.getPrice();
		this.roomtype =postBuilder.getRoomType();
		this.foodpreference = postBuilder.getFoodpreference();
	}
	
	public int getPostid() 
	{
		return postid;
	}

	public void setPostid(int postid) 
	{
		this.postid = postid;
	}

	public String getPrice() 
	{
		return price;
	}
	
	public void setPrice(String price) 
	{
		this.price = price;
	}
	
	public String getRoomtype() 
	{
		return roomtype;
	}
	
	public void setRoomtype(String roomtype) 
	{
		this.roomtype = roomtype;
	}
	
	public String getFoodpreference() 
	{
		return foodpreference;
	}
	
	public void setFoodpreference(String foodpreference) 
	{
		this.foodpreference = foodpreference;
	}
	
	public Post(String emailId, String title) 
	{
		super();
		this.emailId = emailId;
		this.title = title;
	}
	
	public String getEmailId() 
	{
		return emailId;
	}
	
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Post [emailId=" + emailId + ", title=" + title + ", price=" + price + ", roomtype=" + roomtype
				+ ", foodpreference=" + foodpreference + "]";
	}
}


