package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanOperations.instantiateBean;
import static com.google.code.beanmatchers.BeanOperations.invokeGetter;
import static com.google.code.beanmatchers.BeanOperations.invokeSetter;
import static com.google.code.beanmatchers.BeanOperations.propertyDescriptors;

import java.beans.PropertyDescriptor;
import java.util.List;

import org.hamcrest.core.IsAnything;

class JavaBean {

    private final Object targetBean;
    private final PropertyDescriptor[] descriptors;

    public JavaBean(Object targetBean) {
        if (targetBean instanceof Class) {
            this.targetBean = instantiateBean((Class<Object>) targetBean);
        } else {
            this.targetBean = targetBean;
        }
        descriptors = propertyDescriptors(targetBean);
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
        for (PropertyDescriptor propertyDescriptor: descriptors) {
            if (propertyDescriptor.getName().equals(propertyName)) {
                return propertyDescriptor;
            }
        }
        throw new BeanMatchersException("No property named '" + propertyName + "' on bean " + targetBean);
    }

    public List<String> properties() {
        return BeanOperations.properties(descriptors, IsAnything.anything());
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

    @Override
    protected JavaBean clone() {
        JavaBean result = null;

        try {
            result = (JavaBean) super.clone();
        } catch (CloneNotSupportedException e) {
            // FIXME hsyn: won't work for beans without no-args constructor
            result = new JavaBean(this.beanType());
        }
        
        return result;
    }    
}
