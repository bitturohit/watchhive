package com.watchhive.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Object>> handleValidationErrors(
			MethodArgumentNotValidException ex)
	{
		// Collect all field errors into a map
		Map<String, String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.collect(Collectors.toMap(FieldError::getField, // Function to extract the key
						DefaultMessageSourceResolvable::getDefaultMessage, // Function to extract the value
						(existing, replacement) -> existing // merge function handles duplicate keys
				));

		ApiResponse<Object> response = ApiResponse.builder()
				.success(false)
				.message("Validation failed")
				.data(errors)
				.status(HttpStatus.BAD_REQUEST.value())
				.build();

		return ResponseEntity.badRequest().body(response);
	}
}
