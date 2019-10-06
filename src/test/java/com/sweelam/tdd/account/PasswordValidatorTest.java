package com.sweelam.tdd.account;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class PasswordValidatorTest {
	private static final String PASSWORD = "Oyt$09765_";

	PasswordValidator psValidator;

	@Before
	public void init() {
		psValidator = new PasswordValidator(PASSWORD);
	}

	@Test
	public void constructorShouldSetPassword() {
		assertNotNull("Password should not be null", psValidator.getPassword());
	}

	@Test(expected = IllegalArgumentException.class)
	public void constructorMustSetPassword() {
		PasswordValidator psValidator = new PasswordValidator("");
		assertNotNull(psValidator.getPassword());
	}

	@Test
	public void passwordShouldbeAtLeastEightChars() {
		assertTrue("Password must be at least 8 characters", psValidator.isPasswordLengthValid(PASSWORD));
	}

	@Test
	public void passwordShouldContainAlphanumeric() {
		assertTrue("Password must contain alphnumeric", psValidator.containsAlphanumeric(PASSWORD));
	}

	@Test
	public void passwordShouldContainSpecialCharacters() {
		assertTrue("Password must contain special charcters", psValidator.containsSpecialCharcters(PASSWORD));
	}

	@Test
	public void passwordShouldnotContainSpace() {
		assertTrue("Password should contain spaces", !psValidator.containsSpaces(PASSWORD));
	}

	public Object[] passwordMextures() {
		return $("hytb_qweT123", "Trop&%po765", "Kr34%@109bn");
	}

	@Test
	@Parameters(method = "passwordMextures")
	public void isValidPassword(String passwordMextures) {
		assertTrue("Password is valid", psValidator.isValidPassword(passwordMextures));
	}
	
	
	public Object[] passwordNonValidMextures() {
		return $("hytb_ qweT123", "trop&%po765", "Kr34109bn");
	}

	@Test
	@Parameters(method = "passwordNonValidMextures")
	public void isNotValidPassword(String passwordNonValidMextures) {
		assertFalse("Password is not valid", psValidator.isValidPassword(passwordNonValidMextures));
	}
}
