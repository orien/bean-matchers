package com.google.code.beanmatchers;

import org.hamcrest.Description;

public class HasValidSettersAndGettersMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private String[] properties;

    HasValidSettersAndGettersMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
        super(valueGenerator);
        this.properties = properties;
    }

    @Override
    protected boolean matches(Object item, Description mismatchDescription) {
        JavaBean bean = new JavaBean(item);
        for (String property : properties) {
            if (!beanHasValidGetterAndSetterForProperty(bean, property)) {
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

    public void describeTo(Description description) {
        description.appendText("bean with valid setter and getter methods for properties ");
        description.appendValue(properties);
    }
}
