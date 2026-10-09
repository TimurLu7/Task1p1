package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraySearchServiceImplTest {

    private static final int[] ELEMENTS = {5, 3, 9, 1, 7};
    private static final int EXPECTED_MIN = 1;
    private static final int EXPECTED_MAX = 9;

    private final ArraySearchServiceImpl service = new ArraySearchServiceImpl();

    @Test
    void givenArray_whenFindMin_thenReturnsMinValue() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        Optional<Integer> result = service.findMin(array);

        assertEquals(Optional.of(EXPECTED_MIN), result);
    }

    @Test
    void givenArray_whenFindMax_thenReturnsMaxValue() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        Optional<Integer> result = service.findMax(array);

        assertEquals(Optional.of(EXPECTED_MAX), result);
    }

    @Test
    void givenEmptyArray_whenFindMin_thenReturnsEmptyOptional() throws ArrayProcessingException {
        IntArray array = new IntArray(new int[0]);

        Optional<Integer> result = service.findMin(array);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenNullArray_whenFindMin_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> service.findMin(null));
    }
}