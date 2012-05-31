package com.google.code.beanmatchers;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.invokeGetter;
import static com.google.code.beanmatchers.BeanOperations.invokeSetter;
import static com.google.code.beanmatchers.BeanOperations.propertyDescriptors;

class JavaBean {

    private final Object targetBean;
    private final PropertyDescriptor[] descriptors;

    public JavaBean(Object targetBean) {
        this.targetBean = targetBean;
        descriptors = propertyDescriptors(targetBean);
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
        List<String> properties = new ArrayList<String>(descriptors.length);
        for (PropertyDescriptor descriptor : descriptors) {
            properties.add(descriptor.getName());
        }
        properties.remove("class");
        return properties;
    }
}
