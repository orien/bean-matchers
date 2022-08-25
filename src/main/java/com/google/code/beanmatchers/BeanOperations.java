package com.google.code.beanmatchers;

import static java.beans.Introspector.getBeanInfo;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matcher;

final class BeanOperations {
  private BeanOperations() {
  }

  public static <T> T instantiateBean(Class<T> beanClass) {
    try {
      Constructor<T> constructor = noArgsConstructor(beanClass);
      constructor.setAccessible(true);
      return constructor.newInstance();
    } catch (InstantiationException exception) {
      throw new BeanMatchersException(
          "Could not instantiate bean with no-args constructor", exception);
    } catch (IllegalAccessException exception) {
      throw new BeanMatchersException(
          "Could not instantiate bean with no-args constructor", exception);
    } catch (InvocationTargetException exception) {
      throw new BeanMatchersException(
          "Could not instantiate bean with no-args constructor", exception);
    }
  }

  public static <T> Constructor<T> noArgsConstructor(Class<T> beanClass) {
    try {
      return beanClass.getDeclaredConstructor();
    } catch (NoSuchMethodException exception) {
      throw new BeanMatchersException("Bean does not have no-args constructor", exception);
    }
  }

  public static List<String> properties(Class<?> beanType) {
    return properties(propertyDescriptors(beanType, anything()));
  }

  public static List<String> properties(List<PropertyDescriptor> descriptors) {
    List<String> properties = new ArrayList<String>(descriptors.size());
    for (PropertyDescriptor descriptor : descriptors) {
      properties.add(descriptor.getName());
    }
    return properties;
  }

  public static <T> List<PropertyDescriptor> propertyDescriptors(Class<T> bean, Matcher matcher) {
    Matcher m = allOf(matcher, hasProperty("name", not("class")));
    List<PropertyDescriptor> propertyDescriptors = new ArrayList<PropertyDescriptor>();
    for (PropertyDescriptor i : beanInfo(bean).getPropertyDescriptors()) {
      if (m.matches(i)) {
        propertyDescriptors.add(i);
      }
    }
    return propertyDescriptors;
  }

  private static BeanInfo beanInfo(Class targetClass) {
    try {
      return getBeanInfo(targetClass);
    } catch (Exception exception) {
      throw new BeanMatchersException(exception);
    }
  }

  public static Object invokeGetter(Object bean, PropertyDescriptor property) {
    Method method = property.getReadMethod();
    if (method == null) {
      throw new AccessorMissingException("missing getter for the property " + property.getName());
    }
    return invokeMethod(bean, method);
  }

  public static void invokeSetter(Object bean, PropertyDescriptor property, Object value) {
    Method method = property.getWriteMethod();
    if (method == null) {
      throw new AccessorMissingException("missing setter for the property " + property.getName());
    }
    invokeMethod(bean, method, value);
  }

  public static Method getDeclaredMethod(Class type, String methodName, Class... argTypes) {
    try {
      return type.getDeclaredMethod(methodName, argTypes);
    } catch (Exception exception) {
      throw new BeanMatchersException(exception);
    }
  }

  public static Object invokeMethod(Object bean, Method method, Object... args) {
    try {
      return method.invoke(bean, args);
    } catch (Exception exception) {
      throw new BeanMatchersException(exception);
    }
  }
}
