package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.*;
import org.testng.annotations.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class BeanMatchersTest {

    @Test
    public void testHasValidBeanConstructor() {
        assertThat(TestBeanWithOneProperty.class, hasValidBeanConstructor());
    }

    @Test
    public void testHasValidBeanConstructorWithOneProperty() {
        Class[] types = {Object.class};
        assertThat(TestBeanWithArgumentConstructor.class, hasAConstructorWithParameterTypes(types));
    }

    @Test
    public void testHasValidBeanConstructorWithOnePropertyAndError() {
        Class[] types = {Double.class}; // Incompatible argument types
        assertThat(TestBeanWithArgumentConstructor.class, not(hasAConstructorWithParameterTypes(types)));
    }

    @Test
    public void testBeanHasValidGettersAndSettersFor() {
        assertThat(new TestBeanWithOneProperty(), isABeanWithValidGettersAndSettersFor("field1"));
    }

    @Test
    public void testHasValidGettersAndSettersFor() {
        assertThat(TestBeanWithOneProperty.class, hasValidGettersAndSettersFor("field1"));
    }

    @Test
    public void testBeanHasValidGettersAndSettersExcluding() {
        assertThat(new TestBeanWithBadSetter(), isABeanWithValidGettersAndSettersExcluding("badField"));
    }

    @Test
    public void testHasValidGettersAndSettersExcluding() {
        assertThat(TestBeanWithBadSetter.class, hasValidGettersAndSettersExcluding("badField"));
    }

    @Test
    public void testBeanHasValidGettersAndSetters() {
        assertThat(new TestBeanWithManyProperties(), isABeanWithValidGettersAndSetters());
    }

    @Test
    public void testHasValidGettersAndSetters() {
        assertThat(TestBeanWithManyProperties.class, hasValidGettersAndSetters());
    }

    @Test
    public void testHasValidBeanHashCode() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanHashCode());
    }

    @Test
    public void testHasValidBeanHashCodeFor() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class, hasValidBeanHashCodeFor());
    }

    @Test
    public void testHasValidBeanHashCodeExcluding() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class, hasValidBeanHashCodeExcluding("property"));
    }

    @Test
    public void testHasValidBeanEquals() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidBeanEqualsOnNonReflectedEquals() {
      assertThat(TestBeanWithTwoPropertiesAndNonReflectedEquals.class, hasValidBeanEqualsFor("field1", "field2"));
    }

    @Test
    public void testHasValidBeanEqualsExcluding() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceEquals.class, hasValidBeanEqualsExcluding("propertyNotComparedInEquals"));
    }

    @Test
    public void testHasValidBeanEqualsFor() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceEquals.class, hasValidBeanEqualsFor("propertyComparedInEquals"));
    }

    @Test
    public void testHasValidBeanToString() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanToString());
    }

    @Test
    public void testHasValidBeanToStringExcluding() {
        assertThat(TestBeanWithToStringMissingPropertyValue.class, hasValidBeanToStringExcluding("propertyValueMissingInToString"));
    }

    @Test
    public void testHasValidBeanToStringFor() {
        assertThat(TestBeanWithToStringMissingPropertyValue.class, hasValidBeanToStringFor());
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator() {
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isABeanWithValidGettersAndSetters());
    }

    @Test(dependsOnMethods = "shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator")
    public void canRegisterCustomValueGenerator() {
        BeanMatchers.registerValueGenerator(new CustomValueGenerator(), ObjectNeedingCustomValueGenerator.class);
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isABeanWithValidGettersAndSetters());
    }
}
