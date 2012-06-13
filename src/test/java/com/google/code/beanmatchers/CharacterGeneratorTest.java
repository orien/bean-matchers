package com.google.code.beanmatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CharacterGeneratorTest {

    private CharacterGenerator unitUnderTest;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new CharacterGenerator(new Random());
    }

    @Test
    public void shouldProvideValue() {
        // when
        Character result = unitUnderTest.generate();

        // then
        assertThat(result, is(notNullValue()));
    }

    @Test
    public void shouldProvideDifferingValueOnSubsequentCall() {
        // when
        Character result1 = unitUnderTest.generate();
        Character result2 = unitUnderTest.generate();

        // then
        assertThat(result1, is(not(equalTo(result2))));
    }
}
