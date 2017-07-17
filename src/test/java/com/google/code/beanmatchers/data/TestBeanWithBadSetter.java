package com.google.code.beanmatchers.data;

public class TestBeanWithBadSetter {

  private Object goodField;
  private Object badField;

  public Object getGoodField() {
    return goodField;
  }

  public void setGoodField(Object goodField) {
    this.goodField = goodField;
  }

  public Object getBadField() {
    return badField;
  }

  public void setBadField(Object badField) {
    // disabled
  }
}
