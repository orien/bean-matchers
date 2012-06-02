package com.google.code.beanmatchers;

import java.util.Random;

class BooleanGenerator implements ValueGenerator<Boolean> {

    private final Random random;

    public BooleanGenerator(Random random) {
        this.random = random;
    }

    public Boolean generate() {
        return random.nextBoolean();
    }
}
