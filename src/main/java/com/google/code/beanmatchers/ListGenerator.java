package com.google.code.beanmatchers;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.Random;

class ListGenerator implements ValueGenerator<List> {

  private final Random random;

  public ListGenerator(Random random) {
    this.random = random;
  }

  public List generate() {
    return asList((Integer) random.nextInt());
  }
}
