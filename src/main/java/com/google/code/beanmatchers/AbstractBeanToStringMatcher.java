package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.lang.reflect.Array;
import java.util.List;

abstract class AbstractBeanToStringMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
    final TypeBasedValueGenerator valueGenerator;

    AbstractBeanToStringMatcher(TypeBasedValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    protected boolean toStringDescribesProperties(Class beanType, List<String> properties, Description mismatchDescription) {
        String toStringResult = new JavaBean(beanType).toString();
        if (!toStringResult.contains(beanType.getSimpleName())) {
            describeToStringMismatch(beanType, mismatchDescription)
                    .appendText("It did not produce the bean class name: ")
                    .appendValue(toStringResult);
            return false;
        }
        for (String property : properties) {
            JavaBean bean = new JavaBean(beanType);
            Object value = valueGenerator.generate(bean.propertyType(property));
            bean.setProperty(property, value);
            toStringResult = bean.toString();
            if (!toStringResult.contains(property)) {
                describeToStringMismatch(beanType, mismatchDescription)
                        .appendText("It did not produce the property name ")
                        .appendValue(property)
                        .appendText(", actual output ")
                        .appendValue(toStringResult);
                return false;
            }
            if (resultDoesNotContainValue(toStringResult, value)) {
                describeToStringMismatch(beanType, mismatchDescription)
                        .appendText("It did not produce the value for property ")
                        .appendValue(property)
                        .appendText(", actual output ")
                        .appendValue(toStringResult);
                return false;
            }
        }
        return true;
    }

    private boolean resultDoesNotContainValue(String toStringResult, Object value) {
        if (value.getClass().isArray()) {
            for (int i = 0; i < Array.getLength(value); i++) {
                if (resultDoesNotContainValue(toStringResult, Array.get(value, i))) {
                    return true;
                }
            }
            return false;
        } else {
            return !toStringResult.contains(value.toString());
        }
    }

    private Description describeToStringMismatch(Class beanType, Description mismatchDescription) {
        return mismatchDescription
                .appendText("bean of type ")
                .appendValue(beanType.getName())
                .appendText(" had an invalid toString() method. ");
    }
}
