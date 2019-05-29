package com.google.code.beanmatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.hamcrest.Description;
import org.hamcrest.DiagnosingMatcher;

abstract class AbstractBeanAccessorMatcher<T> extends DiagnosingMatcher<T> {

  final TypeBasedValueGenerator valueGenerator;

  AbstractBeanAccessorMatcher(TypeBasedValueGenerator valueGenerator) {
    this.valueGenerator = valueGenerator;
  }

  protected boolean beanHasValidGetterAndSetterForProperties(
      JavaBean bean, List<String> properties, Description mismatchDescription) {
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
      boolean valid = Objects.equals(testValue, result);

      // for arrays fall back to compare element by element
      // to allow cloned arrays in bean properties
      if (!valid) {
        if (propertyType.isArray()) {
          if (propertyType.getComponentType().equals(Byte.TYPE)) {
            valid = Arrays.equals((byte[]) testValue, (byte[]) result);
          } else if (propertyType.getComponentType().equals(Short.TYPE)) {
            valid = Arrays.equals((short[]) testValue, (short[]) result);
          } else if (propertyType.getComponentType().equals(Integer.TYPE)) {
            valid = Arrays.equals((int[]) testValue, (int[]) result);
          } else if (propertyType.getComponentType().equals(Long.TYPE)) {
            valid = Arrays.equals((long[]) testValue, (long[]) result);
          } else if (propertyType.getComponentType().equals(Character.TYPE)) {
            valid = Arrays.equals((char[]) testValue, (char[]) result);
          } else if (propertyType.getComponentType().equals(Boolean.TYPE)) {
            valid = Arrays.equals((boolean[]) testValue, (boolean[]) result);
          } else if (propertyType.getComponentType().equals(Float.TYPE)) {
            valid = Arrays.equals((float[]) testValue, (float[]) result);
          } else if (propertyType.getComponentType().equals(Double.TYPE)) {
            valid = Arrays.equals((double[]) testValue, (double[]) result);
          } else {
            valid = Arrays.equals((Object[]) testValue, (Object[]) result);
          }
        }
      }
      return !valid;
    } catch (AccessorMissingException exception) {
      return true;
    }
  }
}
