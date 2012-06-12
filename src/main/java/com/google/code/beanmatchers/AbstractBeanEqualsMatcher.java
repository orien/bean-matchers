package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import java.util.List;

import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;

abstract class AbstractBeanEqualsMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
    final TypeBasedValueGenerator valueGenerator;

    AbstractBeanEqualsMatcher(TypeBasedValueGenerator valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    protected boolean propertiesComparedDuringEquals(Class<T> beanType, List<String> properties, Description mismatchDescription) {
        for (String property : properties) {
            if (propertyNotComparedDuringEquals(beanType, property)) {
                mismatchDescription
                        .appendText("bean of type ")
                        .appendValue(beanType.getName())
                        .appendText(" had property ")
                        .appendValue(property)
                        .appendText(" not compared during equals operation");
                return false;
            }
        }
        return true;
    }

    private boolean propertyNotComparedDuringEquals(Class<T> beanType, String property) {
        JavaBean beanOne = new JavaBean(beanType);
        Class<?> propertyType = beanOne.propertyType(property);
        DistinctValues values = generateTwoDistinctValues(valueGenerator, propertyType);
        beanOne.setProperty(property, values.getValueOne());
        JavaBean beanTwo = new JavaBean(beanType);
        beanTwo.setProperty(property, values.getValueTwo());
        return beanOne.equals(beanTwo);
    }
}
