package com.group8.roommatefinder.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.group8.roommatefinder.model.IPostBuilder;
import com.group8.roommatefinder.model.ModelFactory;
import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.UserProfile;


@Repository
public class PostRepository implements IPostRepository{

	private static String displayPostByPostId = "select * from post where post_id=?";
	private static String insertSql = "INSERT INTO post " + "(email_id,post_title,food_preference,room_type,price) VALUES (?,?,?,?,?)";
	private static String sql = "UPDATE post SET post_title=(?), food_preference=(?), price=(?), room_type=(?) WHERE email_id=(?)";
	private static String getAllPost = "select * from post";
	private static String getSinglePost = "select * from post where email_id=(?)";
	private static String deletePost = "delete from post where email_id=? ";
	private static String suggestionSql = "select * from post where room_type=(?) and price<=(?) or food_preference=(?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Post> displayPostByPostId(int postId) {

		return jdbcTemplate.query(displayPostByPostId,
				(rs, rowNum) -> new Post(rs.getInt("post_id"), rs.getString("email_id"), rs.getString("post_title"),
						rs.getString("price"), rs.getString("room_type"), rs.getString("food_preference")),
				new Object[] { postId });
	}
	


	public boolean savePost(Post post) {
		int status;
		status=jdbcTemplate.update(insertSql, post.getEmailId(), post.getTitle(),post.getFoodpreference(),post.getRoomtype(),post.getPrice());
		if(status>0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean updatePost(Post post) {
		int status;
		status=jdbcTemplate.update(sql, post.getTitle(), post.getFoodpreference(),post.getPrice(),post.getRoomtype(),post.getEmailId());
		if(status>0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public List<Post> getAllPost() {

		return jdbcTemplate.query(getAllPost,
				(rs, rowNum) -> new Post(rs.getInt("post_id"), rs.getString("email_id"), rs.getString("post_title"),
						rs.getString("price"), rs.getString("room_type"), rs.getString("food_preference")));

	}
	

		
	

	public Post singlePost(int post_id) {
		List<Post> post;
        try {

            IPostBuilder postBuilder = ModelFactory.instance().createPostBuilder();
            post = jdbcTemplate.query(getSinglePost,
                    (rs, rowNum) ->  ModelFactory.instance().createPostUsingBuilder(
                    postBuilder.addId(rs.getInt("post_id"))
                            .addEmailId(rs.getString("email_id"))
                            .addTitlet(rs.getString("post_title"))
                            .addPrice(rs.getString("price"))
                            .addRoomType(rs.getString("roomtype"))
                            .addFoodPreference(rs.getString("food_preference"))),
                    new Object[] { post_id });

        } catch (Exception e) {
            post = null;
        }
        return post.get(0);
	}

	public List<Post> getFilteredPost(Post post) {
		
		
			
			String getFilteredPost = "select * from post where room_type=(?) and food_preference=(?) and price =(?) ";

			return jdbcTemplate.query(getFilteredPost,
					(rs, rowNum) -> new Post(rs.getInt("post_id"), rs.getString("email_id"), rs.getString("post_title"),
							rs.getString("price"), rs.getString("room_type"), rs.getString("food_preference")),
					new Object[] { post.getRoomtype(), post.getFoodpreference(), post.getPrice() });
		
	}

	public boolean deletePost(Post post) {

		int status;
		status=jdbcTemplate.update(deletePost, post.getEmailId());
		if(status>0) 
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public List<Post> getPostSuggestion(UserProfile userProfile) 
	{
		
		String roomType = userProfile.getRoomType();
		String price = Integer.toString(userProfile.getBudget());
		String foodPreference = userProfile.getFoodPreference();

		return jdbcTemplate.query(suggestionSql,
				(rs, rowNum) -> new Post(rs.getInt("post_id"), rs.getString("email_id"), rs.getString("post_title"),
						rs.getString("price"), rs.getString("room_type"), rs.getString("food_preference")),
				new Object[] { roomType, price, foodPreference });

	}



			
}
			
			
			
			


