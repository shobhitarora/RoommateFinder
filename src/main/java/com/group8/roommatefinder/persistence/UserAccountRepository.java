package com.group8.roommatefinder.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.group8.roommatefinder.model.IUserAccountBuilder;
import com.group8.roommatefinder.model.ModelFactory;
import com.group8.roommatefinder.model.UserAccount;

@Repository
public class UserAccountRepository implements IUserAccountRepository
{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveUser(UserAccount userAccount) 
	{
		String sql = "INSERT INTO user_account " + "(email_id,password) VALUES (?,?)";

		jdbcTemplate.update(sql, userAccount.getEmailId(), userAccount.getPassword());
		
	}

	public List<UserAccount> getAllUsers() 
	{
		String getAllsql = "select * from user_account";
		IUserAccountBuilder userAccontbuilder= ModelFactory.instance().createUserAccountBuilder();

		return jdbcTemplate.query(getAllsql,
				(rs, rowNum) ->  ModelFactory.instance().createUserAccountUsingBuilder(userAccontbuilder.setEmailId(rs.getString("email_id")).setPassword(rs.getString("password")))); 


	}

	public UserAccount getUserById(String emailId) 
	{
		String getUserById = "select * from user_account where email_id=?";
		IUserAccountBuilder userAccontbuilder= ModelFactory.instance().createUserAccountBuilder();
		UserAccount user;
		try 
		{

			user = jdbcTemplate.queryForObject(getUserById,
			(rs, rowNum) -> ModelFactory.instance().createUserAccountUsingBuilder(userAccontbuilder.setEmailId(rs.getString("email_id")).setPassword(rs.getString("password"))),
			new Object[] { emailId });			

		} 
		catch (Exception e) 
		{
			user = null;
		}
		return user;
	}

}
