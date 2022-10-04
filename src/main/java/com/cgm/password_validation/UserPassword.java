package com.cgm.password_validation;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
public class UserPassword {

    public final static Integer MIN_LENGTH = 8;

    public final static Integer UNDERSCORE_CODE = 95;

    private final String password;

    public Boolean isValid() {
        return this.hasValidLength()
                && this.hasCapitalLetter()
                && this.hasLowercase()
                && this.hasNumber()
                && this.hasUnderscore();
    }

    public Boolean hasValidLength() {
        return StringUtils.length(this.password) > MIN_LENGTH;
    }

    public Boolean hasCapitalLetter() {
        return this.password.codePoints().anyMatch(Character::isUpperCase);
    }

    public Boolean hasLowercase() {
        return this.password.codePoints().anyMatch(Character::isLowerCase);
    }

    public Boolean hasNumber() {
        return this.password.codePoints().anyMatch(Character::isDigit);
    }

    public Boolean hasUnderscore() {
        return this.password.codePoints().anyMatch(value -> UNDERSCORE_CODE == value);
    }

}
