package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithBadSetter;
import com.google.code.beanmatchers.data.TestBeanWithManyProperties;
import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import org.testng.annotations.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidSettersAndGetters;
import static com.google.code.beanmatchers.BeanMatchers.hasValidSettersAndGettersExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidSettersAndGettersFor;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanMatchersTest {

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
}
