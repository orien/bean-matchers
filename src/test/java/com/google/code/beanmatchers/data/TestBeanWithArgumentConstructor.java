package com.google.code.beanmatchers.data;

/**
 *
 */
public class TestBeanWithArgumentConstructor {

    /**
     * Single field
     */
    private Object field1;

    /**
     * Constructor for the only field
     * @param field1 field
     */
    public TestBeanWithArgumentConstructor(Object field1) {
        this.field1 = field1;
    }

    public Object getField1() {
        return field1;
    }

    public void setField1(Object field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return "TestBeanWithArgumentConstructor{" +
               "field1=" + field1 +
               '}';
    }
}
