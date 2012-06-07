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
    public void testHasValidGettersAndSettersFor() {
        assertThat(new TestBeanWithOneProperty(), hasValidGettersAndSettersFor("field1"));
    }

    @Test
    public void testHasValidGettersAndSettersExcluding() {
        assertThat(new TestBeanWithBadSetter(), hasValidGettersAndSettersExcluding("badField"));
    }

    @Test
    public void testHasValidGettersAndSetters() {
        assertThat(new TestBeanWithManyProperties(), hasValidGettersAndSetters());
    }

    @Test
    public void testHasValidBeanHashCode() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanHashCode());
    }

    @Test
    public void testHasValidToString() {
        assertThat(TestBeanWithManyProperties.class, hasValidToString());
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator() {
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), hasValidGettersAndSetters());
    }

    @Test(dependsOnMethods = "shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator")
    public void canRegisterCustomValueGenerator() {
        BeanMatchers.registerValueGenerator(new CustomValueGenerator(), ObjectNeedingCustomValueGenerator.class);
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), hasValidGettersAndSetters());
    }
}
