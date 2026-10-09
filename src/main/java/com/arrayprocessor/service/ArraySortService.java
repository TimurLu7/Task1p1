package com.arrayprocessor.service;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;

public interface ArraySortService {

    int[] bubbleSort(AbstractArray array) throws ArrayProcessingException;

    int[] sortByInsertion(AbstractArray array) throws ArrayProcessingException;
}
