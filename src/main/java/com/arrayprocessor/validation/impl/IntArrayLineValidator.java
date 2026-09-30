package com.arrayprocessor.validation.impl;

import com.arrayprocessor.validation.ArrayLineValidator;

import java.util.regex.Pattern;

public class IntArrayLineValidator implements ArrayLineValidator {

    private static final Pattern VALID_PATTERN =
            Pattern.compile("^\\s*-?\\d+(\\s*,\\s*-?\\d+)*\\s*$");

    private static final Pattern EMPTY_PATTERN = Pattern.compile("^\\s*$");

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }
        if (EMPTY_PATTERN.matcher(line).matches()) {
            return true;
        }
        return VALID_PATTERN.matcher(line).matches();
    }
}
