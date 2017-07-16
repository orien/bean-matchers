package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidGettersAndSettersMatcher<T> extends AbstractBeanAccessorMatcher<T> {
  private final List<String> properties;

  HasValidGettersAndSettersMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
    super(valueGenerator);
    this.properties = asList(properties);
  }

  @Override
  protected boolean matches(Object item, Description mismatchDescription) {
    return beanHasValidGetterAndSetterForProperties(new JavaBean(item), properties, mismatchDescription);
  }

  public void describeTo(Description description) {
    description.appendText("bean with valid setter and getter methods for properties ");
    description.appendValue(properties);
  }
}
