package com.google.code.beanmatchers.data;

public class TestBeanWithPropertyThatDoesNotInfluenceEquals {

  private Object propertyNotComparedInEquals;

  private Object propertyComparedInEquals;

  public Object getPropertyNotComparedInEquals() {
    return propertyNotComparedInEquals;
  }

  public void setPropertyNotComparedInEquals(Object propertyNotComparedInEquals) {
    this.propertyNotComparedInEquals = propertyNotComparedInEquals;
  }

  public Object getPropertyComparedInEquals() {
    return propertyComparedInEquals;
  }

  public void setPropertyComparedInEquals(Object propertyComparedInEquals) {
    this.propertyComparedInEquals = propertyComparedInEquals;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TestBeanWithPropertyThatDoesNotInfluenceEquals that = (TestBeanWithPropertyThatDoesNotInfluenceEquals) o;

    if (propertyComparedInEquals != that.propertyComparedInEquals) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return propertyComparedInEquals.hashCode();
  }
}
