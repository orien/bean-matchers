package com.google.code.beanmatchers;

class DistinctValues<T> {
    private final T valueOne;
    private final T valueTwo;

    public DistinctValues(T valueOne, T valueTwo) {
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    public T getValueOne() {
        return valueOne;
    }

    public T getValueTwo() {
        return valueTwo;
    }
}
