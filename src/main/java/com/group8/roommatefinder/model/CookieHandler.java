package com.group8.roommatefinder.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class CookieHandler 
{
	
	private static CookieHandler handler;
	
	public static CookieHandler getinstance() 
	{
		if(handler==null) 
		{
			handler=new CookieHandler();
		}
		return handler;
	}

	public void setCookie(String emailid,HttpServletResponse response) 
	{
		Cookie cookie= new Cookie("roommatefinder.emailid",emailid);
		cookie.setMaxAge(60*60*24*3);
		response.addCookie(cookie);
	}
	
	public String getCookie(HttpServletRequest request) 
	{
		
		Cookie[] cookie=request.getCookies();
		List<String> cookieval= new ArrayList<String>();
		for(Cookie cookies : cookie) {
			String tobefound="roommatefinder.emailid";
		
			if(tobefound.equals(cookies.getName())) 
			{
				String mypost=cookies.getValue().toString();
				cookieval.add(cookies.getValue());
				
			}

		}


		return cookieval.get(0);
	}
	
	public boolean eraseCookie(HttpServletRequest req, HttpServletResponse resp) 
	{
	    Cookie[] cookies = req.getCookies();
	    if (cookies == null) 
	    {
	    	
	    }
	    else {
	        for (Cookie cookie : cookies) 
	        {
	            cookie.setValue("");
	            cookie.setPath("/");
	            cookie.setMaxAge(0);
	            resp.addCookie(cookie);
	        }
	        return true;
	    }
	    return false;
	}

}
