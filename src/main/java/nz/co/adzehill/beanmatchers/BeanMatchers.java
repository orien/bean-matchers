package nz.co.adzehill.beanmatchers;

import org.hamcrest.Factory;

import java.util.Random;

public final class BeanMatchers {

    private static final ValueGeneratorRepository VALUE_GENERATOR_REPOSTITORY;
    private static final TypeBasedValueGenerator TYPE_BASED_VALUE_GENERATOR;

    static {
        Random random = new Random();
        VALUE_GENERATOR_REPOSTITORY = new InMemoryValueGeneratorRepository();
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new StringGenerator(), String.class);
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(new IntegerGenerator(random), Integer.class, Integer.TYPE);
        TYPE_BASED_VALUE_GENERATOR = new DefaultTypeBasedValueGenerator(
                VALUE_GENERATOR_REPOSTITORY, new MockingTypeBasedValueGenerator(), new EnumBasedValueGenerator());
    }

    private BeanMatchers() {
    }

    @Factory
    public static <T> HasValidSettersAndGettersMatcher<T> hasValidSettersAndGettersFor(String... fields) {
        return new HasValidSettersAndGettersMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static <T> HasValidSettersAndGettersExcludingMatcher<T> hasValidSettersAndGettersExcluding(String... fields) {
        return new HasValidSettersAndGettersExcludingMatcher<T>(TYPE_BASED_VALUE_GENERATOR, fields);
    }

    @Factory
    public static <T> HasValidSettersAndGettersExcludingMatcher<T> hasValidSettersAndGetters() {
        return hasValidSettersAndGettersExcluding();
    }

    public static <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type) {
        VALUE_GENERATOR_REPOSTITORY.registerValueGenerator(generator, type);
    }

    /**
     * @return The registered {@code ValueGenerator} or {@code null}
     *         if no generator has been registered for the given type.
     */
    public static <T> ValueGenerator<T> retrieveValueGenerator(Class<T> type) {
        return VALUE_GENERATOR_REPOSTITORY.retrieveValueGenerator(type);
    }
}
