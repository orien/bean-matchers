package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.lang.reflect.Array;
import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.instantiateBean;
import static com.google.code.beanmatchers.BeanOperations.properties;
import static java.util.Arrays.asList;

public class HasToStringDescribingPropertiesExcludingMatcher extends TypeSafeDiagnosingMatcher<Class> {

    private final TypeBasedValueGenerator valueGenerator;
    private final List<String> excludedProperties;

    public HasToStringDescribingPropertiesExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        this.valueGenerator = valueGenerator;
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matchesSafely(Class beanType, Description mismatchDescription) {
        Object instance = instantiateBean(beanType);
        String toStringResult = instance.toString();
        if (!toStringResult.contains(beanType.getSimpleName())) {
            describeToStringMismatch(beanType, mismatchDescription)
                    .appendText("It did not produce the bean class name: ")
                    .appendValue(toStringResult);
            return false;
        }
        for (String property : properties(beanType)) {
            if (excludedProperties.contains(property)) {
                continue;
            }
            JavaBean bean = new JavaBean(beanType);
            Object value = valueGenerator.generate(bean.propertyType(property));
            bean.setProperty(property, value);
            toStringResult = bean.toString();
            if (!toStringResult.contains(property)) {
                describeToStringMismatch(beanType, mismatchDescription)
                        .appendText("It did not produce the property name ")
                        .appendValue(property)
                        .appendText(": ")
                        .appendValue(toStringResult);
                return false;
            }
            if (resultDoesNotContainValue(toStringResult, value)) {
                describeToStringMismatch(beanType, mismatchDescription)
                        .appendText("It did not produce the value for property ")
                        .appendValue(property)
                        .appendText(": ")
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

    public void describeTo(Description description) {
        if (excludedProperties.isEmpty()) {
            description.appendText("bean with toString() describing class name and all properties");
        } else {
            description.appendText("bean with toString() describing class name and all properties excluding ");
            description.appendValue(excludedProperties);
        }
    }
}
