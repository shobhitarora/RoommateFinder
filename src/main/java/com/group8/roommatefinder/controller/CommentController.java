package com.group8.roommatefinder.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.group8.roommatefinder.model.Comment;
import com.group8.roommatefinder.model.FetchComment;

@Controller
public class CommentController 
{

	@Autowired
	private FetchComment fetchComment;

	@GetMapping("/comments/{post_id}")
	public String getById(@PathVariable int post_id, Model model) 
	{
		List<Comment> commentlist = fetchComment.fetchCommentsByPostId(post_id);
		model.addAttribute("commentlist", commentlist);
		return "viewComments";
	}
}
