package com.watchhive.exception;

// Base Exception Class
public abstract class AppException extends RuntimeException
{
	private final int status;

	protected AppException(String message, int status)
	{
		super(message);
		this.status = status;
	}

	public int getStatus()
	{
		return status;
	}
}
