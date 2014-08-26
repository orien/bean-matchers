package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.lang.reflect.Array;
import java.util.List;

abstract class AbstractBeanToStringMatcher<T> extends TypeSafeDiagnosingMatcher<T> {
    final TypeBasedValueGenerator valueGenerator;

    AbstractBeanToStringMatcher(TypeBasedValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }
    
    protected boolean toStringDescribesProperties(JavaBean bean, List<String> properties, Description mismatchDescription) {
        String toStringResult = bean.toString();
        String sn = bean.beanType().getSimpleName();
        if (!toStringResult.contains(bean.beanType().getSimpleName())) {
            describeToStringMismatch(bean.beanType(), mismatchDescription)
                    .appendText("It did not produce the bean class name: ")
                    .appendValue(toStringResult);
            return false;
        }
        for (String property : properties) {
            Object value = valueGenerator.generate(bean.propertyType(property));
            bean.setProperty(property, value);
            toStringResult = bean.toString();
            if (!toStringResult.contains(property)) {
                describeToStringMismatch(bean.beanType(), mismatchDescription)
                        .appendText("It did not produce the property name ")
                        .appendValue(property)
                        .appendText(", actual output ")
                        .appendValue(toStringResult);
                return false;
            }
            if (resultDoesNotContainValue(toStringResult, value)) {
                describeToStringMismatch(bean.beanType(), mismatchDescription)
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
