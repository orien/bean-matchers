package com.google.code.beanmatchers.data;

public class TestBeanWithTwoProperties {

    private Object field1;
    private Object field2;

    public Object getField1() {
        return field1;
    }

    public void setField1(Object field1) {
        this.field1 = field1;
    }
    
    public Object getField2() {
        return field2;
    }

    public void setField2(Object field2) {
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestBeanWithTwoProperties that = (TestBeanWithTwoProperties) o;

        if (field1 == null || that.field1 == null) return false;
        if (!field1.equals(that.field1)) return false;
        if (field2 == null || that.field2 == null) return false;
        if (!field2.equals(that.field2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += (field1 != null ? field1.hashCode() : 0);
        hashCode += hashCode*31 + (field2 != null ? field2.hashCode() : 0);
        return hashCode;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{field1=" + field1 + ", field2=" + field2 + "}";
    }
}
