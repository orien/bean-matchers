package nz.co.adzehill.beanmatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class HasValidSettersAndGettersMatcher<T> extends BaseMatcher<T> {
    private TypeBasedValueGenerator valueGenerator;
    private String[] properties;

    public HasValidSettersAndGettersMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
        this.valueGenerator = valueGenerator;
        this.properties = properties;
    }

    public boolean matches(Object subject) {
        JavaBean bean = new JavaBean(subject);
        for (String property : properties) {
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
        description.appendText("Unable to match setter and getter results for class properties: ");
        description.appendValue(properties);
    }
}
