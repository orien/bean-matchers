package nz.co.adzehill.beanmatchers;

import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidSettersAndGettersExcludingMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private List<String> excludedProperties;

    public HasValidSettersAndGettersExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        super(valueGenerator);
        this.excludedProperties = asList(excludedProperties);
    }

    public boolean matches(Object subject) {
        JavaBean bean = new JavaBean(subject);
        for (String property : bean.properties()) {
            if (shouldValidateGetterAndSetterForProperty(property)
                    && !beanHasValidGetterAndSetterForProperty(bean, property)) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldValidateGetterAndSetterForProperty(String property) {
        return !excludedProperties.contains(property);
    }

    public void describeTo(Description description) {
        description.appendText("bean with valid setter and getter methods for all properties excluding ");
        description.appendValue(excludedProperties);
    }
}
