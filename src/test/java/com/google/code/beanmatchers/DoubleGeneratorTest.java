package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Random;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleGeneratorTest {

  private DoubleGenerator unitUnderTest;

  @Mock
  private Random randomMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
    unitUnderTest = new DoubleGenerator(randomMock);
  }

  @Test
  public void shouldGenerateRandomValue() {
    // given
    Double expectedDouble = 743.232;
    when(randomMock.nextDouble()).thenReturn(expectedDouble);

    // when
    Double result = unitUnderTest.generate();

    // then
    assertThat(result, is(expectedDouble));
  }
}
