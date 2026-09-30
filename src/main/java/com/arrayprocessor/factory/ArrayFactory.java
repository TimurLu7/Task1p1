package com.arrayprocessor.factory;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;

public interface ArrayFactory {

    AbstractArray create(int[] elements) throws ArrayProcessingException;
}
