package com.google.code.beanmatchers;

final class ValueGenerators {
    private static final int MAX_ATTEMPTS = 128;
    private ValueGenerators() {
    }

    public static <T> DistinctValues<T> generateTwoDistinctValues(TypeBasedValueGenerator valueGenerator, Class<T> valueType) {
        int attempts = 0;
        T valueOne = valueGenerator.generate(valueType);
        T valueTwo;
        do {
            if (attempts == MAX_ATTEMPTS) {
                throw new BeanMatchersException("Could not generate two distinct values after " + MAX_ATTEMPTS + " attempts of type " + valueType.getName());
            }
            valueTwo = valueGenerator.generate(valueType);
            attempts++;
        } while (valueOne.equals(valueTwo));
        return new DistinctValues<T>(valueOne, valueTwo);
    }
}
