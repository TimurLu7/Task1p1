package com.arrayprocessor.reader.impl;

import com.arrayprocessor.exception.ArrayProcessingException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileDataReaderTest {

    private static final String VALID_FILE_PATH = "resources/data/arrays.txt";
    private static final String MISSING_FILE_PATH = "resources/data/missing.txt";

    private final FileDataReader reader = new FileDataReader();

    @Test
    void givenValidFilePath_whenReadLines_thenReturnsLines() throws ArrayProcessingException {
        List<String> lines = reader.readLines(VALID_FILE_PATH);

        assertTrue(lines.size() > 0);
    }

    @Test
    void givenNullFilePath_whenReadLines_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> reader.readLines(null));
    }

    @Test
    void givenMissingFile_whenReadLines_thenThrowsException() {
        assertThrows(ArrayProcessingException.class, () -> reader.readLines(MISSING_FILE_PATH));
    }
}