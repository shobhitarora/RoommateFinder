package com.group8.roommatefinder.model;

public class postBuilder implements IPostBuilder 
{
	
	private int postid;
	private String emailId;
	private String title;
	private String price;
	private String roomtype;
	private String foodpreference;

	@Override
	public Post build() 
	{
		return ModelFactory.instance().createPostUsingBuilder(this);
	}

	@Override
	public Integer getId() 
	{
		return postid;
	}

	@Override
	public IPostBuilder addId(int id) 
	{
		this.postid=id;
		return this;
	}

	@Override
	public String getEmailId() 
	{
		return emailId;
	}

	@Override
	public IPostBuilder addEmailId(String emailId) 
	{
		this.emailId=emailId;
		return this;
	}

	@Override
	public String getFoodpreference() 
	{
	
		return foodpreference;
	}

	@Override
	public IPostBuilder addFoodPreference(String foodpreference) 
	{
		this.foodpreference=foodpreference;
		return this;
	}

	@Override
	public IPostBuilder addPrice(String price) 
	{
		this.price=price;
		return this;
	}

	@Override
	public String getPrice() 
	{
		
		return price;
	}

	@Override
	public IPostBuilder addTitlet(String title) 
	{
		this.title=title;
		return this;
	}

	@Override
	public String getTitle() 
	{
		return title;
	}

	@Override
	public IPostBuilder addRoomType(String roomtype) 
	{
		this.roomtype=roomtype;
		return this;
	}

	@Override
	public String getRoomType() 
	{
		return roomtype;
	}

}
