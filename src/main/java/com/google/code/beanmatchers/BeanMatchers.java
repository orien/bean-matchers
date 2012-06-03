package com.google.code.beanmatchers;

import java.util.Random;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public final class BeanMatchers {

    private static final ValueGeneratorRepository VALUE_GENERATOR_REPOSTITORY;
    private static final TypeBasedValueGenerator TYPE_BASED_VALUE_GENERATOR;

    static {
        Random random = new Random();
        VALUE_GENERATOR_REPOSTITORY = new InMemoryValueGeneratorRepository();
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new StringGenerator(), String.class);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new IntegerGenerator(random), Integer.class, Integer.TYPE);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new DoubleGenerator(random), Double.class, Double.TYPE);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new BooleanGenerator(random), Boolean.class, Boolean.TYPE);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new LongGenerator(random), Long.class, Long.TYPE);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new FloatGenerator(random), Float.class, Float.TYPE);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new ByteGenerator(random), Byte.class, Byte.TYPE);
        TYPE_BASED_VALUE_GENERATOR = new DefaultTypeBasedValueGenerator(VALUE_GENERATOR_REPOSTITORY,
                new MockingTypeBasedValueGenerator(), new EnumBasedValueGenerator(random), new ArrayTypeBasedValueGenerator());
    }

    private BeanMatchers() {
    }

    @Factory
    public static <T> Matcher<T> hasValidSettersAndGettersFor(String... fields) {
        return new HasValidSettersAndGettersMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static <T> Matcher<T> hasValidSettersAndGettersExcluding(String... fields) {
        return new HasValidSettersAndGettersExcludingMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static <T> Matcher<T> hasValidSettersAndGetters() {
        return hasValidSettersAndGettersExcluding();
    }

    public static <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type) {
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(generator, type);
    }
}
