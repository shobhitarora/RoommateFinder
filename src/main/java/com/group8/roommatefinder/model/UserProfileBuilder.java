package com.group8.roommatefinder.model;

public class UserProfileBuilder implements IUserProfileBuilder 
{

	private String emailId;
	private String foodPreference;
	private String address;
	private String name;
	private String gender;
	private int budget;
	private String roomType;

	public UserProfile build() 
	{

		return ModelFactory.instance().createUserProfileUsingBuilder(this);

	}

	public String getName() 
	{
		return name;
	}

	public IUserProfileBuilder addName(String name) 
	{
		this.name = name;
		return this;
	}

	public String getEmailId() 
	{
		return emailId;
	}

	public IUserProfileBuilder addEmailId(String emailId) 
	{
		this.emailId = emailId;
		return this;
	}

	public String getFoodPreference() 
	{
		return foodPreference;
	}

	public IUserProfileBuilder addFoodPreference(String foodPreference) 
	{
		this.foodPreference = foodPreference;
		return this;
	}

	public String getAddress() 
	{
		return address;
	}

	public IUserProfileBuilder addAddress(String address) 
	{
		this.address = address;
		return this;
	}

	public String getGender() 
	{
		return gender;
	}

	public IUserProfileBuilder addGender(String gender) 
	{
		this.gender = gender;
		return this;
	}

	public int getBudget() 
	{
		return budget;
	}

	public IUserProfileBuilder addBudget(int budget) 
	{
		this.budget = budget;
		return this;
	}

	public String getRoomType() 
	{
		return roomType;
	}

	public IUserProfileBuilder addRoomType(String roomType) 
	{
		this.roomType = roomType;
		return this;
	}

}
