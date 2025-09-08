package com.watchhive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.watchhive.security.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig
{
	private final CustomUserDetailsService userDetailsService;

	// Password encoder (we’ll use BCrypt)
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	// Authentication provider (uses our UserDetailsService)
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(
				userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	// AuthenticationManager (needed for login)
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
			throws Exception
	{
		return config.getAuthenticationManager();
	}

	// Security filter chain (who can access what)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf(csrf -> csrf.disable()) // disable CSRF for APIs
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/**")
						.permitAll() // allow everything for now
						.anyRequest()
						.authenticated() // everything else requires login
				)
				.formLogin(login -> login.permitAll()); // temporary: use default login form

		return http.build();
	}

}
