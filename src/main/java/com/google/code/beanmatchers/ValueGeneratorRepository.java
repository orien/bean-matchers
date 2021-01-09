package com.google.code.beanmatchers;

interface ValueGeneratorRepository {

  <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type);

  <T> void registerValueGenerator(ValueGenerator<T> generator, Class<T> type, Class<T> extraType);

  /**
   * @return The registered {@code ValueGenerator} or {@code null}
   *     if no generator has been registered for the given type.
   */
  <T> ValueGenerator<T> retrieveValueGenerator(Class<T> type);
}
