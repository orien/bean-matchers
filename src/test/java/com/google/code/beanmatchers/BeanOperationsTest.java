package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithMissingGetter;
import com.google.code.beanmatchers.data.TestBeanWithMissingSetter;
import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import com.google.code.beanmatchers.data.TestBeanWithPrivateConstructor;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BeanOperationsTest {

  @Test
  public void canInstantiateClassUsingNoArgsConstructor() {
    // when
    TestBeanWithOneProperty bean = BeanOperations.instantiateBean(TestBeanWithOneProperty.class);

    // then
    assertThat(bean, is(notNullValue()));
  }

  @Test
  public void canInstantiateClassUsingPrivateNoArgsConstructor() {
    // when
    TestBeanWithPrivateConstructor bean = BeanOperations.instantiateBean(TestBeanWithPrivateConstructor.class);

    // then
    assertThat(bean, is(notNullValue()));
  }

  @Test
  public void canObtainNoArgsConstructor() {
    // when
    Constructor<TestBeanWithOneProperty> constructor = BeanOperations.noArgsConstructor(TestBeanWithOneProperty.class);

    // then
    assertThat(constructor, is(notNullValue()));
  }

  @Test
  public void canObtainPropertyDescriptorOfDefinedProperty() {
    // given
    TestBeanWithOneProperty bean = new TestBeanWithOneProperty();

    // when
    List<PropertyDescriptor> properties = BeanOperations.propertyDescriptors(bean.getClass(), anything());

    // then
    assertThat(properties, Matchers.<PropertyDescriptor>hasItem(hasProperty("name", equalTo("field1"))));
  }

  @Test
  public void canUseGetterToObtainPropertyValue() {
    // given
    Object expectedValue = "test value";
    TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
    bean.setField1(expectedValue);
    PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "field1");

    // when
    Object result = BeanOperations.invokeGetter(bean, propertyDescriptor);

    // then
    assertThat(result, is(expectedValue));
  }

  @Test(expectedExceptions = AccessorMissingException.class)
  public void shouldThrowExceptionIfGetterIsMissing() {
    // given
    Object value = "test value";
    TestBeanWithMissingGetter bean = new TestBeanWithMissingGetter();
    bean.setBadField(value);
    PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "badField");

    // when
    BeanOperations.invokeGetter(bean, propertyDescriptor);
  }

  @Test
  public void canUseSetterToSetPropertyValue() {
    // given
    Object value = "test value";
    TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
    PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "field1");

    // when
    BeanOperations.invokeSetter(bean, propertyDescriptor, value);

    // then
    assertThat(bean.getField1(), is(value));
  }

  @Test(expectedExceptions = AccessorMissingException.class)
  public void shouldThrowExceptionIfSetterIsMissing() {
    // given
    Object value = "test value";
    TestBeanWithMissingSetter bean = new TestBeanWithMissingSetter();
    PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "badField");

    // when
    BeanOperations.invokeSetter(bean, propertyDescriptor, value);
  }

  private PropertyDescriptor propertyDescriptor(Object bean, String propertyName) {
    for (PropertyDescriptor propertyDescriptor : BeanOperations.propertyDescriptors(bean.getClass(), anything())) {
      if (propertyDescriptor.getName().equals(propertyName)) {
        return propertyDescriptor;
      }
    }
    throw new AssertionError("No property descriptor for property " + propertyName);
  }

  @Test
  public void canGetMethod() {
    // given
    Class<String> type = String.class;
    String methodName = "toString";

    // when
    Method method = BeanOperations.getDeclaredMethod(type, methodName);

    // then
    assertThat(method, is(notNullValue()));
  }

  @Test(expectedExceptions = BeanMatchersException.class)
  public void throwsExceptionGivenMethodDoesNotExist() {
    // given
    Class<String> type = String.class;
    String methodName = "methodDoesNotExist";

    // when
    BeanOperations.getDeclaredMethod(type, methodName);
  }

  @Test
  public void canInvokeMethod() throws Exception {
    // given
    String object = "the instance";
    Method method = String.class.getMethod("hashCode", new Class[]{});

    // when
    Object result = BeanOperations.invokeMethod(object, method);

    // then
    assertThat(result, isA(Integer.class));
  }

  @Test(expectedExceptions = BeanMatchersException.class)
  public void throwsExceptionGivenObjectIsNullAndInstanceMethod() throws Exception {
    // given
    String object = null;
    Method method = String.class.getMethod("hashCode", new Class[]{});

    // when
    BeanOperations.invokeMethod(object, method);
  }
}
