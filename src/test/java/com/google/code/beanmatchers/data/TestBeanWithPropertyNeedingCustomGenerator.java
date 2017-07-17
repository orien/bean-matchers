package com.google.code.beanmatchers.data;

public class TestBeanWithPropertyNeedingCustomGenerator {

  private ObjectNeedingCustomValueGenerator objectNeedingCustomValueGenerator;

  public ObjectNeedingCustomValueGenerator getObjectNeedingCustomValueGenerator() {
    return objectNeedingCustomValueGenerator;
  }

  public void setObjectNeedingCustomValueGenerator(ObjectNeedingCustomValueGenerator objectNeedingCustomValueGenerator) {
    this.objectNeedingCustomValueGenerator = objectNeedingCustomValueGenerator;
  }
}
