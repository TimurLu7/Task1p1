package com.arrayprocessor.entity;

import java.util.Arrays;

public class IntArray extends AbstractArray {

    private final int[] elements;

    public IntArray(int[] elements) {

        this.elements = Arrays.copyOf(elements, elements.length);
    }

    @Override
    public int[] getElements() {
        return Arrays.copyOf(elements, elements.length);
    }

    @Override
    public int length() {
        return elements.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntArray that = (IntArray) obj;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        return "IntArray{elements=" + Arrays.toString(elements) + '}';
    }
}
