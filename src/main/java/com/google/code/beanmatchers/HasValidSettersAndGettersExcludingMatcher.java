package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidSettersAndGettersExcludingMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private List<String> excludedProperties;

    HasValidSettersAndGettersExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matches(Object item, Description mismatchDescription) {
        JavaBean bean = new JavaBean(item);
        for (String property : bean.properties()) {
            if (shouldValidateGetterAndSetterForProperty(property)
                    && !beanHasValidGetterAndSetterForProperty(bean, property)) {
                mismatchDescription
                        .appendText("bean of type ")
                        .appendValue(item.getClass().getName())
                        .appendText(" had an invalid getter/setter for the property ")
                        .appendValue(property);
                return false;
            }
        }
        return true;
    }

    private boolean shouldValidateGetterAndSetterForProperty(String property) {
        return !excludedProperties.contains(property);
    }

    public void describeTo(Description description) {
        if (excludedProperties.isEmpty()) {
            description.appendText("bean with valid setter and getter methods for all properties");
        } else {
            description.appendText("bean with valid setter and getter methods for all properties excluding ");
            description.appendValue(excludedProperties);
        }
    }
}
