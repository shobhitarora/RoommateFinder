package com.group8.roommatefinder.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.group8.roommatefinder.model.Comment;
import com.group8.roommatefinder.model.ICommentBuilder;
import com.group8.roommatefinder.model.ModelFactory;

@Repository
public class CommentRepository implements ICommentRepository
{
	
	private static String getCommentByPostId = "select * from comment_section where post_id=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> getCommentByPostId(int post_id) 
	{
	
		List<Comment> comment;
		try {
			
			ICommentBuilder commentBuilder = ModelFactory.instance().createCommentBuilder();
			comment = jdbcTemplate.query(getCommentByPostId,
					(rs, rowNum) ->  ModelFactory.instance().createCommentBuilder(
					commentBuilder.addCommentId(rs.getInt("comment_id"))
							.addPostId(rs.getInt("post_id"))
							.addContent(rs.getString("content"))
							.addEmailId(rs.getString("email_id"))),
					new Object[] { post_id });

		} 
		catch (Exception e) 
		{
			comment = null;
		}
		return comment;
	}
}



