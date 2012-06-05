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
    public void testHasValidSettersAndGettersFor() {
        assertThat(new TestBeanWithOneProperty(), hasValidSettersAndGettersFor("field1"));
    }

    @Test
    public void testHasValidSettersAndGettersExcluding() {
        assertThat(new TestBeanWithBadSetter(), hasValidSettersAndGettersExcluding("badField"));
    }

    @Test
    public void testHasValidSettersAndGetters() {
        assertThat(new TestBeanWithManyProperties(), hasValidSettersAndGetters());
    }

    @Test
    public void testHasValidToString() {
        assertThat(TestBeanWithManyProperties.class, hasValidToString());
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator() {
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), hasValidSettersAndGetters());
    }

    @Test(dependsOnMethods = "shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator")
    public void canRegisterCustomValueGenerator() {
        BeanMatchers.registerValueGenerator(new CustomValueGenerator(), ObjectNeedingCustomValueGenerator.class);
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), hasValidSettersAndGetters());
    }
}
