package com.watchhive.mapper;

import org.mapstruct.Mapper;

import com.watchhive.dto.request.UserRequestDto;
import com.watchhive.dto.response.UserResponseDto;
import com.watchhive.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper
{
	User toEntity(UserRequestDto dto);

	UserResponseDto toResponse(User user);
}
