package com.google.code.beanmatchers;

import java.lang.reflect.Array;

class ArrayTypeBasedValueGenerator implements TypeBasedValueGenerator {
    public <T> T generate(Class<T> type) {
        return (T) Array.newInstance(type.getComponentType(), 0);
    }
}
