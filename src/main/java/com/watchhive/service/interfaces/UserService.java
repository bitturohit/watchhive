package com.watchhive.service.interfaces;

import com.watchhive.dto.request.UserRequestDto;
import com.watchhive.dto.response.UserResponseDto;

public interface UserService
{
	UserResponseDto registerUser(UserRequestDto requestDto);

	UserResponseDto getUserById(Long id);
}
