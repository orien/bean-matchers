package nz.co.adzehill.beanmatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.List;

import static java.util.Arrays.asList;

public class HasValidSettersAndGettersExcludingMatcher<T> extends BaseMatcher<T> {
    private TypeBasedValueGenerator valueGenerator;
    private List<String> excludedProperties;

    public HasValidSettersAndGettersExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        this.valueGenerator = valueGenerator;
        this.excludedProperties = asList(excludedProperties);
    }

    public boolean matches(Object subject) {
        JavaBean bean = new JavaBean(subject);
        for (String property : bean.properties()) {
            if (excludedProperties.contains(property)) {
                continue;
            }
            Class<?> propertyType = bean.propertyType(property);
            Object testValue = valueGenerator.generate(propertyType);
            bean.setProperty(property, testValue);
            Object result = bean.getProperty(property);
            if (!testValue.equals(result)) {
                return false;
            }
        }
        return true;
    }

    public void describeTo(Description description) {
        description.appendText("bean with valid setter and getter methods for all properties excluding ");
        description.appendValue(excludedProperties);
    }
}
