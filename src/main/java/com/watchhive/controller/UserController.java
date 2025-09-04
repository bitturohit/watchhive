package com.watchhive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.watchhive.dto.request.UserRequestDto;
import com.watchhive.dto.response.UserResponseDto;
import com.watchhive.response.ApiResponse;
import com.watchhive.service.interfaces.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController
{
	private final UserService userService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<UserResponseDto>> register(
			@Valid @RequestBody UserRequestDto requestDto)
	{
		UserResponseDto responseDto = userService.registerUser(requestDto);

		ApiResponse<UserResponseDto> response = ApiResponse.<UserResponseDto>builder()
				.success(true)
				.message("User registered successfully")
				.data(responseDto)
				.status(HttpStatus.CREATED.value())
				.build();

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable Long id)
	{

		UserResponseDto responseDto = userService.getUserById(id);

		ApiResponse<UserResponseDto> response = ApiResponse.<UserResponseDto>builder()
				.success(true)
				.message("User fetched successfully")
				.data(responseDto)
				.status(HttpStatus.OK.value())
				.build();

		return ResponseEntity.ok(response);
	}
}
