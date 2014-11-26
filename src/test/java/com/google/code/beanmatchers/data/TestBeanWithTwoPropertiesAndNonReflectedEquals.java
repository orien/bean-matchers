package com.google.code.beanmatchers.data;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class TestBeanWithTwoPropertiesAndNonReflectedEquals {
  private long field1;
  private long field2;

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    TestBeanWithTwoPropertiesAndNonReflectedEquals rhs = (TestBeanWithTwoPropertiesAndNonReflectedEquals) obj;
    return new EqualsBuilder()
      .append(getField1(), rhs.getField1())
      .append(getField2(), rhs.getField2())
      .isEquals();
  }

  public long getField1() {
    return field1;
  }

  public void setField1(long field1) {
    this.field1 = field1;
  }

  public long getField2() {
    return field2;
  }

  public void setField2(long field2) {
    this.field2 = field2;
  }

}
