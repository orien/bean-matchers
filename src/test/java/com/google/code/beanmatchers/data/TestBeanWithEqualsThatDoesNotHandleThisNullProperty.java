package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleThisNullProperty {

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
        TestBeanWithEqualsThatDoesNotHandleThisNullProperty that = (TestBeanWithEqualsThatDoesNotHandleThisNullProperty) o;
        return (this.property.equals(that.property));
    }
}
