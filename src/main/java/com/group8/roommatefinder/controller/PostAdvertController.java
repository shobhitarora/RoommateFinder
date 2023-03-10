package com.group8.roommatefinder.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.group8.roommatefinder.model.CookieHandler;
import com.group8.roommatefinder.model.IPostAdvert;
import com.group8.roommatefinder.model.Post;

@Controller
public class PostAdvertController 
{

	@Autowired
	private IPostAdvert advert;

	@PostMapping("/addposted")
	public RedirectView addPostDetails(@ModelAttribute("addPost") Post post, HttpServletRequest req) 
	{
		post.setEmailId(CookieHandler.getinstance().getCookie(req));
		advert.postAdd(post);
		return new RedirectView("/displayprofile");
	}

	@PostMapping("/updateposted")
	public RedirectView updatePost(@ModelAttribute("updatepost") Post post, HttpServletRequest req) 
	{
		post.setEmailId(CookieHandler.getinstance().getCookie(req));
		advert.postUpdate(post);
		return new RedirectView("/allpost");
	}

	@GetMapping("/allpost")
	public String getAllPost(Model model) 
	{
		List<Post> post1 = advert.getAllpost();
		model.addAttribute("postlist", post1);
		return "home";

	}

	@GetMapping("/filterpost")
	public String filter(Model model) 
	{
		model.addAttribute("filter", new Post());
		return "filter";
	}

	@GetMapping("/filteredpost")
	public String filterPost(@ModelAttribute("deletePost") Post post, Model model) 
	{
		List<Post> postList;
		postList = advert.Filter(post);
		model.addAttribute("postlist", postList);
		return "home";
	}

}
