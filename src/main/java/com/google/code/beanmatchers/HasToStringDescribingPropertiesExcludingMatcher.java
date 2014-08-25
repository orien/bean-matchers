package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanOperations.properties;
import static com.google.code.beanmatchers.BeanOperations.propertyDescriptors;
import static java.util.Arrays.asList;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.core.IsAnything;

public class HasToStringDescribingPropertiesExcludingMatcher<T> extends AbstractBeanToStringMatcher<T> {

    private final List<String> excludedProperties;

    public HasToStringDescribingPropertiesExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matchesSafely(Class beanType, Description mismatchDescription) {
        List<String> properties = properties(propertyDescriptors(beanType), IsAnything.anything());
        properties.removeAll(excludedProperties);
        return super.toStringDescribesProperties(beanType, properties, mismatchDescription);
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
