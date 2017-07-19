package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UuidGeneratorTest {

  private UuidGenerator unitUnderTest;

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new UuidGenerator();
  }

  @Test
  public void shouldProvideUuid() {
    // when
    UUID result = unitUnderTest.generate();

    // then
    assertThat(result, is(notNullValue()));
  }

  @Test
  public void shouldProvideDifferingUuidOnSubsequentCall() {
    // when
    UUID result1 = unitUnderTest.generate();
    UUID result2 = unitUnderTest.generate();

    // then
    assertThat(result1, is(not(equalTo(result2))));
  }
}
