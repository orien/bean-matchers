package com.google.code.beanmatchers;

import org.testng.annotations.Test;

import static com.google.code.beanmatchers.ExtraMatchers.mock;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MockingTypeBasedValueGeneratorTest {

  @Test
  public void testGenerate() {
    // given
    TypeBasedValueGenerator unitUnderTest = new MockingTypeBasedValueGenerator();

    // when
    Object value = unitUnderTest.generate(Object.class);

    // then
    assertThat(value, is(mock()));
  }
}
