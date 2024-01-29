package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class PasswordValidatorTest {


    @Test
    public void testValidateMinimumLength(){
        assertTrue("Password length is 8 and should be valid", PasswordValidator.validateMinimumLength("12345678"));
        assertFalse("Password length is less than 8 and should be invalid", PasswordValidator.validateMinimumLength("1234567"));
        assertTrue("Password length is more than 8 and should be valid", PasswordValidator.validateMinimumLength("123456789"));
        assertFalse("Empty password should be invalid", PasswordValidator.validateMinimumLength(""));
    }


}