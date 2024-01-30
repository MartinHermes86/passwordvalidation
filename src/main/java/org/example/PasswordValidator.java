package org.example;

import java.security.SecureRandom;
import java.util.Random;

import at.favre.lib.crypto.bcrypt.BCrypt;

/*
Method to Check Minimum Length
Name: validateMinimumLength
Input Parameter: password (type: String). This is the password to be validated.
Return Type: Boolean. Returns true if the password meets the minimum length requirement, otherwise false.
Description: This method checks if the provided password is at least 8 characters long.

Method to Check for Digits
Name: containsDigits
Input Parameter: password (type: String). This is the password to be validated.
Return Type: Boolean. Returns true if the password contains at least one digit, otherwise false.
Description: This method verifies whether the password includes any numeric digits (0-9).

Method to Check for Mixed Case Letters
Name: hasMixedCase
Input Parameter: password (type: String). This is the password to be validated.
Return Type: Boolean. Returns true if the password contains both uppercase and lowercase letters, otherwise false.
Description: This method checks if the password has a mix of uppercase and lowercase letters,
ensuring a basic level of complexity.

Method to Detect Commonly Used Passwords
Name: isCommonPassword
Input Parameter: password (type: String). This is the password to be validated.
Return Type: Boolean. Returns true if the password is found in a list of commonly used passwords, otherwise false.
Description: This method compares the provided password against a predefined list of commonly used or compromised passwords
(such as "123456", "password", "qwerty", etc.). This list should be sourced from a reliable and frequently updated database.

 */
public class PasswordValidator {

    public static boolean validateMinimumLength(String password) {

        return password != null && password.length() >= 8;
    }

    public static boolean containsDigits(String password) {
        return password.matches(".*\\d.*");
        //The regular expression .*\\d.* is used here, where \\d represents any digit,
        // and .* means any number of characters before and after the digit.
    }

    public static boolean hasMixedCase(String password) {

        return password.matches("(?=.*[a-z])(?=.*[A-Z]).+");
    }

    public static final String[] COMMON_PASSWORDS = {
            "Password1", "123456", "password", "12345678", "qwerty", "qwertz",
            "123456789", "12345", "1234567890", "passwort", "Passwort", "passwort123"};

    public static boolean isCommonPassword(String password) {
        for (String commonPassword : COMMON_PASSWORDS) {
            if (commonPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSpecialCharacters(String password) {
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String DIGITS = "0123456789";
    public static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";
    public static final int PASSWORD_LENGTH = 16;

    public static String generateSecurePassword() {
        String combinedChars = LOWERCASE_CHARS + UPPERCASE_CHARS + DIGITS + SPECIAL_CHARS;
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }

        String generatedPassword = password.toString();

        // Ensure the generated password meets all criteria
        if (!PasswordValidator.containsDigits(generatedPassword)
                || !PasswordValidator.containsSpecialCharacters(generatedPassword)
                || !PasswordValidator.hasMixedCase(generatedPassword)
                || PasswordValidator.isCommonPassword(generatedPassword)) {
            return generateSecurePassword();
        }

        return generatedPassword;
    }

    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
}