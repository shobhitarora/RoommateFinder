package com.group8.roommatefinder.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group8.roommatefinder.model.IUserProfileBuilder;
import com.group8.roommatefinder.model.ModelFactory;
import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserProfile;

@Repository
public class UserProfileRepository implements IUserProfileRepository
{
	private static String savePrfileSql = "INSERT INTO user_profile "
			+ "(email_id,address,food_preference,name,gender,budget,room_type) VALUES (?,?,?,?,?,?,?)";
	private static String getProfileById = "select * from user_profile where email_id=?";
	private static String updateProfileSql = "update user_profile set"
			+ " address=?, food_preference=?, name=?, gender=?, budget=?, room_type=?" + " where email_id=?";
	private static String resetPasswordSql = "update user_account set password=? where email_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveProfile(UserProfile userProfile) {

		jdbcTemplate.update(savePrfileSql, userProfile.getEmailId(), userProfile.getAddress(),
				userProfile.getFoodPreference(), userProfile.getName(), userProfile.getGender(),
				userProfile.getBudget(), userProfile.getRoomType());

	}
	public UserProfile getProfileById(String emailId) 
	{
		UserProfile userProfile;
		try {
			IUserProfileBuilder userProfileBuilder = ModelFactory.instance().createUserProfileBuilder();
			userProfile = jdbcTemplate.queryForObject(getProfileById,
					(rs, rowNum) -> ModelFactory.instance().createUserProfileUsingBuilder(
							userProfileBuilder.addEmailId(rs.getString("email_id"))
									.addAddress(rs.getString("address"))
											.addFoodPreference(rs.getString("food_preference"))
									.addName(rs.getString("name"))
									.addGender(rs.getString("gender"))
											.addBudget(rs.getInt("budget"))
									.addRoomType(rs.getString("room_type"))),
					new Object[] { emailId });

		} 
		catch (Exception e) 
		{
			userProfile = null;
		}
		
		return userProfile;
	}
	
	public boolean updateProfile(UserProfile userProfile) 
	{
		try
		{
			int status = jdbcTemplate.update(updateProfileSql, userProfile.getAddress(), userProfile.getFoodPreference(),
					userProfile.getName(), userProfile.getGender(), userProfile.getBudget(), userProfile.getRoomType(),
					userProfile.getEmailId());
			if(status==1)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}


	public boolean resetPassword(UserAccount userAccount)
	{
		try
		{
			int status = jdbcTemplate.update(resetPasswordSql,userAccount.getPassword(),userAccount.getEmailId());
		if(status==1){
			return true;
		}
		else {
			return false;
		}
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
