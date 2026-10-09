package com.arrayprocessor.parser.impl;

import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.parser.ArrayParser;
import com.arrayprocessor.validation.ArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntArrayParser implements ArrayParser {

    private static final Logger LOGGER = LogManager.getLogger(IntArrayParser.class);

    private static final String DELIMITER_REGEX = "\\s*,\\s*";

    private final ArrayLineValidator validator;

    public IntArrayParser(ArrayLineValidator validator) {

        this.validator = validator;
    }

    @Override
    public int[] parse(String line) throws ArrayProcessingException {
        if (!validator.isValid(line)) {
            throw new ArrayProcessingException("Invalid line for parsing: " + line);
        }
        String trimmed = line.trim();
        if (trimmed.isEmpty()) {
            return new int[0];
        }
        String[] tokens = trimmed.split(DELIMITER_REGEX);
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i].trim());
        }
        LOGGER.debug("Parsed line '{}' into array of length {}", line, result.length);
        return result;
    }
}
