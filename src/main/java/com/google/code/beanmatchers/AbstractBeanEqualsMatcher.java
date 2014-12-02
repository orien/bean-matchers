package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.List;

import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;

abstract class AbstractBeanEqualsMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
    final TypeBasedValueGenerator valueGenerator;

    AbstractBeanEqualsMatcher(TypeBasedValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    protected boolean isValidBeanEquals(JavaBean bean, List<String> properties, Description mismatchDescription) {
        if (equalsDoesNotHandleSameInstance(bean)) {
            describeMismatch(bean, mismatchDescription, " did not correctly identify same instance during equals operation");
            return false;
        }
        if (equalsDoesNotHandleNullValue(bean)) {
            describeMismatch(bean, mismatchDescription, " did not correctly identify null value during equals operation");
            return false;
        }
        if (equalsDoesNotHandleDifferingType(bean)) {
            describeMismatch(bean, mismatchDescription, " did not correctly identify differing type during equals operation");
            return false;
        }
        for (String property : properties) {
            if (propertyNotComparedDuringEquals(bean, property)) {
                describePropertyMismatch(bean, property, mismatchDescription, " not compared during equals operation");
                return false;
            }
            if (nullPropertyNotHandled(bean, property)) {
                describePropertyMismatch(bean, property, mismatchDescription, " not handling null during equals operation");
                return false;
            }
        }
        return true;
    }

    private void describeMismatch(JavaBean bean, Description description, String reason) {
        describeBean(bean, description).appendText(reason);
    }

    private void describePropertyMismatch(JavaBean beanType, String property, Description description, String reason) {
        describeBean(beanType, description).appendText(" had property ").appendValue(property).appendText(reason);
    }

    private Description describeBean(JavaBean bean, Description description) {
        return description.appendText("bean of type ").appendValue(bean.beanType().getName());
    }

    private boolean equalsDoesNotHandleSameInstance(JavaBean bean) {
        return !bean.equals(bean);
    }

    private boolean equalsDoesNotHandleNullValue(JavaBean bean) {
        try {
            return bean.equals(null);
        } catch (Exception e) {
            return true;
        }
    }

    private boolean equalsDoesNotHandleDifferingType(JavaBean bean) {
        return bean.equals(new TestType());
    }

    private boolean propertyNotComparedDuringEquals(JavaBean bean, String property) {
        JavaBean beanOne = bean.clone();        
        Class<?> propertyType = beanOne.propertyType(property);
        DistinctValues values = generateTwoDistinctValues(valueGenerator, propertyType);
        beanOne.setProperty(property, values.getValueOne());
        JavaBean beanWithDifferingPropertyValue = beanOne.clone();
        beanWithDifferingPropertyValue.setProperty(property, values.getValueTwo());
        JavaBean beanWithSamePropertyValue = beanOne.clone();
        beanWithSamePropertyValue.setProperty(property, values.getValueOne());
        return beanOne.equals(beanWithDifferingPropertyValue) || !beanOne.equals(beanWithSamePropertyValue);
    }

    private boolean nullPropertyNotHandled(JavaBean bean, String property) {
        JavaBean beanOne = bean.clone();
        Class<?> propertyType = beanOne.propertyType(property);
        if (propertyType.isPrimitive()) {
            return false;
        }
        Object value = valueGenerator.generate(propertyType);
        beanOne.setProperty(property, value);
        JavaBean beanTwo = beanOne.clone();
        beanTwo.setProperty(property, null);
        try {
            return beanOne.equals(beanTwo) || beanTwo.equals(beanOne);
        } catch (RuntimeException e) {
            return true;
        }
    }

    private static class TestType {}
}
