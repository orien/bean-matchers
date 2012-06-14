package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleSamePropertyValues {

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
        TestBeanWithEqualsThatDoesNotHandleSamePropertyValues that = (TestBeanWithEqualsThatDoesNotHandleSamePropertyValues) o;
        if (property != null ? !property.equals(that.property) : that.property != null) return false;
        return false;
    }
}
