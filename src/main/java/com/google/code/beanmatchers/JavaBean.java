package com.google.code.beanmatchers;

import java.beans.PropertyDescriptor;
import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.*;

class JavaBean {

    private final Object targetBean;
    private final PropertyDescriptor[] descriptors;

    public JavaBean(Object targetBean) {
        this.targetBean = targetBean;
        descriptors = propertyDescriptors(targetBean);
    }

    public JavaBean(Class targetBeanType) {
        this(instantiateBean(targetBeanType));
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
        for (PropertyDescriptor propertyDescriptor: descriptors) {
            if (propertyDescriptor.getName().equals(propertyName)) {
                return propertyDescriptor;
            }
        }
        throw new BeanMatchersException("No property named '" + propertyName + "' on bean " + targetBean);
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
