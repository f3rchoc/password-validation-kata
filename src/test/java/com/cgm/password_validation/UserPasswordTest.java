package com.cgm.password_validation;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserPasswordTest {

    private UserPassword userPassword;

    @BeforeEach
    void setUp() {
        this.userPassword = null;
    }

    @Test
    void password_should_have_more_than_8_characters () {

        // given
        final String password = RandomStringUtils.random(UserPassword.MIN_LENGTH+1);
        this.userPassword = new UserPassword(password);

        Assertions.assertEquals(true, this.userPassword.hasValidLength());

    }

    @Test
    void return_false_when_password_is_null () {

        // given
        this.userPassword = new UserPassword(null);
        Assertions.assertEquals(false, this.userPassword.hasValidLength());

    }

    @Test
    void return_false_when_password_length_is_less_or_equal_8 () {

        // given
        final String password = RandomStringUtils.random(UserPassword.MIN_LENGTH);
        this.userPassword = new UserPassword(password);

        Assertions.assertEquals(false, this.userPassword.hasValidLength());

    }

    @Test
    void password_contains_a_capital_letter () {

        final String password = "testPassword";
        this.userPassword = new UserPassword(password);
        Assertions.assertEquals(true, this.userPassword.hasCapitalLetter());

    }

    @Test
    void password_contains_a_lowercase () {

        final String password = "testPassword";
        this.userPassword = new UserPassword(password);
        Assertions.assertEquals(true, this.userPassword.hasLowercase());

    }

    @Test
    void password_contains_a_number () {

        final String password = "test0Password";
        this.userPassword = new UserPassword(password);
        Assertions.assertEquals(true, this.userPassword.hasNumber());

    }

    @Test
    void password_contains_a_underscore () {

        final String password = "test0_Password";
        this.userPassword = new UserPassword(password);
        Assertions.assertEquals(true, this.userPassword.hasUnderscore());

    }

    @Test
    void should_valid_password() {
        final String password = "test0_Password";
        this.userPassword = new UserPassword(password);
        Assertions.assertEquals(true, this.userPassword.isValid());
    }

}