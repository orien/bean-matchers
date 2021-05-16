package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Random;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CharacterGeneratorTest {

  private CharacterGenerator unitUnderTest;

  private final Random random = new Random();

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new CharacterGenerator(random);
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
