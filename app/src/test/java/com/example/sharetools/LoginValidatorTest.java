package com.example.sharetools;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.example.sharetools.validation.LoginValidator;

import org.junit.Test;

public class LoginValidatorTest {

    @Test
    public void testValidEmail() {
        assertTrue(LoginValidator.isValidEmail("test@example.com"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(LoginValidator.isValidEmail("invalid-email"));
    }

    @Test
    public void testEmptyEmail() {
        assertFalse(LoginValidator.isValidEmail(""));
    }

    @Test
    public void testNullEmail() {
        assertFalse(LoginValidator.isValidEmail(null));
    }

    @Test
    public void testValidPassword() {
        assertTrue(LoginValidator.isValidPassword("password"));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(LoginValidator.isValidPassword(""));
    }

    @Test
    public void testNullPassword() {
        assertFalse(LoginValidator.isValidPassword(null));
    }
}