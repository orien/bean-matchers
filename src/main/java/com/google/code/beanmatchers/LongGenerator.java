package com.google.code.beanmatchers;

import java.util.Random;

class LongGenerator implements ValueGenerator<Long> {

    private final Random random;

    public LongGenerator(Random random) {
        this.random = random;
    }

    public Long generate() {
        return random.nextLong();
    }
}
