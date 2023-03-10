package com.group8.roommatefinder.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler 
{

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { BadRequestException.class })
	public ResponseEntity<Object> badRequestException(BadRequestException e) 
	{
		BadException badException = new BadException(e.getMessage(), HttpStatus.BAD_REQUEST,
				ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(badException, HttpStatus.BAD_REQUEST);
	}
}
