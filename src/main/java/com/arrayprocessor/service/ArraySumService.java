package com.arrayprocessor.service;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;

import java.util.Optional;

public interface ArraySumService {

    Optional<Long> calculateSum(AbstractArray array) throws ArrayProcessingException;
}
