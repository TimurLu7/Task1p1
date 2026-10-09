package com.arrayprocessor.service;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;

import java.util.Optional;

public interface ArrayAverageService {

    Optional<Double> calculateAverage(AbstractArray array) throws ArrayProcessingException;
}
