package com.arrayprocessor.runner;

import com.arrayprocessor.entity.AbstractArray;
import com.arrayprocessor.exception.ArrayProcessingException;
import com.arrayprocessor.factory.ArrayFactory;
import com.arrayprocessor.factory.IntArrayFactory;
import com.arrayprocessor.parser.ArrayParser;
import com.arrayprocessor.parser.impl.IntArrayParser;
import com.arrayprocessor.reader.DataReader;
import com.arrayprocessor.reader.impl.FileDataReader;
import com.arrayprocessor.service.ArrayAverageService;
import com.arrayprocessor.service.ArraySearchService;
import com.arrayprocessor.service.ArraySortService;
import com.arrayprocessor.service.ArraySumService;
import com.arrayprocessor.service.impl.ArrayAverageServiceImpl;
import com.arrayprocessor.service.impl.ArraySearchServiceImpl;
import com.arrayprocessor.service.impl.ArraySortServiceImpl;
import com.arrayprocessor.service.impl.ArraySumServiceImpl;
import com.arrayprocessor.validation.ArrayLineValidator;
import com.arrayprocessor.validation.impl.IntArrayLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class ArrayProcessRunner {

    private static final Logger LOGGER = LogManager.getLogger(ArrayProcessRunner.class);

    private static final String DATA_FILE_PATH = "resources/data/arrays.txt";

    public static void main(String[] args) {
        ArrayLineValidator validator = new IntArrayLineValidator();
        DataReader reader = new FileDataReader();
        ArrayParser parser = new IntArrayParser(validator);
        ArrayFactory factory = new IntArrayFactory();
        ArraySearchService searchService = new ArraySearchServiceImpl();
        ArraySumService sumService = new ArraySumServiceImpl();
        ArrayAverageService averageService = new ArrayAverageServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();

        List<String> lines;
        try {
            lines = reader.readLines(DATA_FILE_PATH);
        } catch (ArrayProcessingException exception) {
            LOGGER.error("Failed to read data file", exception);
            return;
        }

        for (String line : lines) {
            processLine(line, validator, parser, factory,
                    searchService, sumService, averageService, sortService);
        }
    }

    private static void processLine(String line,
                                    ArrayLineValidator validator,
                                    ArrayParser parser,
                                    ArrayFactory factory,
                                    ArraySearchService searchService,
                                    ArraySumService sumService,
                                    ArrayAverageService averageService,
                                    ArraySortService sortService) {
        if (!validator.isValid(line)) {
            LOGGER.warn("Skipping invalid line: '{}'", line);
            return;
        }
        try {
            int[] parsed = parser.parse(line);
            if (parsed.length == 0) {
                LOGGER.info("Skipping empty array line: '{}'", line);
                return;
            }
            AbstractArray array = factory.create(parsed);
            Optional<Integer> min = searchService.findMin(array);
            Optional<Integer> max = searchService.findMax(array);
            Optional<Long> sum = sumService.calculateSum(array);
            Optional<Double> average = averageService.calculateAverage(array);
            int[] bubbleSorted = sortService.bubbleSort(array);
            int[] insertionSorted = sortService.sortByInsertion(array);

            LOGGER.info("Line: '{}'", line);
            LOGGER.info("Min: {}", min.orElse(null));
            LOGGER.info("Max: {}", max.orElse(null));
            LOGGER.info("Sum: {}", sum.orElse(null));
            LOGGER.info("Average: {}", average.orElse(null));
            LOGGER.info("Bubble sorted: {}", java.util.Arrays.toString(bubbleSorted));
            LOGGER.info("Insertion sorted: {}", java.util.Arrays.toString(insertionSorted));
        } catch (ArrayProcessingException exception) {
            LOGGER.error("Failed to process line: '{}'", line, exception);
        }
    }
}