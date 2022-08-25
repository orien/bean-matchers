package com.google.code.beanmatchers;

import static java.util.Arrays.asList;

import java.util.List;

import org.hamcrest.Description;

public class HasValidGettersAndSettersExcludingMatcher<T> extends AbstractBeanAccessorMatcher<T> {
  private List<String> excludedProperties;
  private final boolean excludeAsymmetricAccessors;

  HasValidGettersAndSettersExcludingMatcher(
      TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
    this(valueGenerator, false, excludedProperties);
  }

  HasValidGettersAndSettersExcludingMatcher(
      TypeBasedValueGenerator valueGenerator, boolean excludeAsymmetricAccessors, String... excludedProperties) {
    super(valueGenerator);
    this.excludeAsymmetricAccessors = excludeAsymmetricAccessors;
    this.excludedProperties = asList(excludedProperties);
  }

  @Override
  protected boolean matches(Object item, Description mismatchDescription) {
    JavaBean bean = new JavaBean(item, excludeAsymmetricAccessors);
    List<String> properties = bean.properties();
    properties.removeAll(excludedProperties);
    return super.beanHasValidGetterAndSetterForProperties(bean, properties, mismatchDescription);
  }

  @Override
  public void describeTo(Description description) {
    if (excludedProperties.isEmpty()) {
      description.appendText("bean with valid setter and getter methods for all properties");
    } else {
      description.appendText(
          "bean with valid setter and getter methods for all properties excluding ");
      description.appendValue(excludedProperties);
    }
  }
}
