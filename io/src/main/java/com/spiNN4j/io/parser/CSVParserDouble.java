package com.spiNN4j.io.parser;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Grzegorz Borowik on 2016-06-16 12:07 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class CSVParserDouble {

    private final InputStream inputStream;

    public CSVParserDouble(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public DataMatrix<Double> parse() {

        Scanner scanner = new Scanner(inputStream);

        List<DataVector<Double>> matrix = new ArrayList<>();
        while (scanner.hasNextLine()) {
            parseLine(scanner, matrix);
        }

        return new DataMatrix<Double>(matrix, matrix.first().width());
    }

    private void parseLine(Scanner scanner, List<DataVector<Double>> matrix) {
        matrix.add(new DataVector<Double>(Arrays
                .stream(scanner.nextLine().split(","))
                .map(el -> Double.valueOf(el.trim()))
                .collect(Collectors.toList()))
        );
    }

}
