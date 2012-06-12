package com.google.code.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidGettersAndSettersExcludingMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private List<String> excludedProperties;

    HasValidGettersAndSettersExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matches(Object item, Description mismatchDescription) {
        JavaBean bean = new JavaBean(item);
        List<String> properties = bean.properties();
        properties.removeAll(excludedProperties);
        return super.beanHasValidGetterAndSetterForProperties(bean, properties, mismatchDescription);
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
