package com.google.code.beanmatchers;

public interface TypeBasedValueGenerator {

    /**
     * @return A new instance of random value of the specified type.
     */
    <T> T generate(Class<T> type);
}
