package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.properties;
import static java.util.Arrays.asList;

public class HasValidBeanEqualsExcludingMatcher<T> extends AbstractBeanEqualsMatcher<T> {
    private final List<String> excludedProperties;

    HasValidBeanEqualsExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
        List<String> properties = properties(beanType);
        properties.removeAll(excludedProperties);
        return isValidBeanEquals(beanType, properties, mismatchDescription);
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
