package com.spiNN4j.model.data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by Grzegorz Borowik on 2016-06-16 1:50 PM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class DataMatrix<T> {
    protected List<DataVector<T>> data;
    protected int width;

    /**
     * One-parameter constructor.
     * Initializes with a parameter width.
     */
    public DataMatrix(int width) {
        this.data = new ArrayList<>();
        this.width = width;
    }


    /**
     * Two-parameter constructor.
     * Initializes with parameters: a list of rows and a width.
     */
    public DataMatrix(List<DataVector<T>> data, int width) {
        this.data = data;
        this.width = width;
    }


    /**
     * @return length of data
     * (number of rows in table/matrix).
     */
    public int size() {
        return data.size();
    }


    /**
     * @return width of the data (table/matrix);
     * row's width.
     */
    public int getWidth() {
        return width;
    }


    /**
     * @return data (table/matrix) (of type {@code List<DataVector<T>>).
     */
    public List<DataVector<T>> getData() {
        return data;
    }


    /**
     * @param row index of a row of interest
     * @return a row (of type {@code List<T>}) at position {@code row}.
     */
    public DataVector<T> get(int row) {
        return data.get(row);
    }


    /**
     * Adds row to the data (table/matrix).
     *
     * @param dataVector row to be added (of type {@code DataVector<T>}).
     */
    public void add(DataVector<T> dataVector) {
        data.add(dataVector);
    }


    /**
     * It is commonly used in conversion
     * from a table/matrix of strings to
     * a table/matrix of numeric values, e.g. when parsing.
     *
     * @param converter function used in conversion, e.g. {@code Double::valueOf}
     * @return converted table/matrix (in type {@code T2}) from type {@code T}.
     */
    public <T2> DataMatrix<T2> convert(Function<T, T2> converter) {
        return new DataMatrix<>(data.stream()
                .map(vector -> vector.convert(converter))
                .collect(toList())
                , width);
    }
}
