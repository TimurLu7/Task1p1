package com.arrayprocessor.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class IntegerArrayTest {

    @Test
    void givenElements_whenCreateIntArray_thenElementsAreCopied() {
        int[] source = {1, 2, 3};

        IntArray array = new IntArray(source);

        assertArrayEquals(source, array.getElements());
        assertNotSame(source, array.getElements());
    }

    @Test
    void givenIntArray_whenLength_thenReturnsCorrectLength() {
        IntArray array = new IntArray(new int[]{1, 2, 3, 4});

        int length = array.length();

        assertEquals(4, length);
    }
}