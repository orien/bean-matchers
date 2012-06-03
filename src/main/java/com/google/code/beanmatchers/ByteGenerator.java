package com.google.code.beanmatchers;

import java.util.Random;

class ByteGenerator implements ValueGenerator<Byte> {

    private final Random random;

    public ByteGenerator(Random random) {
        this.random = random;
    }

    public Byte generate() {
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        return bytes[0];
    }
}
