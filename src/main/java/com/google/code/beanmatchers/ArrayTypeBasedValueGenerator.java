package com.google.code.beanmatchers;

import java.lang.reflect.Array;

class ArrayTypeBasedValueGenerator implements TypeBasedValueGenerator {
  private static final int ARRAY_GENERATION_SIZE = 3;

  private TypeBasedValueGenerator typeBaseValueGenerator;

  public <T> T generate(Class<T> type) {
    T array = (T) Array.newInstance(type.getComponentType(), ARRAY_GENERATION_SIZE);
    for (int i = 0; i < ARRAY_GENERATION_SIZE; i++) {
      Array.set(array, i, typeBaseValueGenerator.generate(type.getComponentType()));
    }
    return array;
  }

  public void setTypeBaseValueGenerator(TypeBasedValueGenerator typeBaseValueGenerator) {
    this.typeBaseValueGenerator = typeBaseValueGenerator;
  }
}
