package com.watchhive.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//custom annotation for strong password

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(
{ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword
{
	String message() default "Password must contain at least one uppercase letter, one lowercase letter, one digit, one special character, and be at least 8 characters long";

	Class<?>[] groups() default
	{};

	Class<? extends Payload>[] payload() default
	{};
}
