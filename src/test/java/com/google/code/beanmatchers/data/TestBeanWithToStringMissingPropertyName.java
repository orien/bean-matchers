package com.google.code.beanmatchers.data;

public class TestBeanWithToStringMissingPropertyName {
  private Object propertyNameMissingInToString;

  public Object getPropertyNameMissingInToString() {
    return propertyNameMissingInToString;
  }

  public void setPropertyNameMissingInToString(Object propertyNameMissingInToString) {
    this.propertyNameMissingInToString = propertyNameMissingInToString;
  }

  @Override
  public String toString() {
    return getClass().getName() + "{=" + propertyNameMissingInToString + "}";
  }
}
