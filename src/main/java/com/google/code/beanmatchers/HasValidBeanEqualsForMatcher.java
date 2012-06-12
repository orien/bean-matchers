package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidBeanEqualsForMatcher<T> extends AbstractBeanEqualsMatcher<T> {
    private final List<String> properties;

    HasValidBeanEqualsForMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
        super(valueGenerator);
        this.properties = asList(properties);
    }

    @Override
    protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
        return propertiesComparedDuringEquals(beanType, properties, mismatchDescription);
    }

    public void describeTo(Description description) {
        description.appendText("bean with the properties ");
        description.appendValue(properties);
        description.appendText(" compared in equals");
    }
}
