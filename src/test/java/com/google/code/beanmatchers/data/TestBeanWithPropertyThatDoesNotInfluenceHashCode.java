package com.google.code.beanmatchers.data;

public class TestBeanWithPropertyThatDoesNotInfluenceHashCode {

  private Object property;

  public Object getProperty() {
    return property;
  }

  public void setProperty(Object property) {
    this.property = property;
  }

  @Override
  public int hashCode() {
    return 42;
  }
}
