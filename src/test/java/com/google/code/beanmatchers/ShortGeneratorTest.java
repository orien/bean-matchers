package com.google.code.beanmatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShortGeneratorTest {

  private ShortGenerator unitUnderTest;

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new ShortGenerator(new Random());
  }

  @Test
  public void shouldProvideValue() {
    // when
    Short result = unitUnderTest.generate();

    // then
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void shouldProvideDifferingValueOnSubsequentCall() {
    // when
    Short result1 = unitUnderTest.generate();
    Short result2 = unitUnderTest.generate();

    // then
    assertThat(result1, is(not(equalTo(result2))));
  }
}
