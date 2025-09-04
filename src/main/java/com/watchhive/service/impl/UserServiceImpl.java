package com.watchhive.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.watchhive.dto.request.UserRequestDto;
import com.watchhive.dto.response.UserResponseDto;
import com.watchhive.entity.User;
import com.watchhive.exception.UserNotFoundException;
import com.watchhive.mapper.UserMapper;
import com.watchhive.repository.UserRepository;
import com.watchhive.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService
{
	private final UserMapper userMapper;
	private final UserRepository userRepository;

	@Override
	public UserResponseDto registerUser(UserRequestDto requestDto)
	{
		User user = userMapper.toEntity(requestDto);
		User savedUser = userRepository.save(user);

		return userMapper.toResponse(savedUser);
	}

	@Override
	public UserResponseDto getUserById(Long id)
	{
		User user = userRepository.findById(id)
				.orElseThrow(
						() -> new UserNotFoundException("User not found with id: " + id));

		return userMapper.toResponse(user);
	}

}
