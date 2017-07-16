package com.google.code.beanmatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Random;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LongGeneratorTest {

  private LongGenerator unitUnderTest;

  @Mock
  private Random randomMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
    unitUnderTest = new LongGenerator(randomMock);
  }

  @Test
  public void shouldGenerateRandomValue() {
    // given
    Long expectedValue = 2342L;
    when(randomMock.nextLong()).thenReturn(expectedValue);

    // when
    Long result = unitUnderTest.generate();

    // then
    assertThat(result, is(expectedValue));
  }
}
