package com.watchhive.dto.request;

import com.watchhive.validation.StrongPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDto
{
	@NotBlank(message = "Username cannot be blank")
	private String username;

	@Email(message = "Invalid email format")
	@NotBlank(message = "Email cannot be blank")
	private String email;

	@StrongPassword
	private String password;

	private String profilePicture;

	@Size(max = 250, message = "Bio cannot be longer than 250 characters")
	private String bio;
}
