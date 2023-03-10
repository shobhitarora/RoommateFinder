package com.group8.roommatefinder.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.group8.roommatefinder.model.CookieHandler;
import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.RoomMateFinder;
import com.group8.roommatefinder.model.UserProfile;

@Controller
public class RoomMateFinderController 
{
	@Autowired
	RoomMateFinder roomMate;

	@GetMapping("/roommate")
	public String getRoomMate(HttpServletRequest request,Model model)
	{
		UserProfile userProfile;
		List<Post> posts=new ArrayList<>();
		String userEmail=CookieHandler.getinstance().getCookie(request);
		userProfile=roomMate.getCurrentUserProfile(userEmail);
		posts=roomMate.getRoomMate(userProfile);
		model.addAttribute("suggestions",posts);
		return "suggestions";
	}
}
