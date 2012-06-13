package com.google.code.beanmatchers;

import java.nio.ByteBuffer;
import java.util.Random;

class CharacterGenerator implements ValueGenerator<Character> {

    private final Random random;

    public CharacterGenerator(Random random) {
        this.random = random;
    }

    public Character generate() {
        byte[] bytes = new byte[2];
        random.nextBytes(bytes);
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        return byteBuffer.getChar();
    }
}
