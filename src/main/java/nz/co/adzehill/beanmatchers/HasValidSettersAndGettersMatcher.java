package nz.co.adzehill.beanmatchers;

import org.hamcrest.Description;

public class HasValidSettersAndGettersMatcher<T> extends AbstractBeanAccessorMatcher<T> {
    private String[] properties;

    public HasValidSettersAndGettersMatcher(TypeBasedValueGenerator valueGenerator, String... properties) {
        super(valueGenerator);
        this.properties = properties;
    }

    public boolean matches(Object subject) {
        JavaBean bean = new JavaBean(subject);
        for (String property : properties) {
            if (!beanHasValidGetterAndSetterForProperty(bean, property)) {
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
