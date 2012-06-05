package com.google.code.beanmatchers.data;

public class TestBeanWithToStringMissingClassName {
    private Object property;

    public Object getProperty() {
        return property;
    }

    public void setProperty(Object property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "property=" + property;
    }
}
