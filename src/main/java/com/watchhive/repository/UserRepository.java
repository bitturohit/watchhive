package com.watchhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watchhive.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	// useful for validation
	boolean existsByEmail(String email);
}
