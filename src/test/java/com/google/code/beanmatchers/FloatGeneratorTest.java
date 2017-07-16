package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Random;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FloatGeneratorTest {

  private FloatGenerator unitUnderTest;

  @Mock
  private Random randomMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
    unitUnderTest = new FloatGenerator(randomMock);
  }

  @Test
  public void shouldGenerateRandomValue() {
    // given
    Float expectedValue = 342.32F;
    when(randomMock.nextFloat()).thenReturn(expectedValue);

    // when
    Float result = unitUnderTest.generate();

    // then
    assertThat(result, is(expectedValue));
  }
}
