package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void validateMinimumLength() {

        assertTrue(PasswordValidator.validateMinimumLength("12345678"));
        assertFalse(PasswordValidator.validateMinimumLength("1234567"));
        assertTrue(PasswordValidator.validateMinimumLength("123456789"));
        assertFalse(PasswordValidator.validateMinimumLength(""));
        }

    @Test
    void testContainsDigits() {
        assertTrue(PasswordValidator.containsDigits("password123"), "Password contains digits");
        assertFalse(PasswordValidator.containsDigits("password"), "Password does not contain digits");
        assertTrue(PasswordValidator.containsDigits("12345"), "Password contains only digits");
        assertFalse(PasswordValidator.containsDigits(""), "Empty string should not contain digits");
        assertFalse(PasswordValidator.containsDigits("PASSWORD!@"), "Password with special characters and no digits");
    }

    @Test
    void testHasMixedCase(){
        assertTrue(PasswordValidator.hasMixedCase("Password123"), "Password with mixed case");
        assertFalse(PasswordValidator.hasMixedCase("password123"), "Password with only lowercase");
        assertFalse(PasswordValidator.hasMixedCase("PASSWORD123"), "Password with only uppercase");
        assertFalse(PasswordValidator.hasMixedCase("12345678"), "Password without letters");
        assertFalse(PasswordValidator.hasMixedCase(""), "Empty password");
        assertTrue(PasswordValidator.hasMixedCase("PassWord"), "Password with mixed case and no digits");
    }

    @Test
    void testIsCommonPassword() {
        assertTrue(PasswordValidator.isCommonPassword("Password1"), "Common password should be detected");
        assertTrue(PasswordValidator.isCommonPassword("passwort123"), "Common password should be detected");
        assertFalse(PasswordValidator.isCommonPassword("UncommonPass123!"), "Uncommon password should not be detected");
        assertFalse(PasswordValidator.isCommonPassword("Another$ecureP@ss"), "Uncommon password should not be detected");
    }

    @Test
    void testContainsSpecialCharacters() {
        assertTrue(PasswordValidator.containsSpecialCharacters("Pass@word1"), "Password contains special characters");
        assertFalse(PasswordValidator.containsSpecialCharacters("Password1"), "Password without special characters");
        assertTrue(PasswordValidator.containsSpecialCharacters("@#$%^&*"), "Password with only special characters");
        assertFalse(PasswordValidator.containsSpecialCharacters("12345678"), "Password with numbers only");
        assertFalse(PasswordValidator.containsSpecialCharacters(""), "Empty password");
        assertTrue(PasswordValidator.containsSpecialCharacters("abcD123#"), "Password with mixed characters and special character");
    }

}
