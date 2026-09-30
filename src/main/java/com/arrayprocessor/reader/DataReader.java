package com.arrayprocessor.reader;

import com.arrayprocessor.exception.ArrayProcessingException;

import java.util.List;

public interface DataReader {

    List<String> readLines(String filePath) throws ArrayProcessingException;
}
