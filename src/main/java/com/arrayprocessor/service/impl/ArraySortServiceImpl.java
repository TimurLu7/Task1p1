package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public int[] bubbleSort(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        int[] elements = array.getElements();
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - 1 - i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
        LOGGER.debug("Bubble sort result: {}", Arrays.toString(elements));
        return elements;
    }

    @Override
    public int[] sortByInsertion(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        int[] elements = array.getElements();
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
        LOGGER.debug("Insertion sort result: {}", Arrays.toString(elements));
        return elements;
    }
}
