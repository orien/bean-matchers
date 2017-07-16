package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidBeanHashCodeExcludingMatcher<T> extends AbstractBeanHashCodeMatcher<T> {
  private final List<String> excludedProperties;

  HasValidBeanHashCodeExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
    super(valueGenerator);
    this.excludedProperties = asList(excludedProperties);
  }

  @Override
  protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
    JavaBean bean = new JavaBean(beanType);
    List<String> properties = bean.properties();
    properties.removeAll(excludedProperties);
    return hashCodeIsInfluencedByProperties(bean, properties, mismatchDescription);
  }

  public void describeTo(Description description) {
    if (excludedProperties.isEmpty()) {
      description.appendText("bean with all properties influencing hashCode");
    } else {
      description.appendText("bean with all properties excluding ");
      description.appendValue(excludedProperties);
      description.appendText(" influencing hashCode");
    }
  }
}
