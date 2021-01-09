package com.google.code.beanmatchers;

import java.lang.reflect.InvocationTargetException;
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

      // for arrays fall back to compare element by element
      // to allow cloned arrays in bean properties
      if (!valid && propertyType.isArray()) {
        valid = arrayEquals(propertyType, testValue, result);
      }

      return !valid;
    } catch (AccessorMissingException exception) {
      return true;
    }
  }

  private boolean arrayEquals(Class<?> arrayType, Object testValue, Object result) {
    try {
      Class klass = Arrays.class;
      Method method = klass.getDeclaredMethod("equals", new Class[] {arrayType, arrayType});
      return (boolean) method.invoke(null, new Object[] {testValue, result});
    } catch (NoSuchMethodException exception) {
      return false;
    } catch (IllegalAccessException exception) {
      throw new BeanMatchersException(exception);
    } catch (InvocationTargetException exception) {
      throw new BeanMatchersException(exception);
    }
  }
}
