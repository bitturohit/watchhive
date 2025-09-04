package com.watchhive.exception;

import org.springframework.http.HttpStatus;

// custom exception
public class UserNotFoundException extends AppException
{
	public UserNotFoundException(String message)
	{
		super(message, HttpStatus.NOT_FOUND.value());
	}
}
