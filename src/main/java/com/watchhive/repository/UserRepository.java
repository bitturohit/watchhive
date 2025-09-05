package com.watchhive.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watchhive.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	// for registration validation
	boolean existsByEmail(String email);

	// for authentication
	Optional<User> findByEmail(String email);
}
