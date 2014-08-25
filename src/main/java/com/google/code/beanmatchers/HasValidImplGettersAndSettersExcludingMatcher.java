package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanOperations.properties;
import static com.google.code.beanmatchers.BeanOperations.propertyDescriptors;
import static java.util.Arrays.asList;

import java.util.List;

import org.hamcrest.Description;

public class HasValidImplGettersAndSettersExcludingMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private List<String> excludedProperties;

    HasValidImplGettersAndSettersExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    @Override
    protected boolean matches(Object item, Description mismatchDescription) {
        JavaBean bean = new JavaBean(item);
        List<String> properties = properties(propertyDescriptors(item), PropertyDescriptorMatchers.WITH_GETTER_AND_SETTER);
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
