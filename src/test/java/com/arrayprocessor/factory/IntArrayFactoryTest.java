package com.arrayprocessor.factory;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerArrayFactoryTest {

    private final IntArrayFactory factory = new IntArrayFactory();

    @Test
    void givenValidElements_whenCreate_thenReturnsIntegerArray() throws ArrayProcessingException {
        int[] elements = {1, 2, 3};

        AbstractArray array = factory.create(elements);

        assertTrue(array instanceof IntArray);
        assertEquals(3, array.length());
        assertArrayEquals(elements, array.getElements());
    }

    @Test
    void givenNullElements_whenCreate_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> factory.create(null));
    }

    @Test
    void givenEmptyElements_whenCreate_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> factory.create(new int[0]));
    }
}