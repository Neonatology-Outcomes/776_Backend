package com.neonatal.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neonatal.backend.entities.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == User.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User appUserForm = (User) target;

		// Check the fields of AppUserForm.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.appUserForm.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty.appUserForm.firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty.appUserForm.lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailaddress", "NotEmpty.appUserForm.emailaddress");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.appUserForm.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "NotEmpty.appUserForm.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleid", "NotEmpty.appUserForm.roleid");

		final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(appUserForm.getEmailaddress());
	          
		UserDAO userdao = new UserDAO();
		
		if (!matcher.matches()) {
			// Invalid email.
			errors.rejectValue("email", "Pattern.appUserForm.email");
		} else if (appUserForm.getUsername() == null) {
			User dbUser = userdao.findAppUserByEmail(appUserForm.getEmailaddress());
			if (dbUser != null) {
				// Email has been used by another account.
				errors.rejectValue("email", "Duplicate.appUserForm.email");
			}
		}

		if (!errors.hasFieldErrors("userName")) {
			User dbUser = userdao.findAppUserByUserName(appUserForm.getUsername());
			if (dbUser != null) {
				// Username is not available.
				errors.rejectValue("userName", "Duplicate.appUserForm.userName");
			}
		}
		
		/*
		if (!errors.hasErrors()) {
			if (!appUserForm.getConfirmPassword().equals(appUserForm.getPassword())) {
				errors.rejectValue("confirmPassword", "Match.appUserForm.confirmPassword");
			}
		}
		*/
	}
	
}