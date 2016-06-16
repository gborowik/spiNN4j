package com.spiNN4j.io.parser;

import com.spiNN4j.model.data.DataMatrix;
import com.spiNN4j.model.data.DataVector;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

        return new DataMatrix<>(matrix, matrix.get(0).width());
    }

    private void parseLine(Scanner scanner, List<DataVector<Double>> matrix) {
        matrix.add(new DataVector<>(Arrays
                .stream(scanner.nextLine().split(","))
                .map(el -> Double.valueOf(el.trim()))
                .collect(Collectors.toList()))
        );
    }

}
