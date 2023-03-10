package com.group8.roommatefinder.persistence;

import java.util.List;

import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.UserProfile;

public interface IPostRepository {

	public List<Post> displayPostByPostId(int post_id);

	public boolean savePost(Post post);
	
	public boolean updatePost(Post post) ;
	
	public List<Post> getAllPost() ;
	
	public Post singlePost(int postId);
	
	public List<Post> getFilteredPost(Post post);
		
	public boolean deletePost(Post post) ;
	
	public List<Post> getPostSuggestion(UserProfile userProfile);
}
