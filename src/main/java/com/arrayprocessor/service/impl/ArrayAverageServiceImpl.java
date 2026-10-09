package com.arrayprocessor.service.impl;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.service.ArrayAverageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayAverageServiceImpl implements ArrayAverageService {

    private static final Logger LOGGER = LogManager.getLogger(ArrayAverageServiceImpl.class);

    @Override
    public Optional<Double> calculateAverage(AbstractArray array) throws ArrayProcessingException {
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
        double average = (double) sum / elements.length;
        LOGGER.debug("Calculated average: {}", average);
        return Optional.of(average);
    }
}
