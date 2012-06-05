package com.google.code.beanmatchers.data;

public class TestBeanWithToStringMissingArrayPropertyValue {
    private String[] arrayPropertyValueMissingInToString;

    public String[] getArrayPropertyValueMissingInToString() {
        return arrayPropertyValueMissingInToString;
    }

    public void setArrayPropertyValueMissingInToString(String[] arrayPropertyValueMissingInToString) {
        this.arrayPropertyValueMissingInToString = arrayPropertyValueMissingInToString;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{arrayPropertyValueMissingInToString=}";
    }
}
