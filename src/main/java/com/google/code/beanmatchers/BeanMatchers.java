package com.google.code.beanmatchers;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Random;

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
        ArrayTypeBasedValueGenerator arrayValueGenerator = new ArrayTypeBasedValueGenerator();
        TYPE_BASED_VALUE_GENERATOR = new DefaultTypeBasedValueGenerator(VALUE_GENERATOR_REPOSTITORY,
                new MockingTypeBasedValueGenerator(), new EnumBasedValueGenerator(random), arrayValueGenerator);
        arrayValueGenerator.setTypeBaseValueGenerator(TYPE_BASED_VALUE_GENERATOR);
    }

    private BeanMatchers() {}

    @Factory
    public static Matcher<Class> hasValidGettersAndSettersFor(String... fields) {
        return new InstantiatingMatcherDecorator(isABeanWithValidGettersAndSettersFor(fields));
    }

    @Factory
    public static <T> Matcher<T> isABeanWithValidGettersAndSettersFor(String... fields) {
        return new HasValidGettersAndSettersMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static Matcher<Class> hasValidGettersAndSettersExcluding(String... fields) {
        return new InstantiatingMatcherDecorator(isABeanWithValidGettersAndSettersExcluding(fields));
    }

    @Factory
    public static <T> Matcher<T> isABeanWithValidGettersAndSettersExcluding(String... fields) {
        return new HasValidGettersAndSettersExcludingMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static Matcher<Class> hasValidGettersAndSetters() {
        return hasValidGettersAndSettersExcluding();
    }

    @Factory
    public static <T> Matcher<T> isABeanWithValidGettersAndSetters() {
        return isABeanWithValidGettersAndSettersExcluding();
    }

    @Factory
    public static Matcher<Class> hasValidBeanConstructor() {
        return new HasValidBeanConstructorMatcher();
    }

    @Factory
    public static Matcher<Class> hasValidBeanHashCode() {
        return new HasValidBeanHashCodeExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
    }

    @Factory
    public static Matcher<Class> hasValidBeanHashCodeExcluding(String... fields) {
        return new HasValidBeanHashCodeExcludingMatcher(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static Matcher<Class> hasValidBeanEquals() {
        return new HasValidBeanEqualsExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
    }

    @Factory
    public static Matcher<Class> hasValidBeanEqualsExcluding(String... fields) {
        return new HasValidBeanEqualsExcludingMatcher(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static Matcher<Class> hasValidBeanToString() {
        return new HasToStringDescribingPropertiesExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
    }

    @Factory
    public static Matcher<Class> hasValidBeanToStringExcluding(String... fields) {
        return new HasToStringDescribingPropertiesExcludingMatcher(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    public static <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type) {
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(generator, type);
    }
}
