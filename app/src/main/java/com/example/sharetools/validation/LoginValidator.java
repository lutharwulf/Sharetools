package com.example.sharetools.validation;

import android.util.Patterns;

public class LoginValidator {
    public static boolean isValidEmail(String email) {
        return email != null && !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return password != null && !password.isEmpty();
    }
}
