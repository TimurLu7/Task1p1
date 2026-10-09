package com.arrayprocessor.validation.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerArrayLineValidatorTest {

    private final IntArrayLineValidator validator = new IntArrayLineValidator();

    @Test
    void givenValidCommaSeparatedLine_whenIsValid_thenReturnsTrue() {
        String line = "1, 2, 3";

        boolean valid = validator.isValid(line);

        assertTrue(valid);
    }

    @Test
    void givenEmptyLine_whenIsValid_thenReturnsTrue() {
        String line = "";

        boolean valid = validator.isValid(line);

        assertTrue(valid);
    }

    @Test
    void givenInvalidLine_whenIsValid_thenReturnsFalse() {
        String line = "1y1 21 32";

        boolean valid = validator.isValid(line);

        assertFalse(valid);
    }
}