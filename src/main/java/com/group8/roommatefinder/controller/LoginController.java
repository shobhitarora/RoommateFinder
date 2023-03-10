package com.group8.roommatefinder.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.group8.roommatefinder.exception.BadRequestException;
import com.group8.roommatefinder.model.CookieHandler;
import com.group8.roommatefinder.model.UserAccount;
import com.group8.roommatefinder.model.UserRegistration;
import com.group8.roommatefinder.persistence.UserAccountRepository;

@Controller
public class LoginController 
{

	@Autowired
	private UserRegistration userRegistration;

	@Autowired
	private UserAccountRepository repo;

	@GetMapping("/")
	public String signUp() 
	{
		return "index";
	}

	@GetMapping("/users")
	public List<UserAccount> getUsers() 
	{
		return repo.getAllUsers();
	}

	@GetMapping("/signup")
	public String getSignup(Model model) 
	{
		model.addAttribute("userSignup", new UserAccount());
		return "signup";
	}

	@PostMapping("/signup")
	public RedirectView postSignup(@ModelAttribute("userSignup") UserAccount userAccount, HttpServletResponse resp) 
	{
		boolean userResponse = userRegistration.userSignup(userAccount);
		try 
		{
			if (userResponse) 
			{
				CookieHandler.getinstance().setCookie(userAccount.getEmailId(), resp);
				return new RedirectView("/saveprofile");
			} 
			return new RedirectView("/error");
		}
		catch(BadRequestException e) 
		{
			return new RedirectView("/error");
		}
		
	}

	@GetMapping("/login")
	public String getLoginMethod(Model model) 
	{
		model.addAttribute("userLogin", new UserAccount());
		return "login";
	}

	@PostMapping("/login")
	public RedirectView postLoginMethod(@ModelAttribute("userLogin") UserAccount userAccount, Model model,
			HttpServletResponse response) 
	{
		model.addAttribute("useremail", userAccount.getEmailId());
		boolean userResponse = userRegistration.userLogin(userAccount);
		if (userResponse) 
		{
			CookieHandler.getinstance().setCookie(userAccount.getEmailId(), response);
			return new RedirectView("/allpost");
		} 
		else 
		{
			return null;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) 
	{
		return "logout";
	}

	@PostMapping("/loggedout")
	public RedirectView logedout(HttpServletRequest req, HttpServletResponse resp) 
	{
		CookieHandler.getinstance().eraseCookie(req, resp);
		return new RedirectView("/login");
	}
	
	@GetMapping("/error")
	public String error(){
		return "error";
	}

}
