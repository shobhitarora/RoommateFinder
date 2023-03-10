package com.group8.roommatefinder.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException 
{
	public BadRequestException(String msg) 
	{
		super(msg);
	}

}
