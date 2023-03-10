package com.group8.roommatefinder;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.group8.roommatefinder.model.Comment;
import com.group8.roommatefinder.model.FetchComment;
import com.group8.roommatefinder.persistence.CommentRepository;

class FetchCommentTest 
{

	private static FetchComment fetchComment;
	
	@MockBean
	private static CommentRepository commentRepository;
	
	@BeforeAll
	public static void setup() 
	{
		commentRepository = Mockito.mock(CommentRepository.class);
		fetchComment = new FetchComment(commentRepository);
	}
	
	@Test
	public void fetchCommentsByPostIdSucessTest() 
	{
		List<Comment> commentList= new ArrayList<Comment>();
		
		Comment comment1= new Comment();
		comment1.setComment_id(7);
		comment1.setPost_id(9);
		comment1.setContent("Interested");
		comment1.setEmail_id ("hermoine@gmail.com");
		
		Comment comment2= new Comment();
		comment2.setComment_id(8);
		comment2.setPost_id(11);
		comment2.setContent("Test comment content 2");
		comment2.setEmail_id ("h2@gmail.com");
		
		commentList.add(comment2);
		commentList.add(comment1);
		
		when(commentRepository.getCommentByPostId(comment1.getPost_id())).thenReturn(commentList);
		assertEquals(commentList,fetchComment.fetchCommentsByPostId(comment1.getPost_id()));
	}
	
	@Test
	public void fetchCommentsByPostIdUnSucessTest() 
	{
		List<Comment> commentList= new ArrayList<Comment>();
		
		Comment comment1= new Comment();
		comment1.setComment_id(7);
		comment1.setPost_id(9);
		comment1.setContent("Interested");
		comment1.setEmail_id ("hermoine@gmail.com");
		
		Comment comment2= new Comment();
		comment2.setComment_id(8);
		comment2.setPost_id(11);
		comment2.setContent("Test comment content 2");
		comment2.setEmail_id ("h2@gmail.com");
		
		commentList.add(comment2);
		commentList.add(comment1);
		
		when(commentRepository.getCommentByPostId(comment1.getPost_id())).thenReturn(commentList);
		assertNotEquals(commentList,fetchComment.fetchCommentsByPostId(comment2.getPost_id()));
	}

}
