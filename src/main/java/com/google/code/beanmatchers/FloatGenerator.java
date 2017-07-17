package com.google.code.beanmatchers;

import java.util.Random;

class FloatGenerator implements ValueGenerator<Float> {

  private final Random random;

  public FloatGenerator(Random random) {
    this.random = random;
  }

  public Float generate() {
    return random.nextFloat();
  }
}
