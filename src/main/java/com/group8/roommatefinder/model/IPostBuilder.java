package com.group8.roommatefinder.model;

public interface IPostBuilder {
	
	 	public Post build();
	 
	    public Integer getId();
	    public IPostBuilder addId(int id);
	    
	    public String getEmailId();
	    public IPostBuilder addEmailId(String emailId);
	    
	    public String getFoodpreference();
	    public IPostBuilder addFoodPreference(String foodpreference);
	    
	    public IPostBuilder addPrice(String price);
	    public String getPrice();
	    
	    public IPostBuilder addTitlet(String title);
	    public String getTitle();
	    
	    public IPostBuilder addRoomType(String roomtype);
	    public String getRoomType();

}
