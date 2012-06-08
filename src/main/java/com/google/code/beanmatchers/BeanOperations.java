package com.google.code.beanmatchers;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static java.beans.Introspector.getBeanInfo;

final class BeanOperations {
    private BeanOperations() {}

    public static <T> T instantiateBean(Class<T> beanClass) {
        try {
            Constructor<T> constructor = noArgsConstructor(beanClass);
            return constructor.newInstance();
        } catch (InstantiationException e) {
            throw new BeanMatchersException("Could not instantiate bean with no-args constructor", e);
        } catch (IllegalAccessException e) {
            throw new BeanMatchersException("Could not instantiate bean with no-args constructor", e);
        } catch (InvocationTargetException e) {
            throw new BeanMatchersException("Could not instantiate bean with no-args constructor", e);
        }
    }

    public static <T> Constructor<T> noArgsConstructor(Class<T> beanClass) {
        try {
            return beanClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new BeanMatchersException("Bean does not have no-args constructor", e);
        }
    }

    public static List<String> properties(Class<?> beanType) {
        return properties(propertyDescriptors(beanType));
    }

    public static List<String> properties(PropertyDescriptor[] descriptors) {
        List<String> properties = new ArrayList<String>(descriptors.length);
        for (PropertyDescriptor descriptor : descriptors) {
            properties.add(descriptor.getName());
        }
        properties.remove("class");
        return properties;
    }

    public static <T> PropertyDescriptor[] propertyDescriptors(T bean) {
        return propertyDescriptors(bean.getClass());
    }

    private static PropertyDescriptor[] propertyDescriptors(Class<?> beanType) {
        return beanInfo(beanType).getPropertyDescriptors();
    }

    private static BeanInfo beanInfo(Class targetClass) {
        try {
            return getBeanInfo(targetClass);
        } catch (Exception e) {
            throw new BeanMatchersException(e);
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

    private static Object invokeMethod(Object bean, Method method, Object... args) {
        try {
            return method.invoke(bean, args);
        } catch (Exception e) {
            throw new BeanMatchersException(e);
        }
    }
}
