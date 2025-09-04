package com.watchhive.exception;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.watchhive.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler
{
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex)
	{
		ErrorResponse response = ErrorResponse.builder()
				.success(false)
				.message(ex.getMessage())
				.errors(null)
				.status(HttpStatus.NOT_FOUND.value())
				.timestamp(LocalDateTime.now())
				.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationErrors(
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

		ErrorResponse response = ErrorResponse.builder()
				.success(false)
				.message("Validation failed")
				.errors(errors)
				.status(HttpStatus.BAD_REQUEST.value())
				.timestamp(LocalDateTime.now())
				.build();

		return ResponseEntity.badRequest().body(response);
	}
}
