package com.google.code.beanmatchers;

import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;

abstract class AbstractBeanAccessorMatcher<T> extends DiagnosingMatcher<T> {
  final TypeBasedValueGenerator valueGenerator;

  AbstractBeanAccessorMatcher(TypeBasedValueGenerator valueGenerator) {
    this.valueGenerator = valueGenerator;
  }

  protected boolean beanHasValidGetterAndSetterForProperties(JavaBean bean, List<String> properties, Description mismatchDescription) {
    for (String property : properties) {
      if (beanDoesNotHaveValidGetterAndSetterForProperty(bean, property)) {
        mismatchDescription
            .appendText("bean of type ")
            .appendValue(bean.beanType().getName())
            .appendText(" had an invalid getter/setter for the property ")
            .appendValue(property);
        return false;
      }
    }
    return true;
  }

  protected boolean beanDoesNotHaveValidGetterAndSetterForProperty(JavaBean bean, String property) {
    try {
      Class<?> propertyType = bean.propertyType(property);
      Object testValue = valueGenerator.generate(propertyType);
      bean.setProperty(property, testValue);
      Object result = bean.getProperty(property);
      return !testValue.equals(result);
    } catch (AccessorMissingException exception) {
      return true;
    }
  }
}
