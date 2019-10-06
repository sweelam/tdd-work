package com.sweelam.tdd.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	private String password;
	private Pattern pattern;
	private Matcher matcher;

	public PasswordValidator(String password) throws IllegalArgumentException {
		if (null == password || password.length() == 0)
			throw new IllegalArgumentException("Password should be present");

		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public boolean isValidPassword(String password) {
		return containsAlphanumeric(password) && isPasswordLengthValid(password) && !containsSpaces(password)
				&& containsSpecialCharcters(password);
	}

	public boolean containsAlphanumeric(String password2) {
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(password2);
		return matcher.matches();
	}

	public boolean containsSpecialCharcters(String password2) {
		String regex = "^(?=.*[@#$%^&*_+-]).*$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(password2);
		return matcher.matches();
	}

	public boolean isPasswordLengthValid(String password) {
		return password.length() >= 8;
	}

	public boolean containsSpaces(String password2) {
		return password2.contains(" ");
	}

}
