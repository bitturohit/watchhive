package com.watchhive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WatchhiveApiApplication
{

	public static void main(String[] args)
	{
		System.out.println("heellooo");
		SpringApplication.run(WatchhiveApiApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner testuserRepo(UserRepository userRepository)
//	{
//		return (args) -> {
//			User user = User.builder()
//					.username("john_doe")
//					.email("john@example.com")
//					.password("secret123")
//					.profilePicture("human")
//					.bio("avid movie watcher")
//					.role("USER")
//					.enabled(true)
//					.build();
//
//			if (!userRepository.existsByEmail("john@example.com"))
//			{
//				userRepository.save(user);
//			}
//			System.out.println("User saved: " + user.getUsername());
//		};
//	}

}
