package com.google.code.beanmatchers;

import static java.util.Arrays.asList;

import java.util.List;

import org.hamcrest.Description;

public class HasToStringDescribingPropertiesExcludingMatcher<T> extends AbstractBeanToStringMatcher<T> {

    private final List<String> excludedProperties;

    public HasToStringDescribingPropertiesExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matchesSafely(T beanType, Description mismatchDescription) {
        JavaBean bean = new JavaBean(beanType);
        List<String> properties = bean.properties();
        properties.removeAll(excludedProperties);
        return super.toStringDescribesProperties(bean, properties, mismatchDescription);
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
