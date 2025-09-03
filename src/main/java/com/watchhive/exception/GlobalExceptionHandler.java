package com.watchhive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.watchhive.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse<Object>> handleUserNotFound(
			UserNotFoundException ex)
	{
		ApiResponse<Object> response = ApiResponse.builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.status(HttpStatus.NOT_FOUND.value())
				.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}
