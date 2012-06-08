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
        assertThat(new TestBeanWithOneProperty(), isBeanWithValidGettersAndSettersFor("field1"));
    }

    @Test
    public void testHasValidGettersAndSettersFor() {
        assertThat(TestBeanWithOneProperty.class, hasValidGettersAndSettersFor("field1"));
    }

    @Test
    public void testBeanHasValidGettersAndSettersExcluding() {
        assertThat(new TestBeanWithBadSetter(), isBeanWithValidGettersAndSettersExcluding("badField"));
    }

    @Test
    public void testHasValidGettersAndSettersExcluding() {
        assertThat(TestBeanWithBadSetter.class, hasValidGettersAndSettersExcluding("badField"));
    }

    @Test
    public void testBeanHasValidGettersAndSetters() {
        assertThat(new TestBeanWithManyProperties(), isBeanWithValidGettersAndSetters());
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
    public void testHasValidBeanEquals() {
        assertThat(TestBeanWithManyProperties.class, hasValidBeanEquals());
    }

    @Test
    public void testHasValidToString() {
        assertThat(TestBeanWithManyProperties.class, hasValidToString());
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator() {
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isBeanWithValidGettersAndSetters());
    }

    @Test(dependsOnMethods = "shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator")
    public void canRegisterCustomValueGenerator() {
        BeanMatchers.registerValueGenerator(new CustomValueGenerator(), ObjectNeedingCustomValueGenerator.class);
        assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isBeanWithValidGettersAndSetters());
    }
}
