package com.watchhive.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// strong password actual logic

public class PasswordValidator implements ConstraintValidator<StrongPassword, String>
{
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context)
	{
		if (password == null)
		{
			return false;
		}
		return password.matches(PASSWORD_PATTERN);
	}

}
