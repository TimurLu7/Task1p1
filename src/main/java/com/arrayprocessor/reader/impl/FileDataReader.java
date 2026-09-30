package com.arrayprocessor.reader.impl;

import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.reader.DataReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileDataReader implements DataReader {

    private static final Logger LOGGER = LogManager.getLogger(FileDataReader.class);

    @Override
    public List<String> readLines(String filePath) throws ArrayProcessingException {
        if (filePath == null) {
            throw new ArrayProcessingException("File path must not be null");
        }
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new ArrayProcessingException("File does not exist: " + filePath);
        }
        try {
            List<String> lines = Files.readAllLines(path);
            LOGGER.info("Read {} lines from file {}", lines.size(), filePath);
            return lines;
        } catch (IOException exception) {
            LOGGER.error("Failed to read file: {}", filePath, exception);
            throw new ArrayProcessingException("Failed to read file: " + filePath, exception);
        }
    }
}
