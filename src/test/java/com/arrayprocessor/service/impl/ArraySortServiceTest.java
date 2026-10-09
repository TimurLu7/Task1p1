package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.IntArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraySortServiceImplTest {

    private static final int[] ELEMENTS = {5, 3, 9, 1, 7};
    private static final int[] EXPECTED_SORTED = {1, 3, 5, 7, 9};

    private final ArraySortServiceImpl service = new ArraySortServiceImpl();

    @Test
    void givenArray_whenSortByBubble_thenReturnsSortedArray() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        int[] result = service.bubbleSort(array);

        assertArrayEquals(EXPECTED_SORTED, result);
    }

    @Test
    void givenArray_whenSortByInsertion_thenReturnsSortedArray() throws ArrayProcessingException {
        IntArray array = new IntArray(ELEMENTS);

        int[] result = service.sortByInsertion(array);

        assertArrayEquals(EXPECTED_SORTED, result);
    }

    @Test
    void givenAlreadySortedArray_whenSortByBubble_thenReturnsSameArray() throws ArrayProcessingException {
        IntArray array = new IntArray(EXPECTED_SORTED);

        int[] result = service.bubbleSort(array);

        assertArrayEquals(EXPECTED_SORTED, result);
    }

    @Test
    void givenArrayWithDuplicates_whenSortByInsertion_thenReturnsSortedArray() throws ArrayProcessingException {
        IntArray array = new IntArray(new int[]{3, 1, 3, 2, 1});
        int[] expected = {1, 1, 2, 3, 3};

        int[] result = service.sortByInsertion(array);

        assertArrayEquals(expected, result);
    }

    @Test
    void givenNullArray_whenSortByBubble_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> service.bubbleSort(null));
    }

    @Test
    void givenNullArray_whenSortByInsertion_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> service.sortByInsertion(null));
    }
}