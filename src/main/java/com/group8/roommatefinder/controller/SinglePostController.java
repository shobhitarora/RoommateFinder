package com.group8.roommatefinder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group8.roommatefinder.model.FetchSinglePost;
import com.group8.roommatefinder.model.Post;

@Controller
public class SinglePostController 
{

	@Autowired
	private FetchSinglePost fetchSinglePost;
	
	@GetMapping("/allposts/{post_id}")
	public String displayPostByPostId(@PathVariable int post_id,Model model) 
	{
		List<Post> postDetails = fetchSinglePost.fetchSinglePostByPostId(post_id);
		model.addAttribute("post", postDetails);
		return "singlePost";
	}
	
}
