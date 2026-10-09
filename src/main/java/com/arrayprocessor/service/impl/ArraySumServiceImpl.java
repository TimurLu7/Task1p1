package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.service.ArraySumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArraySumServiceImpl implements ArraySumService {

    private static final Logger LOGGER = LogManager.getLogger(ArraySumServiceImpl.class);

    @Override
    public Optional<Long> calculateSum(AbstractArray array) throws ArrayProcessingException {
        if (array == null) {
            throw new ArrayProcessingException("Array must not be null");
        }
        int[] elements = array.getElements();
        if (elements.length == 0) {
            return Optional.empty();
        }
        long sum = 0L;
        for (int element : elements) {
            sum += element;
        }
        LOGGER.debug("Calculated sum: {}", sum);
        return Optional.of(sum);
    }
}
