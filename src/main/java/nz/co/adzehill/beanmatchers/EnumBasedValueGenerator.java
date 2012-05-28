package nz.co.adzehill.beanmatchers;

import java.util.Random;

class EnumBasedValueGenerator implements TypeBasedValueGenerator {

    private final Random random;

    public EnumBasedValueGenerator(Random random) {
        this.random = random;
    }

    public <T> T generate(Class<T> type) {
        T[] enumValues = type.getEnumConstants();
        int enumIndex = random.nextInt(enumValues.length);
        return enumValues[enumIndex];
    }
}
