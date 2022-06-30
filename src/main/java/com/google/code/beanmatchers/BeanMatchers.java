package com.google.code.beanmatchers;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.hamcrest.Matcher;

public final class BeanMatchers {

  private static final ValueGeneratorRepository VALUE_GENERATOR_REPOSITORY;
  private static final TypeBasedValueGenerator TYPE_BASED_VALUE_GENERATOR;

  static {
    final Random random = new Random();
    final ValueGeneratorRepository repo = new InMemoryValueGeneratorRepository();
    repo.registerValueGenerator(new StringGenerator(), String.class);
    repo.registerValueGenerator(new UuidGenerator(), UUID.class);
    repo.registerValueGenerator(new IntegerGenerator(random), Integer.class, Integer.TYPE);
    repo.registerValueGenerator(new DoubleGenerator(random), Double.class, Double.TYPE);
    repo.registerValueGenerator(new BooleanGenerator(random), Boolean.class, Boolean.TYPE);
    repo.registerValueGenerator(new LongGenerator(random), Long.class, Long.TYPE);
    repo.registerValueGenerator(new FloatGenerator(random), Float.class, Float.TYPE);
    repo.registerValueGenerator(new ByteGenerator(random), Byte.class, Byte.TYPE);
    repo.registerValueGenerator(new CharacterGenerator(random), Character.class, Character.TYPE);
    repo.registerValueGenerator(new ShortGenerator(random), Short.class, Short.TYPE);
    repo.registerValueGenerator(new ListGenerator(random), List.class);
    repo.registerValueGenerator(new SetGenerator(random), Set.class);
    VALUE_GENERATOR_REPOSITORY = repo;
    final ArrayTypeBasedValueGenerator arrayValueGenerator = new ArrayTypeBasedValueGenerator();
    TYPE_BASED_VALUE_GENERATOR = new DefaultTypeBasedValueGenerator(
        VALUE_GENERATOR_REPOSITORY,
        new MockingTypeBasedValueGenerator(),
        new EnumBasedValueGenerator(random),
        arrayValueGenerator
    );
    arrayValueGenerator.setTypeBaseValueGenerator(TYPE_BASED_VALUE_GENERATOR);
  }

  private BeanMatchers() {
  }

  public static Matcher<Class> hasValidGettersAndSettersFor(String... properties) {
    return new InstantiatingMatcherDecorator(isABeanWithValidGettersAndSettersFor(properties));
  }

  public static <T> Matcher<T> isABeanWithValidGettersAndSettersFor(String... properties) {
    return new HasValidGettersAndSettersMatcher<T>(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidGettersAndSettersExcluding(String... properties) {
    return new InstantiatingMatcherDecorator(
        isABeanWithValidGettersAndSettersExcluding(properties));
  }

  public static <T> Matcher<T> isABeanWithValidGettersAndSettersExcluding(String... properties) {
    return new HasValidGettersAndSettersExcludingMatcher<T>(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidGettersAndSetters() {
    return hasValidGettersAndSettersExcluding();
  }

  public static <T> Matcher<T> isABeanWithValidGettersAndSetters() {
    return isABeanWithValidGettersAndSettersExcluding();
  }

  public static Matcher<Class> hasValidBeanConstructor() {
    return new HasValidBeanConstructorMatcher();
  }

  public static Matcher<Class> hasValidBeanHashCode() {
    return new HasValidBeanHashCodeExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
  }

  public static Matcher<Class> hasValidBeanHashCodeFor(String... properties) {
    return new HasValidBeanHashCodeForMatcher(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidBeanHashCodeExcluding(String... properties) {
    return new HasValidBeanHashCodeExcludingMatcher(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidBeanEquals() {
    return new HasValidBeanEqualsExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
  }

  public static Matcher<Class> hasValidBeanEqualsFor(String... properties) {
    return new HasValidBeanEqualsForMatcher(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidBeanEqualsExcluding(String... properties) {
    return new HasValidBeanEqualsExcludingMatcher(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidBeanToString() {
    return new HasToStringDescribingPropertiesExcludingMatcher(TYPE_BASED_VALUE_GENERATOR);
  }

  public static Matcher<Class> hasValidBeanToStringFor(String... properties) {
    return new HasToStringDescribingPropertiesMatcher(TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static Matcher<Class> hasValidBeanToStringExcluding(String... properties) {
    return new HasToStringDescribingPropertiesExcludingMatcher(
        TYPE_BASED_VALUE_GENERATOR, properties);
  }

  public static <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type) {
    VALUE_GENERATOR_REPOSITORY.registerValueGenerator(generator, type);
  }
}
