package com.group8.roommatefinder.persistence;

import java.util.List;
import com.group8.roommatefinder.model.Comment;

public interface ICommentRepository 
{

	public List<Comment> getCommentByPostId(int post_id);
	
}
