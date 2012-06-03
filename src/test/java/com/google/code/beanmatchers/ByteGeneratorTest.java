package com.google.code.beanmatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ByteGeneratorTest {

    private ByteGenerator unitUnderTest;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new ByteGenerator(new Random());
    }

    @Test
    public void shouldProvideValue() {
        // when
        Byte result = unitUnderTest.generate();

        // then
        assertThat(result, is(notNullValue()));
    }

    @Test
    public void shouldProvideDifferingValueOnSubsequentCall() {
        // when
        Byte result1 = unitUnderTest.generate();
        Byte result2 = unitUnderTest.generate();

        // then
        assertThat(result1, is(not(equalTo(result2))));
    }
}
