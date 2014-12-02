package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasToStringDescribingPropertiesMatcher<T> extends AbstractBeanToStringMatcher<T> {


    private final List<String> excludedProperties;

    public HasToStringDescribingPropertiesMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matchesSafely(T beanType, Description mismatchDescription) {
        JavaBean bean = new JavaBean(beanType);
        return super.toStringDescribesProperties(bean, excludedProperties, mismatchDescription);
    }

    public void describeTo(Description description) {
        description.appendText("bean with toString() describing class name and the properties ");
        description.appendValue(excludedProperties);
    }
}
