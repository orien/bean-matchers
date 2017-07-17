package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
