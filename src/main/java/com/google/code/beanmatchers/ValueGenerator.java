package com.google.code.beanmatchers;

/**
 * Generates instances of a specific type.
 *
 * @param <T> The type of value produced.
 */
public interface ValueGenerator<T> {

    /**
     * Generate a new instance. The new should have random value.
     * Specifically, two sequential calls to this method should
     * result (with high probability, not guaranteed) in two
     * distinct values - values that are not equal as per their
     * {@code equals()} method.
     *
     * @return A new instance of random value.
     */
    T generate();
}
