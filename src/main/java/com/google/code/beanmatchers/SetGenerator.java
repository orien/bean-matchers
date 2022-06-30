package com.google.code.beanmatchers;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class SetGenerator implements ValueGenerator<Set> {

  private final Random random;

  public SetGenerator(Random random) {
    this.random = random;
  }

  public Set generate() {
    HashSet<Integer> hash = new HashSet<>();
    for (int count = 1; count <= 3; count++) {
      hash.add(1 + random.nextInt());
    }

    return hash;
  }
}
