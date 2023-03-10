package com.group8.roommatefinder.model;


import java.util.List;

public interface IPostAdvert {
	

	public boolean postAdd(Post post);

	public boolean postUpdate(Post post);

	public List<Post> getAllpost();

	public List<Post> Filter(Post post);

	public boolean deletePost(Post post);
}
