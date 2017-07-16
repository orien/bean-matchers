package com.google.code.beanmatchers.data;

public class TestBeanWithEqualsThatDoesNotHandleSameInstance {

  @Override
  public boolean equals(Object o) {
    return (o != this);
  }
}
