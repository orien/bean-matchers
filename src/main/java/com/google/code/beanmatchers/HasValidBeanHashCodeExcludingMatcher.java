package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.List;

import static com.google.code.beanmatchers.BeanOperations.properties;
import static java.util.Arrays.asList;

public class HasValidBeanHashCodeExcludingMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
    private final List<String> excludedProperties;
    private final TypeBasedValueGenerator valueGenerator;

    HasValidBeanHashCodeExcludingMatcher(TypeBasedValueGenerator valueGenerator, String... excludedProperties) {
        this.excludedProperties = asList(excludedProperties);
        this.valueGenerator = valueGenerator;
    }

    @Override
    protected boolean matchesSafely(Class<T> beanType, Description mismatchDescription) {
        for (String property : properties(beanType)) {
            JavaBean bean = new JavaBean(beanType);
            if (shouldValidateHashCodeForProperty(property)
                    && hashCodeNotInfluencedByProperty(bean, property)) {
                mismatchDescription
                        .appendText("bean of type ")
                        .appendValue(beanType.getName())
                        .appendText(" had a hashCode not influenced by the property ")
                        .appendValue(property);
                return false;
            }
        }
        return true;
    }

    private boolean shouldValidateHashCodeForProperty(String property) {
        return !excludedProperties.contains(property);
    }

    private boolean hashCodeNotInfluencedByProperty(JavaBean bean, String property) {
        int initialHashCode = bean.hashCode();
        Class<?> propertyType = bean.propertyType(property);
        bean.setProperty(property, valueGenerator.generate(propertyType));
        int influencedHashCode = bean.hashCode();
        return initialHashCode == influencedHashCode;
    }

    public void describeTo(Description description) {
        if (excludedProperties.isEmpty()) {
            description.appendText("bean with all properties influencing hashCode");
        } else {
            description.appendText("bean with all properties excluding ");
            description.appendValue(excludedProperties);
            description.appendText(" influencing hashCode");
        }
    }
}
