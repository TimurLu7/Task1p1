package com.arrayprocessor.parser;

import com.arrayprocessor.exception.ArrayProcessingException;

public interface ArrayParser {

    int[] parse(String line) throws ArrayProcessingException;
}
