package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collection;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListGeneratorTest {

  private ListGenerator unitUnderTest;

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new ListGenerator();
  }

  @Test
  public void shouldProvideUuid() {
    // when
    Collection result = unitUnderTest.generate();

    // then
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void shouldProvideDifferingUuidOnSubsequentCall() {
    // when
    Collection result1 = unitUnderTest.generate();
    Collection result2 = unitUnderTest.generate();

    // then
    assertThat(result1, is(not(sameInstance(result2))));
  }
}
