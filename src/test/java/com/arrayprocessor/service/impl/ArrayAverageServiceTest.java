package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayAverageServiceImplTest {

    private static final int[] ELEMENTS = {5, 3, 9, 1, 7};
    private static final double EXPECTED_AVERAGE = 5.0;

    private final ArrayAverageServiceImpl service = new ArrayAverageServiceImpl();

    @Test
    void givenArray_whenCalculateAverage_thenReturnsAverage() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        Optional<Double> result = service.calculateAverage(array);

        assertEquals(Optional.of(EXPECTED_AVERAGE), result);
    }

    @Test
    void givenEmptyArray_whenCalculateAverage_thenReturnsEmptyOptional() throws ArrayProcessingException {
        IntArray array = new IntArray(new int[0]);

        Optional<Double> result = service.calculateAverage(array);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenNullArray_whenCalculateAverage_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> service.calculateAverage(null));
    }
}