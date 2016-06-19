package com.spiNN4j.model.data;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * Created by Grzegorz Borowik on 2016-06-16 8:02 AM.
 * e-mail: borowik.grzegorz@gmail.com
 */
public class DataVector<T> {
    protected List<T> row;

    /**
     * Non-parameter constructor.
     * Initializes with empty {@code ArrayList<>()}.
     */
    public DataVector() {
        this.row = new ArrayList<>();
    }


    /**
     * One-parameter constructor.
     * Initializes with a parameter of type {@code List<T>}.
     */
    public DataVector(List<T> row) {
        this.row = row;
    }

    /**
     * Creates a row of specified size and initializes with specified value.
     * @param size size of row
     * @param value value of element the row to be filled with
     */
    public DataVector(int size, T value){
        this.row = new ArrayList<>(Collections.nCopies(size, value));
    }

    /**
     * @return size of the row.
     * The same function as {@code width()}.
     */
    public int size() {
        return row.size();
    }


    /**
     * @return size of the row.
     * The same function as {@code size()}.
     */
    public int width() {
        return row.size();
    }


    /**
     * Returns the i-th element in the row.
     *
     * @param column index of the element of interest
     * @return i-th element in the row (of type {@code T})
     */
    public T get(int column) {
        return row.get(column);
    }


    /**
     * @return row (of type {@code List<T>}).
     */
    public List<T> getData() {
        return row;
    }


    /**
     * Compares the i-th element in the row
     * with the i-th element in the other row.
     * The same function as {@code isEqualAtIndex(...)}.
     *
     * @param other  external row (of type {@code DataVector<T>})
     * @param column index of the element of interest
     * @return true when i-th element in the row
     * equals i-th element in the other row.
     */
    public boolean hasSameValueAt(DataVector<T> other, Integer column) {
        return get(column).equals(other.get(column));
    }


    /**
     * Compares the i-th element in the row
     * with the i-th element in the other row.
     * The same function as {@code hasSameValueAt(...)}.
     *
     * @param other external row (of type {@code DataVector<T>})
     * @param index index of the element of interest
     * @return true when i-th element in the row
     * equals i-th element in the other row.
     */
    public boolean isEqualAtIndex(DataVector<T> other, int index) {
        return row.get(index).equals(other.row.get(index));
    }


    /**
     * @param on separator (type {@code String})
     * @return {@code String} containing elements of
     * row separated by external string (separator).
     * Usually used when writing.
     */
    public String join(String on) {
        return Joiner.on(on).join(row);
    }


    /**
     * It is commonly used in conversion
     * from a row of strings to a row of numeric values, e.g. when parsing.
     *
     * @param converter function used in conversion, e.g. {@code Double::valueOf}
     * @return converted row (in type {@code T2}) from type {@code T}.
     */
    public <T2> DataVector<T2> convert(Function<T, T2> converter) {
        return new DataVector<>(row.stream()
                .map(value -> converter.apply(value))
                .collect(toList())
        );
    }


    /**
     * @param o external row (of type {@code DataVector<T>})
     * @return true when elements in rows are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataVector<?> that = (DataVector<?>) o;

        return row.equals(that.row);
    }

    @Override
    public int hashCode() {
        return row.hashCode();
    }
}
