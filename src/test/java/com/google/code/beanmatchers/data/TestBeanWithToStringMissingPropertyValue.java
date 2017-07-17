package com.google.code.beanmatchers.data;

public class TestBeanWithToStringMissingPropertyValue {
  private Object propertyValueMissingInToString;

  public Object getPropertyValueMissingInToString() {
    return propertyValueMissingInToString;
  }

  public void setPropertyValueMissingInToString(Object propertyValueMissingInToString) {
    this.propertyValueMissingInToString = propertyValueMissingInToString;
  }

  @Override
  public String toString() {
    return getClass().getName() + "{propertyValueMissingInToString=}";
  }
}
