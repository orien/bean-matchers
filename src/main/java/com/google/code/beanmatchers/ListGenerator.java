package com.google.code.beanmatchers;

import java.util.ArrayList;
import java.util.List;

class ListGenerator implements ValueGenerator<List> {

  public List generate() {
    return new ArrayList();
  }
}
