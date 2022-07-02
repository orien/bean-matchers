package com.google.code.beanmatchers;

import static java.util.Collections.singleton;

import java.util.Random;
import java.util.Set;

class SetGenerator implements ValueGenerator<Set> {

  private final Random random;

  public SetGenerator(Random random) {
    this.random = random;
  }

  public Set generate() {
    return singleton(random.nextInt());
  }
}
