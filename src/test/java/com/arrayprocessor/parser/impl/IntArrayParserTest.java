package com.arrayprocessor.parser.impl;

import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.validation.impl.IntArrayLineValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerArrayParserTest {

    private final IntArrayParser parser =
            new IntArrayParser(new IntArrayLineValidator());

    @Test
    void givenValidLine_whenParse_thenReturnsArray() throws ArrayProcessingException {
        String line = "1, 2, 3";

        int[] result = parser.parse(line);

        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void givenInvalidLine_whenParse_thenThrowsException() {
        String line = "1y1 21 32";

        assertThrows(ArrayProcessingException.class, () -> parser.parse(line));
    }
}