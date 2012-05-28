package nz.co.adzehill.beanmatchers;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.beans.Introspector.getBeanInfo;

final class BeanOperations {
    private BeanOperations() {
    }

    public static <T> PropertyDescriptor[] propertyDescriptors(T bean) {
        return propertyDescriptors(bean.getClass());
    }

    private static PropertyDescriptor[] propertyDescriptors(Class targetClass) {
        return beanInfo(targetClass).getPropertyDescriptors();
    }

    private static BeanInfo beanInfo(Class targetClass) {
        try {
            return getBeanInfo(targetClass);
        } catch (IntrospectionException e) {
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
        } catch (IllegalAccessException e) {
            throw new BeanMatchersException(e);
        } catch (InvocationTargetException e) {
            throw new BeanMatchersException(e);
        }
    }
}
