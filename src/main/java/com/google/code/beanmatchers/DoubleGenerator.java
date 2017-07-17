package com.google.code.beanmatchers;

import java.util.Random;

class DoubleGenerator implements ValueGenerator<Double> {

  private final Random random;

  public DoubleGenerator(Random random) {
    this.random = random;
  }

  public Double generate() {
    return random.nextDouble();
  }
}
