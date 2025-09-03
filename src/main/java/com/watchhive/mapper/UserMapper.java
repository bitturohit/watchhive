package com.watchhive.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.watchhive.dto.request.UserRequestDto;
import com.watchhive.dto.response.UserResponseDto;
import com.watchhive.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper
{
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "role", constant = "USER")
	@Mapping(target = "enabled", constant = "true")
	User toEntity(UserRequestDto dto);

	UserResponseDto toResponse(User user);
}
