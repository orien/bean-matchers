package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;

import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

abstract class AbstractBeanEqualsMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
  final TypeBasedValueGenerator valueGenerator;

  AbstractBeanEqualsMatcher(TypeBasedValueGenerator valueGenerator) {
    this.valueGenerator = valueGenerator;
  }

  protected boolean isValidBeanEquals(Class<T> beanType, List<String> properties, Description mismatchDescription) {
    if (equalsDoesNotHandleSameInstance(beanType)) {
      describeMismatch(beanType, mismatchDescription, " did not correctly identify same instance during equals operation");
      return false;
    }
    if (equalsDoesNotHandleNullValue(beanType)) {
      describeMismatch(beanType, mismatchDescription, " did not correctly identify null value during equals operation");
      return false;
    }
    if (equalsDoesNotHandleDifferingType(beanType)) {
      describeMismatch(beanType, mismatchDescription, " did not correctly identify differing type during equals operation");
      return false;
    }
    for (String property : properties) {
      if (propertyNotComparedDuringEquals(beanType, property)) {
        describePropertyMismatch(beanType, property, mismatchDescription, " not compared during equals operation");
        return false;
      }
      if (nullPropertyNotHandled(beanType, property)) {
        describePropertyMismatch(beanType, property, mismatchDescription, " not handling null during equals operation");
        return false;
      }
    }
    return true;
  }

  private void describeMismatch(Class<T> beanType, Description description, String reason) {
    describeBean(beanType, description).appendText(reason);
  }

  private void describePropertyMismatch(Class<T> beanType, String property, Description description, String reason) {
    describeBean(beanType, description).appendText(" had property ").appendValue(property).appendText(reason);
  }

  private Description describeBean(Class<T> beanType, Description description) {
    return description.appendText("bean of type ").appendValue(beanType.getName());
  }

  private boolean equalsDoesNotHandleSameInstance(Class<T> beanType) {
    JavaBean beanOne = new JavaBean(beanType);
    return !beanOne.equals(beanOne);
  }

  private boolean equalsDoesNotHandleNullValue(Class<T> beanType) {
    JavaBean beanOne = new JavaBean(beanType);
    try {
      return beanOne.equals(null);
    } catch (Exception e) {
      return true;
    }
  }

  private boolean equalsDoesNotHandleDifferingType(Class<T> beanType) {
    JavaBean beanOne = new JavaBean(beanType);
    return beanOne.equals(new TestType());
  }

  private boolean propertyNotComparedDuringEquals(Class<T> beanType, String property) {
    JavaBean beanOne = new JavaBean(beanType);
    Class<?> propertyType = beanOne.propertyType(property);
    DistinctValues values = generateTwoDistinctValues(valueGenerator, propertyType);
    beanOne.setProperty(property, values.getValueOne());
    JavaBean beanWithDifferingPropertyValue = new JavaBean(beanType);
    beanWithDifferingPropertyValue.setProperty(property, values.getValueTwo());
    JavaBean beanWithSamePropertyValue = new JavaBean(beanType);
    beanWithSamePropertyValue.setProperty(property, values.getValueOne());
    return beanOne.equals(beanWithDifferingPropertyValue) || !beanOne.equals(beanWithSamePropertyValue);
  }

  private boolean nullPropertyNotHandled(Class<T> beanType, String property) {
    JavaBean beanOne = new JavaBean(beanType);
    Class<?> propertyType = beanOne.propertyType(property);
    if (propertyType.isPrimitive()) {
      return false;
    }
    Object value = valueGenerator.generate(propertyType);
    beanOne.setProperty(property, value);
    JavaBean beanTwo = new JavaBean(beanType);
    beanTwo.setProperty(property, null);
    try {
      return beanOne.equals(beanTwo) || beanTwo.equals(beanOne);
    } catch (RuntimeException e) {
      return true;
    }
  }

  private static class TestType {
  }
}
