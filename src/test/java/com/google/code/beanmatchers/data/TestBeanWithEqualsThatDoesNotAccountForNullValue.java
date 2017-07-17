package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotAccountForNullValue {

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
    if (getClass() != o.getClass()) return false;
    TestBeanWithEqualsThatDoesNotAccountForNullValue that = (TestBeanWithEqualsThatDoesNotAccountForNullValue) o;
    if (property != null ? !property.equals(that.property) : that.property != null) return false;
    return true;
  }
}
