package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanOperations.instantiateBean;
import static com.google.code.beanmatchers.BeanOperations.invokeGetter;
import static com.google.code.beanmatchers.BeanOperations.invokeSetter;
import static com.google.code.beanmatchers.BeanOperations.propertyDescriptors;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.notNullValue;

import java.beans.PropertyDescriptor;
import java.util.List;
import org.hamcrest.Matchers;

class JavaBean {

  private final Object targetBean;
  private final List<PropertyDescriptor> descriptors;

  public JavaBean(Object targetBean, boolean excludeAsynAccessors) {
    this.targetBean = targetBean;
    if (excludeAsynAccessors) {
      descriptors = propertyDescriptors(beanType(), allOf(
              hasProperty("readMethod", notNullValue()),
              hasProperty("writeMethod", notNullValue())));
    } else {
      descriptors = propertyDescriptors(beanType(), anything());
    }
  }

  public JavaBean(Object targetBean) {
    this(targetBean, false);
  }

  public JavaBean(Class targetBeanType) {
    this(instantiateBean(targetBeanType), false);
  }

  public Class beanType() {
    return targetBean.getClass();
  }

  public Class<?> propertyType(String propertyName) {
    return descriptorForName(propertyName).getPropertyType();
  }

  public void setProperty(String propertyName, Object value) {
    invokeSetter(targetBean, descriptorForName(propertyName), value);
  }

  public Object getProperty(String propertyName) {
    return invokeGetter(targetBean, descriptorForName(propertyName));
  }

  private PropertyDescriptor descriptorForName(String propertyName) {
    for (PropertyDescriptor propertyDescriptor : descriptors) {
      if (propertyDescriptor.getName().equals(propertyName)) {
        return propertyDescriptor;
      }
    }
    throw new BeanMatchersException(
        "No property named '" + propertyName + "' on bean " + targetBean);
  }

  public List<String> properties() {
    return BeanOperations.properties(descriptors);
  }

  public String toString() {
    return targetBean.toString();
  }

  @Override
  public int hashCode() {
    return targetBean.hashCode();
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof JavaBean) {
      return targetBean.equals(((JavaBean) object).targetBean);
    } else {
      return targetBean.equals(object);
    }
  }
}
