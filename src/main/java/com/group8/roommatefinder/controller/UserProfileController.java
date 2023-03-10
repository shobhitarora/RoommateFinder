package com.group8.roommatefinder.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.group8.roommatefinder.model.CookieHandler;
import com.group8.roommatefinder.model.IPostAdvert;
import com.group8.roommatefinder.model.ISaveViewUserProfile;
import com.group8.roommatefinder.model.Post;
import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserProfile;
import com.group8.roommatefinder.persistence.UserProfileRepository;

import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserProfileController 
{

	@Autowired
	private ISaveViewUserProfile saveViewProfile;

	@Autowired
	private UserProfileRepository proRepo;
	
	@Autowired
	private IPostAdvert advert;

	@GetMapping("/displayprofile")
	public String diplayProfile(Model model, HttpServletRequest req) 
	{
		String email = CookieHandler.getinstance().getCookie(req);
		UserProfile userProfile = proRepo.getProfileById(email);
		model.addAttribute("profile", userProfile);
		return "displayprofile";
	}

	@GetMapping("/saveprofile")
	public String createProfile(Model model) 
	{
		UserProfile prof= new UserProfile();
		model.addAttribute("createprofile",prof);
		return "createprofile";
	}

	@PostMapping("/saveprofile")
	public RedirectView saveProfile(@ModelAttribute("createprofile") UserProfile userProfile, HttpServletRequest req) 
	{
		userProfile.setEmailId(CookieHandler.getinstance().getCookie(req));
		saveViewProfile.saveProfile(userProfile);
		return new RedirectView("/allpost");
	}

	@PostMapping("/updateprofile")
	public void updateProfile(@RequestBody UserProfile userProfile, HttpServletRequest request) 
	{
		userProfile.setEmailId(CookieHandler.getinstance().getCookie(request));
		saveViewProfile.updateProfile(userProfile);
	}

	@GetMapping("/resetpassword")
	public String resetPassword(Model model) 
	{
		UserAccount userAccount = new UserAccount();
		model.addAttribute("profile", userAccount);
		return "resetpassword";
	}

	@PostMapping("/resetpassword")
	public RedirectView resetPasswordInDataBase(@ModelAttribute UserAccount userAccount, @RequestParam(value = "confirmPassword") String confirmPassword,HttpServletRequest req) 
	{
		if (userAccount.getPassword().equals(confirmPassword))
		{
			String currentUserEmail= CookieHandler.getinstance().getCookie(req);
			saveViewProfile.resetPasword(userAccount, currentUserEmail);
			return new RedirectView("/passwordsuccesspage");
		} 
		else 
		{
			return new RedirectView("/resetpassword");
		}
	}
	
	@GetMapping("/passwordsuccesspage")
	public String Passwordsuccesspage() 
	{
		return "passwordsuccesspage";
	}

	@GetMapping("/editdetails")
	public String editProfileDetails(Model model, HttpServletRequest req) 
	{
		String email = CookieHandler.getinstance().getCookie(req);
		UserProfile userProfile = proRepo.getProfileById(email);
		model.addAttribute("profile", userProfile);
		return "editprofiledetails";
	}

	@PostMapping("/editdetails")
	public RedirectView editProfilesDetails(@ModelAttribute UserProfile userProfile, HttpServletRequest req) 
	{
		userProfile.setEmailId(CookieHandler.getinstance().getCookie(req));
		saveViewProfile.updateProfile(userProfile);
		return new RedirectView("/displayprofile");
	}
	
	@GetMapping("/addpost")
	public String getPostDetails(Model model) 
	{
		model.addAttribute("addPost",new Post());
		return "addpost";
	}
	
	@GetMapping("/updatepost")
	public String updatePostDetails(Model model) 
	{
		model.addAttribute("updatepost",new Post());
		return "updatepost";
	}
	
	@GetMapping("/deletepost")
	public String deletePost(Model model) 
	{
		Post post =new Post();
		model.addAttribute("deletePost", post);
		return "deletepost";
	}
	
	@PostMapping("/deleteposted")
	public RedirectView deletePosted(@ModelAttribute("deletePost") Post post,HttpServletRequest req) 
	{
		post.setEmailId(CookieHandler.getinstance().getCookie(req));
		advert.deletePost(post);
		return new RedirectView("/displayprofile");
	}
	
}
