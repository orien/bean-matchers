package com.google.code.beanmatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SetGeneratorTest {

  private SetGenerator unitUnderTest;

  private final Random random = new Random();

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new SetGenerator(random);
  }

  @Test
  public void shouldProvideList() {
    // when
    Set result = unitUnderTest.generate();

    // then
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void shouldProvideDifferingValueOnSubsequentCall() {
    // when
    Set result1 = unitUnderTest.generate();
    Set result2 = unitUnderTest.generate();

    // then
    assertThat(result1, is(not(equalTo(result2))));
  }
}
