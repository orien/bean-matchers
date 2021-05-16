package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShortGeneratorTest {

  private ShortGenerator unitUnderTest;

  private final Random random = new Random();

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new ShortGenerator(random);
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
