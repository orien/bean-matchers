package com.google.code.beanmatchers.data;

public class TestBeanWithBadGetter {

  private Object goodField;
  private Object badField;

  public Object getGoodField() {
    return goodField;
  }

  public void setGoodField(Object goodField) {
    this.goodField = goodField;
  }

  public Object getBadField() {
    // disabled
    return null;
  }

  public void setBadField(Object badField) {
    this.badField = badField;
  }
}
