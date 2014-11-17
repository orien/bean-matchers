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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestBeanWithOneProperty that = (TestBeanWithOneProperty) o;

        if (field1 == null || that.field1 == null) return false;
        if (!field1.equals(that.field1)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return field1 != null ? field1.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{field1=" + field1 + "}";
    }
}
