package com.arrayprocessor.service;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;

import java.util.Optional;

public interface ArraySearchService {

    Optional<Integer> findMin(AbstractArray array) throws ArrayProcessingException;

    Optional<Integer> findMax(AbstractArray array) throws ArrayProcessingException;
}
