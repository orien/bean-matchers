package com.google.code.beanmatchers.data;

import java.util.Collections;
import java.util.List;

public class TestBeanWithListProperty {

  private List<String> field1;

  public List<String> getField1() {
    return field1 == null ? null : Collections.unmodifiableList(field1);
  }

  public void setField1(List<String> field1) {
    this.field1 = field1 == null ? null : Collections.unmodifiableList(field1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TestBeanWithListProperty that = (TestBeanWithListProperty) o;

    if (field1 != null ? !field1.equals(that.field1) : that.field1 != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return field1 != null ? field1.hashCode() : 0;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + "{field1=" + field1 + "}";
  }
}
