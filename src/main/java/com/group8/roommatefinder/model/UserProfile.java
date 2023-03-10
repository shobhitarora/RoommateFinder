package com.group8.roommatefinder.model;

public class UserProfile 
{
	private String emailId;
	private String foodPreference;
	private String address;
	private String name;
	private String gender;
	private int budget;
	private String roomType;

	public UserProfile( String emailId,String address, String foodPreference,String name,String gender,int budget,String roomType) 
	{
		super();

		this.emailId = emailId;
		this.address = address;
		this.foodPreference = foodPreference;
		this.name = name;
		this.gender=gender;
		this.budget=budget;
		this.roomType=roomType;
	}
	
	public UserProfile( IUserProfileBuilder builder) 
	{

		this.emailId = builder.getEmailId();
		this.address = builder.getAddress();
		this.foodPreference = builder.getFoodPreference();
		this.name = builder.getName();
		this.gender=builder.getGender();
		this.budget=builder.getBudget();
		this.roomType=builder.getRoomType();
	}

	public UserProfile() {
		super();
		}


	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getEmailId() 
	{
		return emailId;
	}
	
	public void setEmailId(String emailId) 
	{
		this.emailId = emailId;
	}
	
	public String getFoodPreference() 
	{
		return foodPreference;
	}
	
	public void setFoodPreference(String foodPreference) 
	{
		this.foodPreference = foodPreference;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public int getBudget() 
	{
		return budget;
	}
	
	public void setBudget(int budget) 
	{
		this.budget = budget;
	}
	
	public String getRoomType() 
	{
		return roomType;
	}
	
	public void setRoomType(String roomType) 
	{
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "UserProfile [name=" + name + ", email_id=" + emailId + ", foodPreference=" + foodPreference
				+ ", address=" + address + ", gender="+ gender + ", budget=" + budget + ", roomtype=" + roomType + "]";
	}

}
