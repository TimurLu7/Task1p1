package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraySumServiceImplTest {

    private static final int[] ELEMENTS = {5, 3, 9, 1, 7};
    private static final long EXPECTED_SUM = 25L;

    private final ArraySumServiceImpl service = new ArraySumServiceImpl();

    @Test
    void givenArray_whenCalculateSum_thenReturnsSum() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        Optional<Long> result = service.calculateSum(array);

        assertEquals(Optional.of(EXPECTED_SUM), result);
    }

    @Test
    void givenEmptyArray_whenCalculateSum_thenReturnsEmptyOptional() throws ArrayProcessingException {
        IntArray array = new IntArray(new int[0]);

        Optional<Long> result = service.calculateSum(array);

        assertTrue(result.isEmpty());
    }

    @Test
    void givenNullArray_whenCalculateSum_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> service.calculateSum(null));
    }
}