package com.google.code.beanmatchers.data;

public class TestBeanWithOneProperty {

    private Object field1;

    public Object getField1() {
        return field1;
    }

    public void setField1(Object field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{field1=" + field1 + "}";
    }
}
