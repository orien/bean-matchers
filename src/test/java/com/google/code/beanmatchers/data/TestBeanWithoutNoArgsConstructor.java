package com.google.code.beanmatchers.data;

public class TestBeanWithoutNoArgsConstructor {

  private boolean booleanProperty;

  public TestBeanWithoutNoArgsConstructor(boolean booleanProperty) {
  }

  public boolean isBooleanProperty() {
    return booleanProperty;
  }

  public void setBooleanProperty(boolean booleanProperty) {
    this.booleanProperty = booleanProperty;
  }
}
