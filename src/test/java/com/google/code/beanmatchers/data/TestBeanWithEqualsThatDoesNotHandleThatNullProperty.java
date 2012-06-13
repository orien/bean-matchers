package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleThatNullProperty {

    private Object property;

    public Object getProperty() {
        return property;
    }

    public void setProperty(Object property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestBeanWithEqualsThatDoesNotHandleThatNullProperty that = (TestBeanWithEqualsThatDoesNotHandleThatNullProperty) o;
        return (that.property.equals(this.property));
    }
}
