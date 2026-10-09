package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.service.ArraySearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArraySearchServiceImpl implements ArraySearchService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySearchServiceImpl.class);

    @Override
    public Optional<Integer> findMin(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        int min = elements[0];
        for (int element : elements) {
            if (element < min) {
                min = element;
            }
        }
        LOGGER.debug("Found min value: {}", min);
        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        int max = elements[0];
        for (int element : elements) {
            if (element > max) {
                max = element;
            }
        }
        LOGGER.debug("Found max value: {}", max);
        return Optional.of(max);
    }
}
