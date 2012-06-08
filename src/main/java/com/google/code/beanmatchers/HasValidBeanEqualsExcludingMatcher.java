package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.properties;
import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;
import static java.util.Arrays.asList;

public class HasValidBeanEqualsExcludingMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
    private final List<String> excludedProperties;
    private final TypeBasedValueGenerator valueGenerator;

    HasValidBeanEqualsExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        this.excludedProperties = asList(excludedProperties);
        this.valueGenerator = valueGenerator;
    }

    @Override
    protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
        for (String property : properties(beanType)) {
            if (shouldValidateEqualsForProperty(property)
                    && propertyNotComparedDuringEquals(beanType, property)) {
                mismatchDescription
                        .appendText("bean of type ")
                        .appendValue(beanType.getName())
                        .appendText(" had property ")
                        .appendValue(property)
                        .appendText(" not compared during equals operation");
                return false;
            }
        }
        return true;
    }

    private boolean shouldValidateEqualsForProperty(String property) {
        return !excludedProperties.contains(property);
    }

    private boolean propertyNotComparedDuringEquals(Class<T> beanType, String property) {
        JavaBean beanOne = new JavaBean(beanType);
        Class<?> propertyType = beanOne.propertyType(property);
        DistinctValues values = generateTwoDistinctValues(valueGenerator, propertyType);
        beanOne.setProperty(property, values.getValueOne());
        JavaBean beanTwo = new JavaBean(beanType);
        beanTwo.setProperty(property, values.getValueTwo());
        return beanOne.equals(beanTwo);
    }

    public void describeTo(Description description) {
        if (excludedProperties.isEmpty()) {
            description.appendText("bean with all properties compared in equals");
        } else {
            description.appendText("bean with all properties excluding ");
            description.appendValue(excludedProperties);
            description.appendText(" compared in equals");
        }
    }
}
