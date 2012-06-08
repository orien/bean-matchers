package com.google.code.beanmatchers;

public final class ValueGenerators {
    private ValueGenerators() {
    }

    public static <T> DistinctValues<T> generateTwoDistinctValues(TypeBasedValueGenerator valueGenerator, Class<T> valueType) {
        T valueOne = valueGenerator.generate(valueType);
        T valueTwo;
        do {
            valueTwo = valueGenerator.generate(valueType);
        } while (valueOne.equals(valueTwo));
        return new DistinctValues<T>(valueOne, valueTwo);
    }
}
