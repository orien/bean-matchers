package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleNullValue {

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        return o == null;
    }
}
