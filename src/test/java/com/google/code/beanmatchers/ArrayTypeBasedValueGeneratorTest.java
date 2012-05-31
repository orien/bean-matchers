package com.google.code.beanmatchers;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ArrayTypeBasedValueGeneratorTest {

    @Test
    public void testGenerate() {
        // given
        TypeBasedValueGenerator unitUnderTest = new ArrayTypeBasedValueGenerator();

        // when
        int[] value = unitUnderTest.generate(int[].class);

        // then
        assertThat(value, is(notNullValue()));
    }
}
