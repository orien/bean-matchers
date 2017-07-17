package com.google.code.beanmatchers.data;

import com.google.code.beanmatchers.ValueGenerator;

public class CustomValueGenerator implements ValueGenerator<ObjectNeedingCustomValueGenerator> {
  public ObjectNeedingCustomValueGenerator generate() {
    return new ObjectNeedingCustomValueGenerator();
  }
}
