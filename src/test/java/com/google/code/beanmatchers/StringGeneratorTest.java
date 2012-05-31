package com.google.code.beanmatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringGeneratorTest {

    private StringGenerator unitUnderTest;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new StringGenerator();
    }

    @Test
    public void shouldProvideString() {
        // when
        String result = unitUnderTest.generate();

        // then
        assertThat(result, is(notNullValue()));
    }

    @Test
    public void shouldProvideDifferingStringOnSubsequentCall() {
        // when
        String result1 = unitUnderTest.generate();
        String result2 = unitUnderTest.generate();

        // then
        assertThat(result1, is(not(equalTo(result2))));
    }
}
