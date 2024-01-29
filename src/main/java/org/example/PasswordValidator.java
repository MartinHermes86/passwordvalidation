package org.example;


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
    public static void main(String[] args) {
    }

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


    private static final String[] COMMON_PASSWORDS = {
            "Password1", "123456", "password", "12345678", "qwerty", "qwertz",
            "123456789", "12345", "0123456789", "1234567890", "passwort", "Passwort", "passwort123"};

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
}