package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.*;
import org.testng.annotations.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanMatchersTest {

    @Test
    public void testHasValidBeanConstructor() {
        assertThat(TestBeanWithOneProperty.class, hasValidBeanConstructor());
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
    public void testHasValidBeanHashCodeExcluding() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class, hasValidBeanHashCodeExcluding("property"));
    }

    @Test
    public void testHasValidBeanEquals() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidBeanEqualsExcluding() {
        assertThat(TestBeanWithPropertyThatDoesNotInfluenceEquals.class, hasValidBeanEqualsExcluding("propertyNotComparedInEquals"));
    }

    @Test
    public void testHasValidBeanToString() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanToString());
    }

    @Test
    public void testHasValidBeanToStringExcluding() {
        assertThat(TestBeanWithToStringMissingPropertyValue.class, hasValidBeanToStringExcluding("propertyValueMissingInToString"));
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
