package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanOperations.getDeclaredMethod;
import static com.google.code.beanmatchers.BeanOperations.invokeMethod;

import java.lang.reflect.Method;
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

      // for arrays fall back to compare element by element to allow for cloned arrays
      if (!valid && propertyType.isArray()) {
        valid = arraysEqual(propertyType, testValue, result);
      }

      return !valid;
    } catch (AccessorMissingException exception) {
      return true;
    }
  }

  private boolean arraysEqual(Class<?> arrayType, Object testValue, Object result) {
    Class<?> argumentType = arrayType.getComponentType().isPrimitive() ? arrayType : Object[].class;
    Method method = getDeclaredMethod(Arrays.class, "equals", argumentType, argumentType);
    return (boolean) invokeMethod(null, method, testValue, result);
  }
}
