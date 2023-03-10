package com.group8.roommatefinder.model;

public interface IUserProfileBuilder {

    public UserProfile build();
    public String getName();
    public IUserProfileBuilder addName(String name);
    public String getEmailId();
    public IUserProfileBuilder addEmailId(String emailId);
    public String getFoodPreference();
    public IUserProfileBuilder addFoodPreference(String foodPreference);
    public String getAddress();
    public IUserProfileBuilder addAddress(String address);
    public String getGender();
    public IUserProfileBuilder addGender(String gender);
    public int getBudget();
    public IUserProfileBuilder addBudget(int budget);
    public String getRoomType();
    public IUserProfileBuilder addRoomType(String roomType);

}
