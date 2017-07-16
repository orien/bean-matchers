package com.google.code.beanmatchers;

import static java.util.Arrays.asList;

import java.util.List;
import org.hamcrest.Description;

public class HasValidBeanHashCodeForMatcher<T> extends AbstractBeanHashCodeMatcher<T> {
  private final List<String> properties;

  HasValidBeanHashCodeForMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
    super(valueGenerator);
    this.properties = asList(properties);
  }

  @Override
  protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
    return super.hashCodeIsInfluencedByProperties(
        new JavaBean(beanType), properties, mismatchDescription);
  }

  public void describeTo(Description description) {
    description.appendText("bean with the properties ");
    description.appendValue(properties);
    description.appendText(" influencing hashCode");
  }
}
