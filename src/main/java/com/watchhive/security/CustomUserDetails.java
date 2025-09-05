package com.watchhive.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.watchhive.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails
{
	private final User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		// for now: everyone has no special roles
		return Collections.emptyList();
	}

	@Override
	public String getPassword()
	{
		return user.getPassword(); // // must be encoded in DB
	}

	@Override
	public String getUsername()
	{
		return user.getEmail(); // // we treat email as username
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

}
