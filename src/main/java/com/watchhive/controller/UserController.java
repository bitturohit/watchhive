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
import com.watchhive.entity.User;
import com.watchhive.mapper.UserMapper;
import com.watchhive.response.ApiResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController
{
	private final UserMapper userMapper;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<UserResponseDto>> register(
			@RequestBody UserRequestDto requestDto)
	{
		User user = User.builder()
				.username(requestDto.getUsername())
				.email(requestDto.getEmail())
				.password(requestDto.getPassword())
				.bio(requestDto.getBio())
				.profilePicture(requestDto.getProfilePicture())
				.enabled(true)
				.role("USER")
				.build();

		UserResponseDto responseDto = userMapper.toResponse(user);

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
		User user = User.builder()
				.username("john_doe")
				.email("john@example.com")
				.password("secret123")
				.profilePicture("avatar.png")
				.bio("avid movie watcher")
				.role("USER")
				.enabled(true)
				.build();

		UserResponseDto responseDto = userMapper.toResponse(user);

		ApiResponse<UserResponseDto> response = ApiResponse.<UserResponseDto>builder()
				.success(true)
				.message("User fetched successfully")
				.data(responseDto)
				.status(HttpStatus.OK.value())
				.build();

		return ResponseEntity.ok(response);
	}
}
