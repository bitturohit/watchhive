package com.watchhive.response;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse
{
	private final boolean success;
	private final String message; // General error message
	private final Map<String, String> errors; // Field-specific errors (for validation)
	private final int status; // HTTP status code
	private final LocalDateTime timestamp;
}
