package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleDifferingType {

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        return this.getClass() != o.getClass();
    }
}
