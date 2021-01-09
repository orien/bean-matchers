package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import java.util.Random;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListGeneratorTest {

  private ListGenerator unitUnderTest;

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new ListGenerator(new Random());
  }

  @Test
  public void shouldProvideList() {
    // when
    List result = unitUnderTest.generate();

    // then
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void shouldProvideDifferingValueOnSubsequentCall() {
    // when
    List result1 = unitUnderTest.generate();
    List result2 = unitUnderTest.generate();

    // then
    assertThat(result1, is(not(equalTo(result2))));
  }
}
